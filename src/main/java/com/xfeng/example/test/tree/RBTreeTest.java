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
        rbTree.insert(5);
        System.out.println(rbTree.getmRoot().isColor());
        rbTree.insert(6);
        rbTree.insert(7);
        List<Integer> result = rbTree.PreorderTraversal();

        System.out.println(result);
    }
}
