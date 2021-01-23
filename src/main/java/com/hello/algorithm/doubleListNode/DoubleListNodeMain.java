package com.hello.algorithm.doubleListNode;

import java.util.Scanner;

/**
 * @Description 双向链表排序
 * @Date 2020/12/28
 * @Author zxy
 */
public class DoubleListNodeMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String str = scanner.nextLine();
        String[] strs = str.split(" ");

        DoubleListNode first = new DoubleListNode(Integer.parseInt(strs[1]));
        int length = Integer.parseInt(strs[0]);
        circle(strs, 2, first, strs.length - 1);
        DoubleListNode newNode = sort(first);
        while (newNode != null) {
            System.out.print(newNode.getVal() + " ");
            newNode = newNode.next;
        }
    }

    private static void circle(String[] strs, int i, DoubleListNode n, int length) {
        if (i <= length) {
            DoubleListNode next = new DoubleListNode(Integer.parseInt(strs[i]));
            n.next = next;
            next.pre = n;
            n = n.next;
            circle(strs, ++i, n, length);
        }
    }

    private static DoubleListNode sort(DoubleListNode node) {
        DoubleListNode head = node;
        while (head != null) {
            DoubleListNode next = head.next;
            while (next != null) {
                DoubleListNode currentNode = next;
                if (head.getVal() > currentNode.getVal()) {
                    int max = head.getVal();
                    head.setVal(currentNode.getVal());
                    currentNode.setVal(max);
                }
                next = currentNode.next;
            }
            head = head.next;
        }
        return node;
    }
}
