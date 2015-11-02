package com.kevin.framework.Handler.engine;

import com.kevin.service.ApiService;
import com.kevin.service.impl.ApiServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by spirit on 2015/10/13.
 */
/**
 * @Author:spirit
 * serviceEngine是个单例，需要在构造函数中提前注册接口和实现类
 * */
public class ServiceEngine {
    private static Map<String,String> serviceMap;
    private static class ServiceEngineSingletonHolder{
        private static final ServiceEngine INSTANCE = new ServiceEngine();
    }
    private ServiceEngine(){
        serviceMap = new HashMap<String, String>();
        serviceMap.put(ApiService.class.getName(), ApiServiceImpl.class.getName());
    }
    public static final ServiceEngine getInstance(){
        return ServiceEngineSingletonHolder.INSTANCE;
    }
    public Object getService(String interfaceName){
        Object obj = null;
        String str = serviceMap.get(interfaceName);
        try {
            obj = Class.forName(str).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
