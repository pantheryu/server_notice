package com.kevin.framework.Handler;

import com.dyuproject.protostuff.ByteString;
import com.kevin.framework.Handler.engine.ServiceEngine;
import com.kevin.framework.builder.ApiResponseBuilder;
import com.kevin.framework.error.ApiErrorCodes;
import com.kevin.framework.error.ApiException;
import com.kevin.framework.generate.packet.ApiCallPacket;
import com.kevin.framework.generate.packet.ApiRequestPacket;
import com.kevin.framework.generate.packet.ApiResponsePacket;
import com.kevin.framework.generate.packet.ApiResultPacket;
import com.kevin.framework.serializer.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by spirit on 2015/10/10.
 */
public class ApiRequestHandler {
    private static final Logger log = LoggerFactory.getLogger(ApiRequestHandler.class);

    private Serializer serializer;
    private Object service;
    private ApiCallHandler handler;
    private Map<String, Method> registry;
    private ServiceEngine serviceEngine;

    public Serializer getSerializer() {
        return serializer;
    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    public void setService(Object service) {
        this.service = service;
    }

    /*
     *拆包运算，为每一个调用包设置返回信息
     * */
    public ApiResponsePacket execute(ApiRequestPacket request) {
        ApiResultPacket apiResultPacket = new ApiResultPacket();
        ApiResponseBuilder builder = new ApiResponseBuilder();
        serviceEngine = ServiceEngine.getInstance();
        builder.setSerializer(serializer);

        List<ApiCallPacket> apiCallPackets = request.getApiCallsList();
        List<ApiResultPacket> list = new ArrayList<ApiResultPacket>();
        for (ApiCallPacket apiCallPacket : apiCallPackets) {
            try {
                Object result = callApi(apiCallPacket);
                builder.addSuccessResult(apiCallPacket.getRequestNumber(), result);

            }catch(Exception e) {
                log.error("failed to call api:" + e.getMessage(), e);
                builder.addFailureResult(apiCallPacket.getRequestNumber(), e);
            }
        }
        //判断头部给出返回包的错误信息,暂时返回正确
        builder.setErrCode(0);
        builder.setErrMsg("success");
        return builder.toPacket(serializer);
    }

    /**
     * 执行具体的api调用，返回结果。主要是反序列化和将结果序列化
     * */
    public Object callApi(ApiCallPacket apiCallPacket) {

        String methodName = apiCallPacket.getMethodName();
        String apiName = apiCallPacket.getApiName();
        service = serviceEngine.getService(apiName);

        Method[] methods = service.getClass().getMethods();
        if(methods == null) {
            throw new ApiException(ApiErrorCodes.SYSTEM_ERROR.getValue(), "api not found:" + methodName);
        }
        Method method = null;
        for (Method m:methods){
            if (m.getName().equals(methodName)){
                method = m;
                break;
            }
        }
        Object object = null;
        List<ByteString> list = apiCallPacket.getParameterList();
        List<Object> objList = new ArrayList<Object>();
        Class[] parameterTypes = method.getParameterTypes();
        byte[] bytes = null;
        for (int i =0;i<list.size();i++){
            bytes = list.get(i).toByteArray();
            object = serializer.deserialize(parameterTypes[i],bytes);
            objList.add(object);
        }
        Object[] objects = objList.toArray();
        try {
            return method.invoke(service, objects);
        } catch (Exception e) {
            throw new ApiException(ApiErrorCodes.SYSTEM_ERROR.getValue(), "exception thrown when call api:" + methodName + "-" + e.getMessage(), e);
        }

    }




}
