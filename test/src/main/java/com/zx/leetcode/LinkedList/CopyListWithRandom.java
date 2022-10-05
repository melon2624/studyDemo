package com.zx.leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 *
 * @author : zhangxin
 * @date : 2021-08-31 10:32
 **/
public class CopyListWithRandom {

    public static class Node {
        int value;
        Node next;
        Node random;

        public Node(int data) {
            this.value = data;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList1(Node head) {
       /* Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.value);
            newNode.next = cur.next;
            map.put(cur, newNode);
            cur = cur.next;
        }
        Node newcur = head;
        while (newcur != null) {
            map.get(newcur).random =newcur.random;
            newcur=newcur.next;
        }
        return map.get(head);*/

        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        Node newCur = head;
        while (newCur != null) {
            map.get(newCur).next = map.get(newCur.next);
            map.get(newCur).random = map.get(newCur.random);
            newCur = newCur.next;
        }
        return map.get(head);
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node1.random = node1;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.next = node5;
        node4.random = node1;

        node5.next = node6;
        node5.random = node3;

        Node newNode = copyRandomList1(node1);

    }

}
