package queue;

import java.util.Scanner;

/**
 * @author djl
 * @create 2020/12/7 9:52
 * 利用标记位表示是否是满了还是空了的方式构建基于数组的环形队列
 * 其中 this.front==this.tail && flag == 0 的时候表示空了
 * 其中 this.tail == this.front && flag == 0 的时候表示满了
 */
public class FlagCircleArrayQueue {

    public static void main(String[] args) {
        FlagCircleArrayQueue circleArrayQueue = new FlagCircleArrayQueue(5);
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
    // 增加一个标记位辅助来表示满了还是空了 0->空 1->满
    private int flag; // 默认为0

    public FlagCircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return this.front == this.tail && flag == 0;
    }

    public boolean isFull() {
        return this.tail == this.front && flag == 1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("满了");
            return;
        }
        System.out.println("enqueue 之前 tail:" + tail + ",front:" + front + ",flag:" + flag);
        arr[this.tail] = value;
        this.tail = (this.tail + 1) % maxSize;
        if (this.tail == this.front) {
            flag = 1;
        }
        System.out.println("enqueue 之后 tail:" + tail + ",front:" + front + ",flag:" + flag);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("空了");
            throw new RuntimeException("空了");
        }
        System.out.println("dequeue 之前 tail:" + tail + ",front:" + front + ",flag:" + flag);
        final int value = arr[front];
        this.front = (this.front + 1) % maxSize;
        if (this.front == this.tail) {
            this.flag = 0;
        }
        System.out.println("dequeue 之后 tail:" + tail + ",front:" + front + ",flag:" + flag);
        return value;
    }

    public int getHead() {
        if (isEmpty()) {
            System.out.println("空了");
            throw new RuntimeException("空了");
        }
        final int value = arr[front];
        return value;
    }

    // 打印数组中有效的数据(还在队列当中的数据)
    public void show() {
        if (isEmpty()) {
            System.out.println("空了");
            return;
        }
        // maxSize=5 front=3 tail=1  (3,4,0,1) 3;3<7;3++
        // maxSize=5 front=1 tail=4  (1,2,3,4) 1;1<5;1++
        // maxSize=5 front=2 tail=4  (2,3,4) 2;2<5;2++

        if (isFull()) {
            for (int i = 0; i < maxSize; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
            System.out.println("tail:" + tail + ",front:" + front + ",flag:" + flag);
        } else {
            if (this.tail > this.front) {
                for (int i = front; i < tail; i++) {
                    System.out.printf("arr[%d]=%d\n", i, arr[i]);
                }
            } else if (this.tail < this.front) {
                for (int i = front; i < maxSize; i++) {
                    System.out.printf("arr[%d]=%d\n", i, arr[i]);
                }
                for (int i = 0; i < this.tail; i++) {
                    System.out.printf("arr[%d]=%d\n", i, arr[i]);
                }
            }
            System.out.println("tail:" + tail + ",front:" + front + ",flag:" + flag);
        }
    }
}
