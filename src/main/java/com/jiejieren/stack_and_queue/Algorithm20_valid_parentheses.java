package com.jiejieren.stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Algorithm20_valid_parentheses {

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' ||
                    s.charAt(i) == '{' ||
                    s.charAt(i) == '[') {
                stack.push(String.valueOf(current));
            } else {
                if (stack.size() > 0 && String.valueOf(current).equals(map.get(stack.peek()))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
