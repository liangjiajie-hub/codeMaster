package com.jiejieren.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Algorithm232_implement_queue_using_stack {

    class MyQueue {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> bakStack = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            while (!stack.isEmpty()) {
                bakStack.push(stack.pop());
            }
            Integer result = bakStack.pop();
            while (!bakStack.isEmpty()) {
                stack.push(bakStack.pop());
            }
            return result;
        }

        public int peek() {
            while (!stack.isEmpty()) {
                bakStack.push(stack.pop());
            }
            Integer result = bakStack.peek();
            while (!bakStack.isEmpty()) {
                stack.push(bakStack.pop());
            }
            return result;
        }

        public boolean empty() {
            return stack.empty();
        }
    }

    class MyQueueByOn {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueueByOn() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            dumpStackIn();
            return stackOut.pop();
        }

        public int peek() {
            dumpStackIn();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.empty() && stackOut.empty();
        }

        private void dumpStackIn() {
            if (!stackOut.empty()) return;
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public static void main(String[] args) {

    }
}
