package com.seasonsfood.mall.util.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;


public class GsonUtils {

    public static Gson getGsonInstance() {
        return GsonSingle.gson;
    }

    private static class GsonSingle {
        public static Gson gson = new Gson();
    }

    public static JsonParser getJsonParserInstance() {
        return JsonParserSingle.jsonParser;
    }

    private static class JsonParserSingle {
        public static JsonParser jsonParser = new JsonParser();

    }

    public static GsonBuilder getGsonBuilderInstance() {
        return GsonBuilderSingle.gsonBuilder;
    }

    private static class GsonBuilderSingle {
        public static GsonBuilder gsonBuilder = new GsonBuilder();

    }

    /**
     * 将字段名不一致，属性一致的两个类进行转换
     *
     * @param cl
     *         转换的class
     * @param deserializer
     *         反序列化的类
     * @param obj
     *         要转换的JsonObject对象
     *
     * @return 转换后的Object对象
     */
    public static Object getConversion(Class<?> cl, Object deserializer, String obj) {

        return getGsonAndAdapter(cl, deserializer).fromJson(obj, cl);
    }


    public static Gson getGsonAndAdapter(Class<?> cl, Object deserializer) {

        return getGsonBuilderInstance().registerTypeAdapter(cl, deserializer).serializeNulls().create();

    }
}
