package com.farm.gateway.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.farm.gateway.feign.ILogService;
import com.farm.api.vo.log.LogInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: DBLog.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-12 11:29:00 <br />
 * 最后修改: 2018-09-12 11:29:00 <br />
 * 修改历史: <br />
 */
@Slf4j
public class DBLog extends Thread {
    private static BlockingQueue<LogInfo> logInfoQueue = new LinkedBlockingQueue<>(1024);
    private static DBLog dblog = null;
    private ILogService logService;
    
    private DBLog() {
    	super("CLogOracleWriterThread");
    }
    
    public static synchronized DBLog getInstance() {
        if (dblog == null) {
            dblog = new DBLog();
        }
        return dblog;
    }
    
    public ILogService getLogService() {
    	return logService;
    }
    
    public DBLog setLogService(ILogService logService) {
    	if(null == this.logService) {
    		this.logService = logService;
    	}
    	return this;
    }
    
    public void offerQueue(LogInfo logInfo) {
        try {
            logInfoQueue.offer(logInfo);
        } catch (Exception e) {
            log.error("日志写入失败", e);
        }
    }
   
	@Override
	public void run() {
		List<LogInfo> bufferedLogList = new ArrayList<>();
		while (true) {
			try {
                bufferedLogList.add(logInfoQueue.take());
                logInfoQueue.drainTo(bufferedLogList);
                if (bufferedLogList != null && bufferedLogList.size() > 0) {
                    // 写入日志
                    for(LogInfo log : bufferedLogList){
                        logService.saveLog(log);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // 防止缓冲队列填充数据出现异常时不断刷屏
                try {
                    Thread.sleep(1000);
                } catch (Exception eee) {
                }
            } finally {
                if (bufferedLogList != null && bufferedLogList.size() > 0) {
                    try {
                        bufferedLogList.clear();
                    } catch (Exception e) {
                    }
                }
            }
		}
	}
}