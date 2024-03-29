package com.jiejieren.linked_list;

import com.jiejieren.util.linked_list.single.ListNode;

/**
 * 206. 反转链表
 * 简单
 * 相关标签
 * 相关企业
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class Algorithm206_reverse_linked_list {
    public static ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode(-1, head);
        ListNode p = preHead.next;
        ListNode q = null;
        while (p != null) {
            q = preHead.next;
            preHead.next = p;
            ListNode r = p;
            p = p.next;
            r.next = null;
            if (r == q) continue;
            preHead.next.next = q;
        }
        return preHead.next;
    }

    public static ListNode reverseListByRecurrent(ListNode head) {
        ListNode pre = null;
        ListNode post = head;
        dfs(pre, post);
        return pre;
    }

    private static void dfs(ListNode pre, ListNode post) {
        if (post == null) return;
        ListNode temp = post.next;
        post.next = pre;
        pre = post;
        post = temp;
        dfs(pre, post);
    }

    public static void main(String[] args) {

    }
}
