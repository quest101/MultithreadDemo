package com.kang.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeHeight {

    /**
     * 通过递归的方式求出二叉树高度，这种方式很难想
     * @param node
     */
    public static int getHeightByRecursion(Node<Integer> node){
        if (node == null || node == null) return 0;
        int left = getHeightByRecursion(node.left);
        int right = getHeightByRecursion(node.right);
        if (left > right){
            return left + 1;
        }else {
            return right + 1;
        }
    }

    /**
     * 通过迭代求出二叉树的高度
     * @param node
     */
    public static void getHeightByIteration(Node<Integer> node){
        //这个就是慢迭代的下标
        int front = -1;
        //这个是记录每一层结尾处的下标
        int last = 0;
        //树的高度
        int height = 0;
        //这个是快迭代的下标
        int rear = -1;

        List<Node<Integer>> linkList = new ArrayList<>();
        linkList.add(++rear,node);
        Node<Integer> node1 = null;
        while(front < rear){
            node1 = linkList.get(++front);
            if (node1.left != null){
                linkList.add(++rear, node1.left);
            }
            if (node1.right != null){
                linkList.add(++rear, node1.right);
            }
            if (front == last){
                height++;
                last = rear;
            }

        }
        System.out.println(height);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree();
        binaryTree.add(7);
        binaryTree.add(4);
        binaryTree.add(10);
        binaryTree.add(9);
        binaryTree.add(11);
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(0);
        int height = getHeightByRecursion(binaryTree.root);
        System.out.println(height);
        getHeightByIteration(binaryTree.root);
    }
}
