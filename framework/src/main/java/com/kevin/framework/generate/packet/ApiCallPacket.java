// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from snotice.proto

package com.kevin.framework.generate.packet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

import com.dyuproject.protostuff.ByteString;
import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.UninitializedMessageException;

public final class ApiCallPacket implements Externalizable, Message<ApiCallPacket>, Schema<ApiCallPacket>
{

    public static Schema<ApiCallPacket> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static ApiCallPacket getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final ApiCallPacket DEFAULT_INSTANCE = new ApiCallPacket();

    
    private Integer requestNumber;
    private String apiName;
    private String methodName;
    private List<ByteString> parameter;

    public ApiCallPacket()
    {
        
    }

    public ApiCallPacket(
        Integer requestNumber,
        String apiName,
        String methodName
    )
    {
        this.requestNumber = requestNumber;
        this.apiName = apiName;
        this.methodName = methodName;
    }

    // getters and setters

    // requestNumber

    public Integer getRequestNumber()
    {
        return requestNumber;
    }

    public void setRequestNumber(Integer requestNumber)
    {
        this.requestNumber = requestNumber;
    }

    // apiName

    public String getApiName()
    {
        return apiName;
    }

    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }

    // methodName

    public String getMethodName()
    {
        return methodName;
    }

    public void setMethodName(String methodName)
    {
        this.methodName = methodName;
    }

    // parameter

    public List<ByteString> getParameterList()
    {
        return parameter;
    }

    public void setParameterList(List<ByteString> parameter)
    {
        this.parameter = parameter;
    }

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<ApiCallPacket> cachedSchema()
    {
        return this;
    }

    // schema methods

    public ApiCallPacket newMessage()
    {
        return new ApiCallPacket();
    }

    public Class<ApiCallPacket> typeClass()
    {
        return ApiCallPacket.class;
    }

    public String messageName()
    {
        return ApiCallPacket.class.getSimpleName();
    }

    public String messageFullName()
    {
        return ApiCallPacket.class.getName();
    }

    public boolean isInitialized(ApiCallPacket message)
    {
        return 
            message.requestNumber != null 
            && message.apiName != null 
            && message.methodName != null;
    }

    public void mergeFrom(Input input, ApiCallPacket message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    message.requestNumber = input.readInt32();
                    break;
                case 2:
                    message.apiName = input.readString();
                    break;
                case 3:
                    message.methodName = input.readString();
                    break;
                case 4:
                    if(message.parameter == null)
                        message.parameter = new ArrayList<ByteString>();
                    message.parameter.add(input.readBytes());
                    break;
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, ApiCallPacket message) throws IOException
    {
        if(message.requestNumber == null)
            throw new UninitializedMessageException(message);
        output.writeInt32(1, message.requestNumber, false);

        if(message.apiName == null)
            throw new UninitializedMessageException(message);
        output.writeString(2, message.apiName, false);

        if(message.methodName == null)
            throw new UninitializedMessageException(message);
        output.writeString(3, message.methodName, false);

        if(message.parameter != null)
        {
            for(ByteString parameter : message.parameter)
            {
                if(parameter != null)
                    output.writeBytes(4, parameter, true);
            }
        }
    }

    public String getFieldName(int number)
    {
        switch(number)
        {
            case 1: return "requestNumber";
            case 2: return "apiName";
            case 3: return "methodName";
            case 4: return "parameter";
            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
        __fieldMap.put("requestNumber", 1);
        __fieldMap.put("apiName", 2);
        __fieldMap.put("methodName", 3);
        __fieldMap.put("parameter", 4);
    }
    
}
