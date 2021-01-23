package com.hello.algorithm.linknode;

import java.util.HashSet;
import java.util.Set;

public class FindRing {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == null || fast == null){
                return false;
            }
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 集合判断
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                //如果重复出现说明有环
                if (set.contains(head))
                    return true;
                //否则就把当前节点加入到集合中
                set.add(head);
                head = head.next;
            }
            return false;
        }
    }

    /**
     * 链表删除
     */
    public boolean deleteFindRing(ListNode head) {
        //如果head为空，或者他的next指向为空，直接返回false
        if (head == null || head.next == null)
            return false;
        //如果出现head.next = head表示有环
        if (head.next == head)
            return true;
        ListNode nextNode = head.next;
        //当前节点的next指向他自己，相当于把它删除了
        head.next = head;
        //然后递归，查看下一个节点
        return deleteFindRing(nextNode);
    }
}
