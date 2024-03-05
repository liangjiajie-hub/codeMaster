package com.jiejieren.linked_list;

import com.jiejieren.util.linked_list.single.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class Algorithm24_swap_pairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode post = pre.next;
        head = post != null ? post : head;
        while (post != null) {
            ListNode temp = post.next;
            post.next = pre;
            if (temp == null) {
                pre.next = null;
                break;
            }
            pre.next = temp.next == null ? temp : temp.next;
            pre = temp;
            post = pre.next;
        }
        return head;
    }

    public static ListNode swapPairsByRecurrent(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairsByRecurrent(next.next);
        next.next = head;

        return next;
    }
    public static void main(String[] args) {

    }
}
