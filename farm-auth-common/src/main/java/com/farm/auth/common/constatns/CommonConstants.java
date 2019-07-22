package com.farm.auth.common.constatns;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: CommonConstants.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 17:06:57 <br />
 * 最后修改: 2018-09-03 17:06:57 <br />
 * 修改历史: <br />
 */
public final class CommonConstants {
	public final static String RESOURCE_TYPE_MENU = "menu";
	
    public final static String RESOURCE_TYPE_BTN = "button";
    
    public static final Integer EX_TOKEN_ERROR_CODE = 40101;
    
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40102;
    
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40131;
    
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    
    public static final Integer EX_OTHER_CODE = 500;
    
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    
    public static final String JWT_KEY_USER_ID = "userId";
    
    public static final String JWT_KEY_NAME = "name";
}
