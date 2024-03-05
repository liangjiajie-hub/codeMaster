package com.jiejieren.linked_list;

import com.jiejieren.util.linked_list.single.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Algorithm19_remove_nth_from_end {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode p = head;
        while (p != null) {
            total++;
            p = p.next;
        }
        p = new ListNode(-1, head);
        ListNode q = null;
        for (int i = 0; i < total - n + 1; i++) {
            q = p;
            p = p.next;
        }
        q.next = p.next;
        return head == p ? p.next : head;
    }

    // 快慢指针
    public ListNode removeNthFromEndByOneOfScan(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        return temp == head ? slow.next.next : head;
    }

    public static void main(String[] args) {

    }
}
