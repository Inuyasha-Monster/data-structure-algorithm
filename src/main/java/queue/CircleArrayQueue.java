package queue;

import java.util.Scanner;

/**
 * @author djl
 * @create 2020/12/6 18:29
 * 通过数组模拟环形队列 采用 额外空出一个元素空间 标记是队列满了还是队列为空的区分
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    circleArrayQueue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleArrayQueue.enqueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = circleArrayQueue.dequeue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
// TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = circleArrayQueue.getHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
// TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

    private int maxSize;
    private int front;
    private int tail;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0; // 表示指向队列的第一个元素
        this.tail = 0; // 表示指向队列的最后一个元素
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        // 当front追上tail的时候表示队列为空了
        return front == tail;
    }

    public boolean isFull() {
        // 当tail追上front的时候表示队列满了
        return (tail + 1) % maxSize == front;
    }

    public void enqueue(int value) {
        // 判断是否队列已经满了
        if (isFull()) {
            System.out.println("队列满了...");
            return;
        }
        System.out.println("入列之前 tail:" + tail);
        // 将元素加入队列尾部
        arr[tail] = value;
        // 计算下一个元素存放位置
        this.tail = (tail + 1) % maxSize;
        System.out.println("入列之后 tail:" + tail);
    }

    public int dequeue() {
        // 判断是否还有元素出队
        if (isEmpty()) {
            System.out.println("队列空了...");
            throw new RuntimeException("队列空了");
        }
        System.out.println("出列之前 front:" + front);
        int value = arr[front];
        // 计算下一个出队元素的位置
        this.front = (this.front + 1) % maxSize;
        System.out.println("出列之前 front:" + front);
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列空了...");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\r\n", i % maxSize, arr[i % maxSize]);
        }
        System.out.println("当前tail:" + tail + ",front:" + front);
    }

    private int size() {
        return (tail + maxSize - front) % maxSize;
    }

    // 仅仅获取头部元素不移动头部指针
    public int getHead() {
        // 判断是否还有元素出队
        if (isEmpty()) {
            System.out.println("队列空了...");
            throw new RuntimeException("队列空了");
        }
        return arr[front];
    }
}
