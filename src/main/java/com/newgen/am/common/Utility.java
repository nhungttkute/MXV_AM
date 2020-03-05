/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newgen.am.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author nhungtt
 */
public class Utility {

    public static List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }

    public static String lpadWith0(long id) {
        return String.format("%010d", id);
    }
    
    public static boolean isNull(Object obj) {
        return obj == null || "".equals(obj);
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static String convertObjectToJson(Object obj) {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            json = mapper.writeValueAsString(obj);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    public static String[] extractKeys(String path) throws Exception {
        String leadingSlash = "/";
        if (!path.startsWith(leadingSlash)) {
            throw new Exception("Path must begin with a leading '/'");
        }

        return path.substring(1).split(leadingSlash);
    }

    public static String getValueFromJsonObjectGivenKeys(JSONObject jsonObject, String[] keys) throws Exception {
        String currentKey = keys[0];

        if (keys.length == 1 && jsonObject.has(currentKey)) {
            return jsonObject.getString(currentKey);
        } else if (!jsonObject.has(currentKey)) {
            throw new Exception(currentKey + " is not a valid key.");
        }

        JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
        int nextKeyIdx = 1;
        String[] remainingKeys = Arrays.copyOfRange(keys, nextKeyIdx, keys.length);
        return getValueFromJsonObjectGivenKeys(nestedJsonObjectVal, remainingKeys);
    }
    
    public static JSONObject getNestedObjFromJsonObjectGivenKeys(JSONObject jsonObject, String[] keys) throws Exception {
        String currentKey = keys[0];

        if (keys.length == 1 && jsonObject.has(currentKey)) {
            return jsonObject.getJSONObject(currentKey);
        } else if (!jsonObject.has(currentKey)) {
            throw new Exception(currentKey + " is not a valid key.");
        }

        JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
        int nextKeyIdx = 1;
        String[] remainingKeys = Arrays.copyOfRange(keys, nextKeyIdx, keys.length);
        return getNestedObjFromJsonObjectGivenKeys(nestedJsonObjectVal, remainingKeys);
    }
    
//    public static JSONObject getNestedObjByIdInArray(JSONObject jsonObject, String[] keys, Long id) throws Exception {
//        String currentKey = keys[0];
//
//        if (keys.length == 1 && jsonObject.has(currentKey)) {
//            JSONArray jsonArray = jsonObject.getJSONArray(currentKey);
//            jsonArray.get
//            return 
//        } else if (!jsonObject.has(currentKey)) {
//            throw new Exception(currentKey + " is not a valid key.");
//        }
//
//        JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
//        int nextKeyIdx = 1;
//        String[] remainingKeys = Arrays.copyOfRange(keys, nextKeyIdx, keys.length);
//        return getNestedObjFromJsonObjectGivenKeys(nestedJsonObjectVal, remainingKeys);
//    }

    public static JSONObject addValue(String value, JSONObject jsonObject, String[] keys) throws Exception {
        String currentKey = keys[0];

        if (keys.length == 1) {
            return jsonObject.put(currentKey, value);
        } else if (!jsonObject.has(currentKey)) {
            throw new Exception(currentKey + " is not a valid key.");
        }

        JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
        String[] remainingKeys = Arrays.copyOfRange(keys, 1, keys.length);
        JSONObject updatedNestedValue = addValue(value, nestedJsonObjectVal, remainingKeys);
        return jsonObject.put(currentKey, updatedNestedValue);
    }

    public static JSONObject removeValue(JSONObject jsonObject, String[] keys) throws Exception {
        String currentKey = keys[0];

        if (keys.length == 1 && jsonObject.has(currentKey)) {
            jsonObject.remove(currentKey);
            return jsonObject;
        } else if (!jsonObject.has(currentKey)) {
            throw new Exception(currentKey + " is not a valid key.");
        }

        JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
        int nextKeyIdx = 1;
        String[] remainingKeys = Arrays.copyOfRange(keys, nextKeyIdx, keys.length);
        JSONObject updatedNestedValue = removeValue(nestedJsonObjectVal, remainingKeys);
        return jsonObject.put(currentKey, updatedNestedValue);
    }
}
