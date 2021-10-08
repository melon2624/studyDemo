package com.zx.leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 *
 * @author zhangxin
 * @date 2021/9/4 14:46
 */
public class FlattenBinaryTreeToLinkedList {

    public static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    //先序遍历递归
    public  static  Node flattern1(Node head){
        Queue<Node> queue=new LinkedList<>();

            pre(head,queue);
            Node temp=head;
            queue.poll();
            while (!queue.isEmpty()){
                temp.right=queue.poll();
                temp.left=null;
                temp=temp.right;
            }
            return head;
    }
    

    public  static  void pre(Node head, Queue<Node> queue){
            if ( head==null){
                return;
            }
            else {
                queue.add(head);
                pre(head.left,queue);
                pre(head.right,queue);
            }
    }
    
    //迭代
    public  static  Node  flattern2(Node head){
            Node newHead =head;
            while (newHead!=null){
                if (newHead.left!=null){
                    Node preLeft=newHead.left;
                    while (preLeft.right!=null){
                        preLeft=preLeft.right;
                    }
                    preLeft.right=newHead.right;
                    newHead.right=newHead.left;
                    newHead.left=null;
                    newHead=newHead.right;
                }else {
                    newHead=newHead.right;
                }
            }
            return head;
    }


    //分治思想
    public static Node flattern3(Node head) {

        if (head == null) {
            return null;
        }
        Node left = flattern3(head.left);
        Node right = flattern3(head.right);

        if (left != null) {
            Node preLeft = left;
            while (preLeft.right != null) {
                preLeft = preLeft.right;
            }
            preLeft.right = right;
            head.left=null;
            head.right=left;
        }else {
            head.left=null;
            head.right = right;

        }
        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        flattern2(head);

        while (head!=null){
            System.out.println(head.value);
            head=head.right;
        }

    }


}
