package com.jiejieren.memory_eviction;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 */
public class Algorithm146_LRU_cache {

    class LRUCache {

        private Node head = null;

        private Node tail = null;

        private int capacity;

        private Map<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node currentNode = map.get(key);
            if (currentNode == null) return -1;
            if (currentNode != head) {
                if (tail != currentNode) {
                    currentNode.pre.next = currentNode.next;
                    currentNode.next.pre = currentNode.pre;
                } else {
                    tail = tail.pre;
                    tail.next = null;
                }
                currentNode.next = head;
                head.pre = currentNode;
                currentNode.pre = null;
                head = currentNode;
            }
            return currentNode.value;
        }

        public void put(int key, int value) {
            Node currentNode = new Node(null, null, key, value);
            if (head == null) {
                head = currentNode;
                tail = head;
            } else {
                if (map.containsKey(key)) {
                    currentNode = map.get(key);
                    currentNode.value = value;
                    get(key);
                } else {
                    currentNode.next = head;
                    head.pre = currentNode;
                    head = currentNode;
                    if (map.size() == capacity) {
                        map.remove(tail.key);
                        tail = tail.pre;
                        if (tail != null) tail.next = null;
                    }
                }

            }
            map.put(key, currentNode);
        }
    }

    class Node {

        public Node next;

        public Node pre;

        public int key;

        public int value;

        public Node(Node next, Node pre, int key, int value) {
            this.next = next;
            this.pre = pre;
            this.key = key;
            this.value = value;
        }
    }

    // TODO 官方解法为链表设置了虚拟头节点和尾节点
    public static void main(String[] args) {

    }
}
