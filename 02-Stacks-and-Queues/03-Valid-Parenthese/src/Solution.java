/**
 * Created by mxj on 2021/3/14 11:18 下午
 */
import java.util.Stack;

public class Solution {
//    public boolean isValid(String s) {
//        // s = '{[()]}'
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i ++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty())
//                    return false;
//
//                char topChar = stack.pop();
//                if (c == ')' && topChar != '(')
//                    return false;
//                if (c == ']' && topChar != '[')
//                    return false;
//                if (c == '}' && topChar != '{')
//                    return false;
//            }
//        }
//        return stack.isEmpty();
//    }

    // 使用自己实现的ArrayStack数据结构来解决括号匹配问题，替代 java.util.Stack
//    public boolean isValidByArrayStack(String s) {
//
//        ArrayStack<Character> stack = new ArrayStack<>();
//        for (int i = 0; i < s.length(); i ++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty())
//                    return false;
//
//                char topChar = stack.pop();
//                if (c == ')' && topChar != '(')
//                    return false;
//                if (c == ']' && topChar != '[')
//                    return false;
//                if (c == '}' && topChar != '{')
//                    return false;
//            }
//        }
//        return stack.isEmpty();
//    }

    public static void main(String[] args) {
//        System.out.println((new Solution()).isValid("()[]{}"));
//        System.out.println((new Solution()).isValid("()[{}"));

//        System.out.println((new Solution()).isValidByArrayStack("()[]{}"));
//        System.out.println((new Solution()).isValidByArrayStack("()[{}"));
    }
}
