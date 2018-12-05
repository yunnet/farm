package com.farm.common.msg;

import java.util.List;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: TableResultResponse.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 15:30:07 <br />
 * 最后修改: 2018-09-03 15:30:07 <br />
 * 修改历史: <br />
 * @param <T>
 */
public class TableResultResponse<T> extends BaseResponse {

    private TableData<T> data;
    
    /**
     * 构造函数
     */
    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    /**
     * 构造函数
     * @param total
     * @param rows
     */
    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableData<T>(total, rows);
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    
    
    /**
     * 表数据结构
     */
	public class TableData<T> {
        private long total;
        private List<T> rows;

        public TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }
    }
}
