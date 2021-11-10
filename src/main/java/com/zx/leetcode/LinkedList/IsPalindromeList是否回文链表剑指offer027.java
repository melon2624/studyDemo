package com.zx.leetcode.LinkedList;

import java.util.Stack;

/**
 *      判断链表是否回文链表
 *
 * @author : zhangxin
 * @date : 2021-08-30 13:36
 **/
public class IsPalindromeList是否回文链表剑指offer027 {


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }

    //需要额外空间
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            ListNode ListNode = stack.pop();
            if (ListNode.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //不使用空间，快慢指针，把后半段链表逆序
    public static boolean isPalindrome2(ListNode head){
            ListNode fast;
            ListNode slow;
            fast=head;
            slow=head;
            while (fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            if (fast!=null){//奇数个
                slow=slow.next;
            }

                ListNode pre =null;
                ListNode next=null;
                while (slow!=null){
                    next=slow.next;
                    slow.next=pre;
                    pre=slow;
                    slow=next;
                }
                ListNode cur=head;
                while (pre!=null){
                    if (pre.val==cur.val){
                        pre=pre.next;
                        cur=cur.next;
                    }else {
                        return false;
                    }
                }
                return true;
            }





    public static void main(String[] args) {

        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(3);
        ListNode ListNode5 = new ListNode(2);
        ListNode ListNode6 = new ListNode(4);
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        ListNode4.next = ListNode5;
        ListNode5.next = ListNode6;

       /* ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode5 = new ListNode(2);
        ListNode ListNode6 = new ListNode(1);
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode5;
        ListNode5.next = ListNode6;*/ //奇数个测试

        boolean is = isPalindrome2(ListNode1);

        System.out.println(is);
    }


}
