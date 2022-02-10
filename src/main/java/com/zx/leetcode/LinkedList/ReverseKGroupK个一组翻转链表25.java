package com.zx.leetcode.LinkedList;

import java.util.LinkedList;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * @author : zhangxin
 * @date : 2022-02-09 16:28
 **/
public class ReverseKGroupK个一组翻转链表25 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head;
        //1--2--3--4--5
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        /*int i = 0;
        while (i < k) {
            if (b==null){
                return head;
            }else {
                b=b.next;
                i++;
            }
        }*/
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public static ListNode reverse(ListNode a, ListNode b) {

        ListNode pre=null;
        ListNode cur=a;
        ListNode temp=null;

        while (cur!=b){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
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

        reverseKGroup(node1, 2);
    }

}
