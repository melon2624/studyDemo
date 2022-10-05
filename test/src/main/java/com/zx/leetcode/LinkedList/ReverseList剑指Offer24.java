package com.zx.leetcode.LinkedList;

/**
 * @author : zhangxin
 * @date : 2021-08-19 16:27
 **/
public class ReverseList剑指Offer24 {

    public static class ListNode {
        int code;
        ListNode next;

        ListNode() {
        }

        ListNode(int code) {
            this.code = code;
        }

        ListNode(int code, ListNode next) {
            this.code = code;
            this.next = next;
        }

    }

    //单链表反转
    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    //第二遍
    public static ListNode reverseList2(ListNode head) {

        ListNode pre = null;

        ListNode cur = head;

        ListNode temp = null;
        while (cur != null) {

            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    //第三遍
    public static ListNode reverseList3(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        ListNode temp = null;

        while (cur != null) {

            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

    //非递归操作第四遍
    public static ListNode reverseList44(ListNode head) {

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

    public static ListNode reverseList55(ListNode a, ListNode b) {

        ListNode pre=null;
        ListNode cur=a;
        ListNode temp=null;

        while (cur!=b){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        b.next=pre;
        return b;

    }


    //递归第一遍操作
    public static ListNode reverseList4(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //  给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
        ListNode newHead = reverseList4(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
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

      //  ListNode node = reverseList44(node1);

        ListNode node=reverseList55(node1,node4);
    }

    //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //输入：head = [1,2,3,4,5], left = 2, right = 4
    //输出：[1,4,3,2,5]
    public ListNode reverseBetween(ListNode head, int left, int right) {
     /*   ListNode
        for (int i=1;i<left;i++){
            superior=
        }*/
        return null;
    }


}
