package com.example.alex.mvplibrary.helper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Alex on 2016/11/30.
 * 用于获取传入泛型中的那个类的类型
 * Alex
 */

public class GenericHelper {

    public static <T> Class<T> GenericToClass(Class<?> klass){
        Type type = klass.getGenericSuperclass();
        if (type == null||!(type instanceof ParameterizedType)) return null;
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        if (types == null||types.length == 0) return null;
        return (Class<T>) types[0];
    }

}
