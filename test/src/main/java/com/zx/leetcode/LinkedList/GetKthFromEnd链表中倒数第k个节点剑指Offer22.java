package com.zx.leetcode.LinkedList;

/**
 * @author : zhangxin
 * @date : 2021-11-10 15:51
 **/
public class GetKthFromEnd链表中倒数第k个节点剑指Offer22 {

    //pass
    public static ListNode getKthFromEnd(ListNode head, int k) {

        int i = 0;
        ListNode cur = head;
        while (i < k) {
            cur = cur.next;
            i++;
        }
        i = 0;
        while (cur != null) {

            cur = cur.next;
            head = head.next;
        }
        return head;
    }

}
