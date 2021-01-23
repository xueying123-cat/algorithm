package com.hello.algorithm.treenode.model;

import lombok.Data;

@Data
public class TreeNode {
    private Integer val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer x) {
        this.val = x;
    }
}
