package com.xfeng.example.test.tree;

import com.xfeng.example.tree.RBTree;

import java.util.List;

/**
 * @author xuefeng.wang
 * @date 2020-08-07
 */
public class RBTreeTest {
    public static void main(String[] args) {
        RBTree<Integer> rbTree = new RBTree<>();
        rbTree.insert(1);
        rbTree.insert(2);
        rbTree.insert(3);
        rbTree.insert(4);
        List<Integer> result = rbTree.PreorderTraversal();

        System.out.println(result);
    }
}
