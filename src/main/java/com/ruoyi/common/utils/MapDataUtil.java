package com.ruoyi.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.util.*;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;

/**
 * Map通用处理方法
 * 
 * @author ruoyi
 */
public class MapDataUtil {
    public static Map<String, Object> convertDataMap(HttpServletRequest request) {
        Map<String, String[]> properties = request.getParameterMap();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator<?> entries = properties.entrySet().iterator();
        Map.Entry<?, ?> entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Entry<?, ?>) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                value = "";
                for (int i = 0; i < values.length; i++) {
                    value += values[i] + ",";
                }
                if (value.length() > 0) {
                    value = value.substring(0, value.length() - 1);
                }
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    /**
     * 对象 转map
     *
     * @param args
     * @return
     */
    public static Map<String, Object> parseObj2Map(Object args) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(args.getClass()))
                .filter(pd -> !"class".equals(pd.getName()))
                .collect(HashMap::new,
                        (map, pd) -> map.put(pd.getName(), ReflectionUtils.invokeMethod(pd.getReadMethod(), args)),
                        HashMap::putAll);
    }

    /**
     * 合并多个map
     *
     * @return
     * @throws Exception
     * @param listsMap
     */
    public static Map<String, String> megerListMap(List<Map<String, Object>> listsMap) {
//        Class clazz = maps[0].getClass(); // 获取传入map的类型
//        Map<K, V> map = null;
//        try {
//            map = (Map) clazz.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i = 0, len = maps.length; i < len; i++) {
//            map.putAll(maps[i]);
//        }
//        return map;
//    }
        Map<String,String> map = new HashMap<>();
        listsMap.forEach(x->{
            x.forEach((y,z)->{
                map.put(y, (String) z);
            });
        });
        return map;
    }
}