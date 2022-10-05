package com.zx.leetcode.LinkedList;

import java.util.Stack;

/**
 * @author : zhangxin
 * @date : 2021-11-10 16:45
 **/
public class FindFirstCommonNode两个链表的第一个公共结点160 {

    //方法一for循环遍历事件复杂度O(m*n)
    public static ListNode findFirstCommonNode1(ListNode headA, ListNode headB) {

        return null;

    }

    //方法二利用两个stack 下面代码有问题忽略
    public static ListNode findFirstCommonNode2(ListNode headA, ListNode headB) {

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            stack1.push(a);
            a = a.next;
        }
        while (b != null) {
            stack2.push(b);
            b = b.next;
        }
        ListNode pre1 = null;

        while (!stack1.empty() || !stack2.empty()) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            if (node1 != node2 && node1.next == node2.next) {
                return node1;
            }
        }
        return null;
    }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(0);
        ListNode listNode8 = new ListNode(1);

        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode3;

        findFirstCommonNode2(listNode1, listNode6);

    }


}
