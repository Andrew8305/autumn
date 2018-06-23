package com.cloud.common.context;

import com.cloud.common.constant.CommonConstants;
import com.cloud.common.util.StringHelper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;



/**
 * @author JiaShun
 * @date 2018/3/28 11:34
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key,Object value){
        Map<String,Object> map = threadLocal.get();
        if(map == null){
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key,value);
    }
    public static Object get(String key){
        Map<String,Object> map = threadLocal.get();
        if(map == null){
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
    public static void remove(){
        threadLocal.remove();
    }

    public static void setUserId(String userId){
        set(CommonConstants.JWT_KEY_USER_ID,userId);
    }
    public static void setUsername(String username){
        set(CommonConstants.JWT_KEY_USER_USERNAME,username);
    }
    public static void setName(String name){
        set(CommonConstants.JWT_KEY_USER_NAME,name);
    }
    public static void setToken(String token){
        set(CommonConstants.JWT_KEY_USER_TOKEN,token);
    }
    public static String getUserId(){
        Object value = get(CommonConstants.JWT_KEY_USER_ID);
        return StringHelper.getObjectValue(value);
    }
    public static String getUsername(){
        Object value = get(CommonConstants.JWT_KEY_USER_USERNAME);
        return StringHelper.getObjectValue(value);
    }
    public static String getName(){
        Object value = get(CommonConstants.JWT_KEY_USER_NAME);
        return StringHelper.getObjectValue(value);
    }
    public static String getToken(){
        Object value = get(CommonConstants.JWT_KEY_USER_TOKEN);
        return StringHelper.getObjectValue(value);
    }

//    @RunWith(MockitoJUnitRunner.class)
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
//            BaseContextHandler.setUserId("test");
//            assertEquals(BaseContextHandler.getUserId(), "test");
//            BaseContextHandler.setUsername("test2");
//            assertEquals(BaseContextHandler.getUsername(), "test2");
//        }
    //}
}
