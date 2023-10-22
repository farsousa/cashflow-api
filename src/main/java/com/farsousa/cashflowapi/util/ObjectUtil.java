package com.farsousa.cashflowapi.util;

import java.lang.reflect.Field;

public class ObjectUtil {
    public static <T> T mergeObjects(T target, T source) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object sourceValue = field.get(source);
                if (sourceValue != null) {
                    field.set(target, sourceValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return target;
    }
}