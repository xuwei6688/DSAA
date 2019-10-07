package com.map;

import java.util.HashMap;

/**
 * @Author xuwei
 * @Date 2019-09-15
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new BSTMap<>();
        map.put("一", "1");
        map.put("二", "2");
        map.put("三", "3");

        System.out.println(map);
        System.out.println("contains 二: " + map.contains("二"));
        map.remove("二");
        System.out.println("contains 二: " + map.contains("二"));
        System.out.println("isEmpty: " + map.isEmpty());
        System.out.println("size: " + map.getSize());
        map.put("三", "三");
        System.out.println(map.get("三"));
    }
}
