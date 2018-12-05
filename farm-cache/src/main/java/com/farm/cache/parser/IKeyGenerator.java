package com.farm.cache.parser;

import com.farm.cache.constants.CacheScope;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: IKeyGenerator.java  <br />
 * 说        明:   缓存键值表达式<br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 13:42:33 <br />
 * 最后修改: 2018-09-05 13:42:33 <br />
 * 修改历史: <br />
 */
public abstract class IKeyGenerator {
	public static final String LINK = "_";
	
	/**
	 * 获取动态key
	 * @param key
	 * @param scope
	 * @param parameterTypes
	 * @param arguments
	 * @return
	 */
	public String getKey(String key, CacheScope scope, Class<?>[] parameterTypes, Object[] arguments) {
        StringBuffer sb = new StringBuffer("");
        key = buildKey(key, scope, parameterTypes, arguments);
        sb.append(key);
        
        if (CacheScope.user.equals(scope)) {
            if (getUserKeyGenerator() != null)
                sb.append(LINK).append(getUserKeyGenerator().getCurrentUserAccount());
        }
        return sb.toString();
    }
	
	/**
	 * 生成动态key
	 * @param key
	 * @param scope
	 * @param parameterTypes
	 * @param arguments
	 * @return
	 */
	public abstract String buildKey(String key, CacheScope scope, Class<?>[] parameterTypes, Object[] arguments);
	
	 /**
     * 当前登陆人key
     *
     * @param userKeyGenerator
     */
    public abstract IUserKeyGenerator getUserKeyGenerator();

}
