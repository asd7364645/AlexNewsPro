package com.example.alex.mvplibrary.helper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Alex on 2016/11/30.
 * 用于获取传入泛型中的那个类的类型
 * Alex
 */

public class GenericHelper {

    /**
     * 得到当前class的泛型的类
     * 例如   class MvpBaseAct<V extends MvpView,M extends MvpModelInterface>
     *      class BigImgAct extends MvpBaseAct<BigImgView,MvpModelInterface>
     *      GenericToClass 返回的就是BigImgView.class
     * @param klass
     * @param genericPosi   所需要知道当前类泛型的位置，第几个泛型，
     *                      比如
     *                      选择0，返回的就是BigImgView,选择1，返回的就是MvpModel
     * @param <T>
     * @return
     */
    public static <T> Class<T> GenericToClass(Class<?> klass,int genericPosi){
        Type type = klass.getGenericSuperclass();
        if (type == null||!(type instanceof ParameterizedType)) return null;
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        if (types == null||types.length == 0) return null;
        return (Class<T>) types[genericPosi];
    }

}
