package com.farm.common.context;

import java.util.HashMap;
import java.util.Map;

import com.farm.common.constant.CommonConstants;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: BaseContextHandler.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-03 14:48:00 <br />
 * 最后修改: 2018-09-03 14:48:00 <br />
 * 修改历史: <br />
 */
public class BaseContextHandler {
	public final static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();
	
	public static void set(String key, Object value) {
		Map<String, Object> map = threadLocal.get();
		if(null == map) {
			map = new HashMap<>();
			threadLocal.set(map);
		}
		map.put(key, value);
	}
	
	public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
	
	public static void remove() {
		threadLocal.remove();
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	private static String returnObjectValue(Object value) {
		return value == null ? null : value.toString();
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private static String getObjectValue(Object value) {
		return value == null ? "" : value.toString();
	}
	
	public static String getUserID() {
		Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
		return returnObjectValue(value);
	}
	
	public static void setUserID(String userID) {
		set(CommonConstants.CONTEXT_KEY_USER_ID, userID);
	}
	
	public static String getUsername() {
		Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
		return returnObjectValue(value);
	}
	
	public static void setUsername(String username) {
		set(CommonConstants.CONTEXT_KEY_USERNAME, username);
	}
	
	public static String getToken() {
		Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
		return getObjectValue(value);
	}
	
	public static void setToken(String token) {
		set(CommonConstants.CONTEXT_KEY_USER_TOKEN, token);
	}
	
	public static void setName(String name) {
		set(CommonConstants.CONTEXT_KEY_USER_NAME, name);
	}
	
	public static String getName() {
		Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return getObjectValue(value);
	}
	
//	@RunWith(MockitoJUnitRunner.class)
//    public static class UnitTest {
//        private Logger logger = LoggerFactory.getLogger(UnitTest.class);
//
//        @Test
//        public void testSetContextVariable() throws InterruptedException {
//            BaseContextHandler.set("test", "main");
//            new Thread(()->{
//                BaseContextHandler.set("test", "moo");
//
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                assertEquals(BaseContextHandler.get("test"), "moo");
//                logger.info("thread one done!");
//            }).start();
//            new Thread(()->{
//                BaseContextHandler.set("test", "moo2");
//                assertEquals(BaseContextHandler.get("test"), "moo2");
//                logger.info("thread two done!");
//            }).start();
//
//            Thread.sleep(5000);
//            assertEquals(BaseContextHandler.get("test"), "main");
//            logger.info("main one done!");
//        }
//
//        @Test
//        public void testSetUserInfo(){
//            BaseContextHandler.setUserID("test");
//            assertEquals(BaseContextHandler.getUserID(), "test");
//            BaseContextHandler.setUsername("test2");
//            assertEquals(BaseContextHandler.getUsername(), "test2");
//        }
//    }

}
