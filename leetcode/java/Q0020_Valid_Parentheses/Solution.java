package Q0020_Valid_Parentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeftParentheses(c)) {
                stack.add(c);
            } else if (isRightParentheses(c)) {
                if (stack.size() == 0) {
                    return false;
                } else {
                    if (!isPairParentheses(stack.pop(), c)) {
                        return false;
                    }
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLeftParentheses(char c) {
        return (c == '(') || (c == '{') || (c == '[');
    }

    private boolean isRightParentheses(char c) {
        return (c == ')') || (c == '}') || (c == ']');
    }

    private boolean isPairParentheses(char c1, char c2) {
        if (c1 == '(') {
            return c2 == ')';
        }
        if (c1 == '{') {
            return c2 == '}';
        }
        if (c1 == '[') {
            return c2 == ']';
        }
        return false;
    }
}