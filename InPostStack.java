import java.util.Stack;

public class InPostStack {
    static int Checker(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
    static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty()
                        && Checker(c) <= Checker(stack.peek())) {

                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String exp = "a+b*c";
        System.out.println(infixToPostfix(exp));
    }
}