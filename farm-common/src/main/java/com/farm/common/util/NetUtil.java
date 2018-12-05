package com.farm.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: NetUtil.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 14:44:32 <br />
 * 最后修改: 2018-09-03 14:44:32 <br />
 * 修改历史: <br />
 */
public class NetUtil {
	
	/**
	 * 获取客户端真实ip
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
