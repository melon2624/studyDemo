package com.zx.leetcode.LinkedList;

/**
 * @author zhangxin
 * @date 2022-02-17 1:01
 */
public class addTwoNumbers两数相加2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode();
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            node.val = sum;
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode node = new ListNode();
            int sum = l1.val + 0 + carry;
            carry = sum / 10;
            sum = sum % 10;
            node.val = sum;
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }


        while (l2 != null) {
            ListNode node = new ListNode();
            int sum = l2.val + 0 + carry;
            carry = sum / 10;
            sum = sum % 10;
            node.val = sum;
            cur.next = node;
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return pre.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);

        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        ListNode node = addTwoNumbers(node1, node8);

    }


}
