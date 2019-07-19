package com.chl.gbo.cental.domain;

import java.util.HashMap;
import org.springframework.util.StringUtils;
import com.google.gson.Gson;

public class CommonResultVO extends HashMap<String, Object> {

    private static final long serialVersionUID = 595983338868825637L;

    private static final Gson gson = new Gson();

    public CommonResultVO(){
        setErrorCode(0);
        setMessage("success");
    }

    public void setErrorMessage(int errorCode, String message){
        setMessage(message);
        setErrorCode(errorCode);
    }

    public void setErrorCode(int errorCode){
        put("errorCode", errorCode);
    }

    public void setMessage(String message){
        put("message", message);
    }

    public String toGsonResultString(){
        return gson.toJson(this);
    }

    public String toGsonResultString(String cb){
        if (StringUtils.isEmpty(cb)) {
            return gson.toJson(this);
        }
        return cb + "(" + gson.toJson(this) + ")";
    }
}
