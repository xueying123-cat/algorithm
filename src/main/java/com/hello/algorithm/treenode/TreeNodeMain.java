package com.hello.algorithm.treenode;

import com.hello.algorithm.treenode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据数字组成二叉树
 */
public class TreeNodeMain {

    public static void main(String[] args) {
//        int[] a = {8, 6, 10, 5, 7, 9, 11};
        Integer[] a = {3, 9, 7, 20, 15, null, null};
        TreeNodeMain treeNodeMain = new TreeNodeMain();
        System.out.println("result===>" + treeNodeMain.initTreeNode(a));
    }

    private ArrayList<ArrayList<Integer>> initTreeNode(Integer[] a) {
        TreeNode first = new TreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            if(a[i] == null){
                continue;
            }
            TreeNode node = new TreeNode(a[i]);
            circle(node, first);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> firstNumbers = new ArrayList<>();
        firstNumbers.add(first.getVal());
        result.add(firstNumbers);

        List<TreeNode> newTreeNodes = new ArrayList<>();
        newTreeNodes.add(first);
        getNextValues(newTreeNodes, result);
        return result;
    }

    private void getNextValues(List<TreeNode> treeNodes, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<TreeNode> newTreeNodes = new ArrayList<>();
        for (TreeNode node : treeNodes) {
            if (node.getLeft() != null) {
                newTreeNodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                newTreeNodes.add(node.getRight());
            }
            values.addAll(getLeftAndRightValues(node));
        }
        if (!values.isEmpty()) {
            result.add(values);
        }
        if (!newTreeNodes.isEmpty()) {
            getNextValues(newTreeNodes, result);
        }
    }

    /**
     * 获取当前树节点下左子树以及右子树的值集合
     *
     * @param treeNode
     * @return
     */
    private List<Integer> getLeftAndRightValues(TreeNode treeNode) {
        List<Integer> values = new ArrayList<>();

        TreeNode left = treeNode.getLeft();
        TreeNode right = treeNode.getRight();
        if (treeNode.getLeft() != null) {
            values.add(left.getVal());
        }
        if (treeNode.getRight() != null) {
            values.add(right.getVal());
        }
        return values;
    }

    private void circle(TreeNode currentNode, TreeNode preNode) {
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
