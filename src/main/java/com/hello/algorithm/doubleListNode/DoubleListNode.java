package com.hello.algorithm.doubleListNode;

/**
 * @Description 双向链表
 * @Date 2020/12/16
 * @Author zxy
 */
public class DoubleListNode {
    int val;
    DoubleListNode pre;
    DoubleListNode next;

    DoubleListNode(int x) {
        this.val = x;
        next = null;
    }

    int getVal() {
        return this.val;
    }

    void setVal(int val) {
        this.val = val;
    }
}
