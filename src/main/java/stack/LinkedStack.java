package stack;

/**
 * @author djl
 * @create 2020/12/8 14:16
 */
public class LinkedStack {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack(5);
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        linkedStack.show();

        for (int i = 0; i < linkedStack.maxSize; i++) {
            final int pop = linkedStack.pop();
            System.out.println("pop = " + pop);
            linkedStack.show();
            System.out.println();
        }
    }

    private StackNode first = null; // 指向第一个节点
    private int maxSize;
    private StackNode top = null; // 指向最后一个节点

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    private boolean isEmpty() {
        return first == null;
    }

    // 如果链表的长度==maxSize表示满了
    private boolean isFull() {
        if (first == null) {
            return false;
        }
        int counter = 0;
        StackNode current = first;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter >= maxSize;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("空了");
            return;
        }
        StackNode current = first;
        while (current != null) {
            System.out.println(current.id);
            current = current.next;
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("满了");
            return;
        }
        StackNode add = new StackNode();
        add.id = value;

        if (first == null) {
            first = add;
            top = add;
            return;
        }

        // 直接添加到尾部
        StackNode cur = first;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = add;
        top = add;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("空了");
            throw new IllegalArgumentException("空了");
        }
        return top.id;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("空了");
            throw new IllegalArgumentException("空了");
        }
        // 表示只有最后一个元素直接弹出
        if (first.next == null) {
            final int result = first.id;
            first = null;
            top = null;
            return result;
        }

        // 构建辅助指针:指向top的前一个节点
        StackNode temp = first;
        while (temp.next != null) {
            if (temp.next == top) {
                break;
            }
            temp = temp.next;
        }

        int result = -1;
        // 移除尾部元素
        StackNode cur = first;
        while (cur != null) {
            if (cur == top) {
                // 出战
                result = cur.id;
                temp.next = null;
                top = temp;
                break;
            }
            cur = cur.next;
        }

        return result;
    }
}
