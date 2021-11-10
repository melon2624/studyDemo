package com.zx.leetcode.LinkedList;

/**
 * 21. 合并两个有序链表
 *
 * @author : zhangxin
 * @date : 2021-11-10 16:18
 **/
public class MergeTwoLists合并两个有序链表21 {

    //第二遍
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode cur = new ListNode(-1);
        ListNode head = null;
        head = cur;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if (l1!=null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        if (l2!=null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
      //  ListNode listNode7 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next =null;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next=null;
       // listNode6.next = listNode7;
        mergeTwoLists(listNode1,listNode4);
    }

}
