package com.zx.leetcode.LinkedList;

import java.util.List;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 * @author : zhangxin
 * @date : 2022-02-09 13:42
 **/
public class ReverseBetween反转链表92II {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head.next == null || head == null) {
            return head;
        }
        //-1---1---2---3---4---5
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;

        ListNode temp = dumpHead;

        for (int i = 0; i < left - 1; i++) {
            temp = temp.next;
        }
        ListNode newPre = temp;//要反转的链表的第一个节点的前一个节点

        for (int i = 0; i < right - left + 1; i++) {
            temp = temp.next;
        }
        ListNode succ = temp.next;//要反转的链表的最后一个节点的后面第一个节点
        ListNode leftNode = newPre.next;
        temp.next = null;

        ListNode node = reverseList(newPre.next);
        newPre.next = node;
        leftNode.next = succ;

        return dumpHead.next;
    }


    //非递归操作第四遍
    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

       /* ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node1.next = node2;*/


        ListNode newHead = reverseBetween(node1, 2, 4);
        //ListNode newHead = reverseBetween(node1, 1, 1);
    }


}
