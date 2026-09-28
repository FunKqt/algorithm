package scene;

import structure.Stack;

import java.nio.charset.StandardCharsets;

// Exercise 1.3.4 (page 161)
// Write a stack client Parentheses that reads in a text stream from standard input
// and uses a stack to determine whether its parentheses are properly balanced. For example,
// your program should print true for `[()]{}{[()()]()}` and false for `[(])`.
public class Parentheses {
    private Stack<Character> stack;

    public Parentheses() {
        stack = new Stack<>();
    }


    public boolean t(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            char a;
            switch (aByte) {
                case '[':
                case '{':
                case '(':
                    stack.push((char) aByte);
                    break;

                case ']':
                    a = stack.pop();
                    if (a != '[') return false;
                    break;
                case '}':
                    a = stack.pop();
                    if (a != '{') return false;
                    break;
                case ')':
                    a = stack.pop();
                    if (a != '(') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

}
