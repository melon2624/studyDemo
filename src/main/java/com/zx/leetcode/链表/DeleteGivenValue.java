package com.zx.leetcode.链表;

import com.zx.leetcode.链表.ReverseList;

/**
 * @author : zhangxin
 * @date : 2021-08-23 16:56
 **/
public class DeleteGivenValue {


    public static class Node {

        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        //非递归
        public static Node deleteGivenValue(int data, Node head) {
            //给定值恰好为头节点，一个if就行的事，为什么用while循环？
            //假设，前几个节点的数据域为val，或者整个链表节点的数据域为val时，这时就会用到while循环了
            while (head != null) {
                if (head.value != data) {
                    break;
                }
                head = head.next;
            }
               /*
             此时有两种情况
            	1：前几个节点的数据域为val，删除了指定节点后，留下了待删除节点均有前驱节点的链表
        		例如： 1->1->1->2->6->3->4->1->6, val = 1--->  2->6->3->4->1->6
        	    2：整个链表的数据域为val，被删除完毕
             */
            Node pre = head;
            while (pre.next != null) {
                if (pre.next.value == data) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }
            return head;
        }

        //递归
        public static Node deleteGivenValue2(int data, Node head){

            if (head==null){
                return null;
            }

            head.next=deleteGivenValue2(data,head.next);
            if (head.value==data){
                return head.next;
            }
            return head ;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(8);
        Node node2 = new Node(8);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(8);
        Node node6 = new Node(5);
        Node node7 = new Node(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

    }

}
