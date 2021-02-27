package heap;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author djl
 * @create 2021/2/27 17:44
 */
public class MyPriorityQueue<T extends Comparable> {

    private static final int DEFAULT_SIZE = 10;

    private T[] arr;

    private int count = 0;

    public MyPriorityQueue() {
        this.arr = (T[]) new Comparable[DEFAULT_SIZE];
    }

    // 执行操作操作
    public void insert(T entry) {
        if (count >= arr.length) {
            // 执行扩容
            this.arr = Arrays.copyOf(arr, arr.length * 2);
        }

        // 将新增元素放置末尾
        arr[count] = entry;

        // 判断是否执行上浮操作
        int upNum = count;
        while (upNum / 2 >= 0 && arr[upNum].compareTo(arr[upNum / 2]) < 0) {
            // 当前节点比父亲节点更小执行上浮
            T temp = arr[upNum];
            arr[upNum] = arr[upNum / 2];
            arr[upNum / 2] = temp;
            // 更新上浮位置
            upNum = upNum / 2;
        }

        // 增加有效数量
        count++;
    }

    public T deleteMin() {
        if (count < 0) {
            return null;
        }
        T result = arr[0];

        // 将末尾元素覆盖到arr[0]
        arr[0] = arr[count - 1];
        arr[count - 1] = null;

        // 判断执行下沉操作
        int downNum = 0;
        // 判断索引没有越界以及存在孩子节点且孩子节点比父亲节点更小的情况
        while (downNum * 2 + 1 <= count - 1 &&
                downNum * 2 + 2 <= count - 1 &&
                (arr[downNum * 2 + 1] != null && arr[downNum * 2 + 1].compareTo(arr[downNum]) < 0 ||
                        arr[downNum * 2 + 2] != null && arr[downNum * 2 + 2].compareTo(arr[downNum]) < 0)
        ) {
            // 选择更小的孩子节点作为来交换
            boolean left = true;
            if (arr[downNum * 2 + 1] != null && arr[downNum * 2 + 2] != null && arr[downNum * 2 + 1].compareTo(arr[downNum * 2 + 2]) > 0) {
                left = false;
            }
            // 执行交换
            T temp = arr[downNum];
            if (left) {
                arr[downNum] = arr[downNum * 2 + 1];
                arr[downNum * 2 + 1] = temp;
                downNum = downNum * 2 + 1;
            } else {
                arr[downNum] = arr[downNum * 2 + 2];
                arr[downNum * 2 + 2] = temp;
                downNum = downNum * 2 + 2;
            }
        }

        count--;
        return result;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i].toString() + " ");
        }
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();

        for (int i = 0; i < 100; i++) {
            myPriorityQueue.insert(Integer.valueOf(i));
        }

        myPriorityQueue.print();

        for (int i = 0; i < 100; i++) {
            Integer min = myPriorityQueue.deleteMin();
            System.out.println("min = " + min);
        }

        System.out.println();

        MyPriorityQueue<Node> nodeMyPriorityQueue = new MyPriorityQueue<>();

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int randNum = random.nextInt(1000);
            nodeMyPriorityQueue.insert(new Node(randNum));
        }

        nodeMyPriorityQueue.print();

        for (int i = 0; i < 10; i++) {
            Node deleteMin = nodeMyPriorityQueue.deleteMin();
            System.out.println("deleteMin = " + deleteMin);
        }
    }

    static class Node implements Comparable<Node> {

        private Integer timespan;

        public Node(Integer timespan) {
            this.timespan = timespan;
        }

        @Override
        public int compareTo(Node o) {
            return this.timespan.compareTo(o.timespan);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "timespan=" + timespan +
                    '}';
        }
    }
}
