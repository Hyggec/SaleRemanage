package  com.example.system.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public static String okGetString(String message){
        Map<String,Object>map = new HashMap<>();
        map.put("code",200);
        map.put("message",message);
        String s = JSONObject.toJSONString(map);
        return s;
    }
    public static String okGetString2(String message,Object object){
        Map<String,Object>map = new HashMap<>();
        map.put("code",200);
        map.put("message",message);
        map.put("result",object);
        String s = JSONObject.toJSONString(map);
        return s;
    }
}
