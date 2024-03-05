package com.jiejieren.linked_list;

import com.jiejieren.util.linked_list.single.ListNode;

/**
 * 203. 移除链表元素
 * 简单
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class Algorithm203_remove_linked_list_element {
    public static ListNode removeElements(ListNode head, int val) {
        /*
            // 这样post会漏掉对head节点的处理
            ListNode pre = head;
            ListNode post = head != null ? head.next : null;

            // 处理头结点为val的情况
            while (head != null && head.val == val) {
                head = head.next;
            }
         */

        // 为链表添加一个虚拟的头结点，以保证对原链表所有元素操作的一致性
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode pre = preHead;
        ListNode post = pre.next;

        while (post != null) {
            if (post.val == val) {
                pre.next = post.next;
                post = post.next;
            } else {
                pre = post;
                post = post.next;
            }
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for (int i = 1; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        removeElements(head, val);

        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
