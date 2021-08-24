package com.zx.leetcode.链表;

/**
 * @author : zhangxin
 * @date : 2021-08-19 16:27
 **/
public class ReverseList {

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

        ListNode node = reverseList2(node1);
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

    //第二遍
    public static ListNode reverseList2(ListNode head) {

      return null;
    }


}
