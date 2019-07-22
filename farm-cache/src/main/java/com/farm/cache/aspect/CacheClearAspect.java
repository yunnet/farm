package com.farm.cache.aspect;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.cache.annotation.CacheClear;
import com.farm.cache.api.CacheAPI;
import com.farm.cache.constants.CacheScope;
import com.farm.cache.parser.IKeyGenerator;
import com.farm.cache.parser.impl.DefaultKeyGenerator;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: CacheClearAspect.java  <br />
 * 说        明: 清除缓存注解拦截 <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-05 14:20:20 <br />
 * 最后修改: 2018-09-05 14:20:20 <br />
 * 修改历史: <br />
 */
@Aspect
@Service
public class CacheClearAspect {
	private final Map<String, IKeyGenerator> generatorMap = new ConcurrentHashMap<>();
	
	@Autowired
    private IKeyGenerator keyParser;
	
    @Autowired
    private CacheAPI cacheAPI;
    
    @Pointcut("@annotation(com.farm.cache.annotation.CacheClear)")
    public void aspect() {
    }
    
    @Around("aspect()&&@annotation(anno)")
    public Object interceptor(ProceedingJoinPoint invocation, CacheClear anno) throws Throwable {
        MethodSignature signature = (MethodSignature) invocation.getSignature();
        Method method = signature.getMethod();
        
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] arguments = invocation.getArgs();
        String key = "";
        
        if (StringUtils.isNotBlank(anno.key())) {
            key = getKey(anno, anno.key(), CacheScope.application, parameterTypes, arguments);
            cacheAPI.remove(key);
        } else if (StringUtils.isNotBlank(anno.pre())) {
            key = getKey(anno, anno.pre(), CacheScope.application, parameterTypes, arguments);
            cacheAPI.removeByPre(key);
        } else if (anno.keys().length > 1) {
            for (String tmp : anno.keys()) {
                tmp = getKey(anno, tmp, CacheScope.application, parameterTypes, arguments);
                cacheAPI.removeByPre(tmp);
            }
        }
        return invocation.proceed();
    }

    /**
     * 解析表达式
     *
     * @param anno
     * @param parameterTypes
     * @param arguments
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private String getKey(CacheClear anno, String key, CacheScope scope, Class<?>[] parameterTypes, Object[] arguments) throws InstantiationException, IllegalAccessException {
        String generatorClsName = anno.generator().getName();
        IKeyGenerator keyGenerator = null;
        
        if (anno.generator().equals(DefaultKeyGenerator.class)) {
            keyGenerator = keyParser;
        } else {
            if (generatorMap.containsKey(generatorClsName)) {
                keyGenerator = generatorMap.get(generatorClsName);
            } else {
                keyGenerator = anno.generator().newInstance();
                generatorMap.put(generatorClsName, keyGenerator);
            }
        }
        
        String finalKey = keyGenerator.getKey(key, scope, parameterTypes, arguments);
        return finalKey;
    }
}