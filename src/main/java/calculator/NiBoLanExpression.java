package calculator;

import java.util.Stack;

/**
 * @author djl
 * @create 2020/12/9 9:44
 * 逆波兰表达式求值(也成为后缀表达式,是计算机在运算是实际的处理的表达式,好处就是后缀表达式符合是计算机的规则且消除了小括号的问题)
 * 思考分析:
 * 例如: (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - , 针对后缀表达式求值步骤如下:
 * 1．从左至右扫描，将 3 和 4 压入堆栈；
 * 2．遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
 * 3．将 5 入栈；
 * 4．接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
 * 5．将 6 入栈；
 * 6．最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
 */
public class NiBoLanExpression {
    public static void main(String[] args) {
        //4 5 * 8 - 60 + 8 2 / +
//        String expression = "3 4 + 5 * 6 -";
        String expression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        final String[] split = expression.split(" ");
        Stack<Integer> numStack = new Stack<>();
        for (String ch : split) {
            if (ch.equals("+") || ch.equals("*") || ch.equals("-") || ch.equals("/")) {
                final Integer num1 = numStack.pop();
                final Integer num2 = numStack.pop();
                // 判断具体运算符合(注意:这里是num2 ? num1 有先后顺序的)
                if (ch.equals("+")) {
                    numStack.push(num2 + num1);
                } else if (ch.equals("*")) {
                    numStack.push(num2 * num1);
                } else if (ch.equals("-")) {
                    numStack.push(num2 - num1);
                } else {
                    numStack.push(num2 / num1);
                }
            } else {
                // 表示数字直接入栈
                numStack.push(Integer.parseInt(ch));
            }
        }
        final Integer result = numStack.pop();
        System.out.println("result = " + result);
    }
}
