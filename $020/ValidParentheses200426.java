package $020;

import java.util.Stack;

/**
 * @author: suxun
 * @date: 2020/4/26 11:19
 * @description: 20. 有效的括号
 * '('，')'，'{'，'}'，'['，']'
 */
class ValidParentheses200426 {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Byte> stack = new Stack<>();
        byte[] bytes = s.getBytes();
        for (byte aByte : bytes) {
            if (aByte == '(' || aByte == '{' || aByte == '[') {
                stack.push(aByte);
            }
            if (aByte == ')' || aByte == '}' || aByte == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Byte peek = stack.pop();
                if (aByte == ')' && peek != '(') {
                    return false;
                }
                if (aByte == '}' && peek != '{') {
                    return false;
                }
                if (aByte == ']' && peek != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses200426 validParentheses200426 = new ValidParentheses200426();
        boolean valid = validParentheses200426.isValid("(");
        System.out.println(valid);
    }
}