package com.zx.leetcode.链表;

import java.util.Stack;

/**
 * 判断链表是否回文链表
 *
 * @author : zhangxin
 * @date : 2021-08-30 13:36
 **/
public class IsPalindromeList {


    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //需要额外空间
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //不使用空间，快慢指针，把后半段链表逆序
    public static boolean isPalindrome2(Node head){
            Node fast;
            Node slow;
            fast=head;
            slow=head;
            while (fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            if (fast!=null){//奇数个
                slow=slow.next;
            }

                Node pre =null;
                Node next=null;
                while (slow!=null){
                    next=slow.next;
                    slow.next=pre;
                    pre=slow;
                    slow=next;
                }
                Node cur=head;
                while (pre!=null){
                    if (pre.value==cur.value){
                        pre=pre.next;
                        cur=cur.next;
                    }else {
                        return false;
                    }
                }
                return true;
            }





    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

       /* Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node5.next = node6;*/ //奇数个测试

        boolean is = isPalindrome2(node1);

        System.out.println(is);
    }


}
