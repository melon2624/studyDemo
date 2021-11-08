package com.zx.leetcode.LinkedList;


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
        public static Node deleteGivenValue2(int data, Node head) {

            if (head == null) {
                return null;
            }

            head.next = deleteGivenValue2(data, head.next);
            if (head.value == data) {
                return head.next;
            }
            return head;
        }
    }

    //第二次或者第三次做，增加一个虚拟头节点
    public static ListNode removeElements1(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);

        ListNode pre = dummy;

        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //第二次或者第三次做，不增加一个虚拟头节点
    public static ListNode removeElements2(ListNode head, int val) {


        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode pre = head;

        ListNode cur = head.next;

        while (cur != null) {

            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;

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


        ListNode listNode1 = new ListNode(8);
        ListNode listNode2 = new ListNode(8);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(8);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode listNode = removeElements1(listNode1, 3);


    }

}
