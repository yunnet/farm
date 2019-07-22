package com.farm.common.web;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: ParameterRequestWrapper.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 16:55:00 <br />
 * 最后修改: 2018-09-03 16:55:00 <br />
 * 修改历史: <br />
 */
public class ParameterRequestWrapper extends HttpServletRequestWrapper {
	private Map params;

	/**
	 * 构造函数
	 * @param request
	 * @param newParams
	 */
	public ParameterRequestWrapper(HttpServletRequest request, Map newParams) {
		super(request);
		this.params = newParams;
	}

	@Override
	public Map getParameterMap() {
		return params;
	}

	@Override
	public Enumeration getParameterNames() {
		Vector v = new Vector<>(params.keySet());
		return v.elements();
	}
	
	@Override
    public String[] getParameterValues(String name) {
        Object v = params.get(name);
        if (v == null) {
            return null;
        } else if (v instanceof String[]) {
            return (String[]) v;
        } else if (v instanceof String) {
            return new String[] { (String) v };
        } else {
            return new String[] { v.toString() };
        }
    }

    @Override
    public String getParameter(String name) {
        Object v = params.get(name);
        if (v == null) {
            return null;
        } else if (v instanceof String[]) {
            String[] strArr = (String[]) v;
            return strArr.length > 0 ? strArr[0] : null;
        } else if (v instanceof String) {
            return (String) v;
        } else {
            return v.toString();
        }
    }
}