package com.hello.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 邻接矩阵画图（有向矩阵）
 */
public class AdjacencyMatrixMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");

        //总数量
        Integer num = Integer.parseInt(scanner.nextLine());

        //结束录入边界值
        int count = 0;
        List<String> strs = new ArrayList<>();
        while (count < num && scanner.hasNextLine()) {
            count++;
            strs.add(scanner.nextLine());
        }
        if (num != strs.size()) {
            throw new RuntimeException("输入数量与后续数量不一致，请重新输入");
        }

        //存储邻接矩阵图
        HashMap<String, JSONObject> map = new HashMap<>();
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            String first = str.split(":")[0];
            String content = str.substring(2);
            JSONObject jsonObject = JSONObject.parseObject(content);
            map.put(first, jsonObject);
        }

        //打印：
        Set<String> keys = map.keySet();
        for (String key : keys) {
            JSONObject jsonObject = map.get(key);
            for (String key1 : keys) {
                Object value = jsonObject.get(key1);
                System.out.print(null != value ? value.toString() : 0);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
