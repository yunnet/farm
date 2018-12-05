package com.farm.auth.server.runner;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import com.farm.auth.server.configuration.KeyConfiguration;
import com.farm.auth.common.jwt.RsaKeyHelper;

/**
 * 版权所有: 2018 ® kexin Company  <br />
 * 单元名称: AuthServerRunner.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 10:16:14 <br />
 * 最后修改: 2018-09-04 10:16:14 <br />
 * 修改历史: <br />
 */
@Configuration
public class AuthServerRunner implements CommandLineRunner {
	private final static Logger logger = LoggerFactory.getLogger(AuthServerRunner.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private KeyConfiguration keyConfiguration; 
	
	/**
	 * 用户的key
	 */
	private static final String REDIS_USER_PRI_KEY = "FM:AUTH:JWT:PRI";
    private static final String REDIS_USER_PUB_KEY = "FM:AUTH:JWT:PUB";
    
    /**
     * 客户端的key
     */
    private static final String REDIS_SERVICE_PRI_KEY = "FM:AUTH:CLIENT:PRI";
    private static final String REDIS_SERVICE_PUB_KEY = "FM:AUTH:CLIENT:PUB";
	

	@Override
	public void run(String... args) throws Exception {
		loadOrUpdateKey();
	}


	/**
	 * 加载用户和服务的私钥和公钥
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private void loadOrUpdateKey() throws IOException, NoSuchAlgorithmException {
		if (redisTemplate.hasKey(REDIS_USER_PRI_KEY) && redisTemplate.hasKey(REDIS_USER_PUB_KEY) && 
			redisTemplate.hasKey(REDIS_SERVICE_PRI_KEY) && redisTemplate.hasKey(REDIS_SERVICE_PUB_KEY)
			) {
            keyConfiguration.setUserPriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PRI_KEY)));
            keyConfiguration.setUserPubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY)));
            
            keyConfiguration.setServicePriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY)));
            keyConfiguration.setServicePubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY)));
        } else {
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));      
            
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));
            
            keyMap = RsaKeyHelper.generateKey(keyConfiguration.getServiceSecret());            
            keyConfiguration.setServicePriKey(keyMap.get("pri"));
            keyConfiguration.setServicePubKey(keyMap.get("pub"));  
            
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));
        }
	
		logger.info("pub_key and pri_key load finish.");
	}
}