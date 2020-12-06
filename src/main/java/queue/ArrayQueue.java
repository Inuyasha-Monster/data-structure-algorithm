package queue;

/**
 * @author djl
 * @create 2020/12/6 18:06
 */

/**
 * 一次性队列通过数组实现
 */
public class ArrayQueue {
    private int maxSize; // 队列的最大长度
    private int front; // 队列的头部
    private int tail; // 队列的尾部
    int[] arr; // 实际队列的数组元素

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.tail = -1;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return this.front == this.tail;
    }

    public boolean isFull() {
        return this.tail + 1 == maxSize;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("队列已经满了,不能添加数据");
            return;
        }
        this.tail++;
        arr[tail] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        this.front++;
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\r\n", i, arr[i]);
        }
    }

    // 注意这是peek的意思 front 指针没有移动
    public int getHead() {
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}

