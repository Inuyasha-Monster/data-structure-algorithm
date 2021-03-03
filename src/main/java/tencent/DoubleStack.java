package tencent;

import java.time.temporal.Temporal;
import java.util.Stack;

/**
 * @author djl
 * @create 2021/3/3 21:25
 * 判断符合的有效性
 */
public class DoubleStack {
    public static void main(String[] args) {
        boolean test = Test("({((()()){()})[][([])]}())");
        System.out.println("test = " + test);

        boolean isValid = isValid("({((()()){()})[][([])]}())");
        System.out.println("isValid = " + isValid);
    }

    public static boolean Test(String str) {
        // 通过两个栈的方式解决
        Stack<Character> source = new Stack<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            source.add(aChar);
        }
        // 构建一个辅助栈
        Stack<Character> temp = new Stack<>();

        while (source.isEmpty() == false) {
            // 判断source新的栈顶是否与temp栈顶匹配,匹配的话直接出站,不匹配继续压入temp栈
            if (!source.isEmpty() && !temp.isEmpty() && ((source.peek().equals('(') && temp.peek().equals(')')) ||
                    (source.peek().equals('[') && temp.peek().equals(']')) ||
                    (source.peek().equals('{') && temp.peek().equals('}')))) {
                source.pop();
                temp.pop();
                continue;
            }
            // 首先取出来栈顶元素加入temp栈
            Character top = source.pop();
            temp.add(top);
        }

        // 如果最后2个栈都空了的话则认为匹配完全成果否则就认为失败了
        return source.isEmpty() && temp.isEmpty();
    }


    // ({((()()){()})[][([])]}())
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

}
