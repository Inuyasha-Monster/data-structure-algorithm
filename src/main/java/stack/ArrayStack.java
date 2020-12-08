package stack;

/**
 * @author djl
 * @create 2020/12/8 14:01
 * 使用数组模拟栈
 * 栈的特点:先进后出
 */
public class ArrayStack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.show();

        System.out.println();
        for (int i = 0; i < arrayStack.maxSize; i++) {
            final int pop = arrayStack.pop();
            System.out.println("pop = " + pop);
            arrayStack.show();
            System.out.println();
        }
    }

    private int maxSize;
    private int[] arr;
    private int top = -1; // 栈顶指针

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public void show() {
        if (top == -1) {
            System.out.println("栈空了");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public void push(int value) {
        if (this.top == maxSize - 1) {
            System.out.println("栈满了");
            return;
        }
        this.top++;
        arr[top] = value;
    }


    public int pop() {
        if (this.top == -1) {
            System.out.println("栈空了");
            throw new IllegalArgumentException("栈空了");
        }
        final int result = arr[top];
        this.top--;
        return result;
    }

    public int peek() {
        if (this.top == -1) {
            System.out.println("栈空了");
            throw new IllegalArgumentException("栈空了");
        }
        return arr[top];
    }
}
