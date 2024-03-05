package com.jiejieren.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Algorithm225_implement_stack_using_queue {



    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.remove());
            }
            return queue.remove();
        }

        public int top() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.remove());
            }
            int result = queue.peek();
            queue.add(queue.remove());
            return result;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
