package com.zss.user.util;


import java.util.ArrayList;
import java.util.List;

public class BeanConvertUtils {

    /**
     * 传入clazz
     *
     * @param sourceList
     * @param clazz
     * @param <T>
     * @param <H>
     * @return
     */
    public static <T, H> List<T> convertList(List<H> sourceList, Class<T> clazz) {
        List<T> tList = new ArrayList<>();
        if (sourceList != null && !sourceList.isEmpty()) {
            for (H h : sourceList) {
                tList.add(convertBean(h, clazz));
            }
        }
        return tList;
    }

    public static <T, H> T convertBean(H source, Class<T> clazz) {
        T target = null;
        try {
            target = clazz.newInstance();
            if (source == null) return target;
            BeanUtils.copy(source, target);
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }
}
