package com.hello.algorithm;

import java.util.*;

/**
 * 计算哈夫曼树带权路径长度
 */
public class HuffmanMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");

        String str = scanner.nextLine();
        String num = str.substring(2);
        int count = Integer.parseInt(str.substring(0, 1));
        HashMap<String, String> map = new HashMap<>();
        List<String> nums = Arrays.asList(num.split(" "));
        sort(nums);
        //转化为Integer类型数组
        List<Integer> intNums = new ArrayList<>();
        for (String aa : nums) {
            intNums.add(Integer.parseInt(aa));
        }
        System.out.println("nums===11=>" + nums);
    }

    private static void sort(List<String> nums) {
        //排序：冒泡排序
        for (int i = 0; i < nums.size(); i++) {
            int a = Integer.parseInt(nums.get(i));
            for (int j = i; j < nums.size(); j++) {
                int b = Integer.parseInt(nums.get(j));
                if (a > b) {
                    nums.set(i, String.valueOf(b));
                    nums.set(j, String.valueOf(a));
                }
            }
        }
        System.out.println("nums====>" + nums);
    }

    private static void huffmanTree(List<Integer> intNums) {
        int first = intNums.get(0);
        for (int i = 0; i < intNums.size(); i++) {
            int a = intNums.get(i);
            for (int j = i; j < intNums.size(); j++) {
            }
        }
    }
}
