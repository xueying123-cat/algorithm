package com.hello.algorithm.treenode;

import com.hello.algorithm.treenode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 根据队列查找二叉树最小深度
 */
public class QueueDepthMain {

    public static void main(String[] args) {
        Integer[] a = {3, 1, 9, 7, 20, 15, null, null};
        TreeNode first = new TreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (null == a[i]) {
                continue;
            }
            TreeNode node = new TreeNode(a[i]);
            circle(node, first);
        }
        System.out.println("calculate====>" + calculateLevel(first));
    }

    /**
     * 计算最小深度
     *
     * @param first
     * @return
     */
    private static int calculateLevel(TreeNode first) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(first);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.getLeft() == null && treeNode.getRight() == null) {
                    return level;
                }
                if (treeNode.getLeft() != null) {
                    queue.offer(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    queue.offer(treeNode.getRight());
                }
            }
        }
        return level;
    }

    /**
     * 根据数字组成二叉树
     *
     * @param currentNode
     * @param preNode
     */
    private static void circle(TreeNode currentNode, TreeNode preNode) {
        if (currentNode.getVal() < preNode.getVal()) {
            //左子树
            if (preNode.getLeft() != null) {
                circle(currentNode, preNode.getLeft());
            } else {
                preNode.setLeft(currentNode);
            }
        } else {
            //右子树
            if (preNode.getRight() != null) {
                circle(currentNode, preNode.getRight());
            } else {
                preNode.setRight(currentNode);
            }
        }
    }
}
