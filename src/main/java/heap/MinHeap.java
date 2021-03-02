package heap;

import com.sun.javafx.sg.prism.web.NGWebView;

import java.util.Arrays;

/**
 * @author djl
 * @create 2021/2/27 16:31
 * 实现最小堆:
 * 本质是使用数组来存取 且 arr[0] 存放的是最小元素
 * 插入的元素在arr[n]位置(n表示当前数组的后一个可用位置)通过filterUp(上浮)的方式找到对应位置,且最后操作完成依然保持堆有序
 * peek最小元素:arr[0]
 * 删除最小元素:将arr[0]取出后,将数组最后一个元素放置arr[0],通过与子节点比较,然后下沉元素到指定位置
 */
public class MinHeap {

    private final int size;

    private final int[] arr;

    private int count = 0;

    public MinHeap(int size) {
        this.size = size;
        this.arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 100;
        }
    }

    // 插入元素后维持二叉堆结构
    public void insert(int num) {
        if (count >= arr.length) {
            System.out.println("二叉堆满了...");
            return;
        }

        if (num < 0) {
            System.out.println("num<0错误...");
            return;
        }

        // 插入到数组的末尾位置
        arr[count] = num;

        // 判断且执行上浮操作
        int upNum = count;
        while (upNum / 2 >= 0 && arr[upNum / 2] > arr[upNum]) { // 如果父亲节点存在且它的值大于当前新增加节点的值则执行交换
            // 执行交换
            int temp = arr[upNum / 2];
            arr[upNum / 2] = arr[upNum];
            arr[upNum] = temp;
            // 更新up值
            upNum = upNum / 2;
        }

        // 有效数量计数+1
        count++;
    }

    public int getMin() {
        if (this.count <= 0) {
            throw new IllegalArgumentException("当前没有任何数据");
        }
        return arr[0];
    }

    public int deleteMin() {
        if (this.count <= 0) {
            throw new IllegalArgumentException("当前没有任何数据");
        }
        int result = arr[0];

        // 将数组最后一个元素覆盖到arr[0]
        arr[0] = arr[count - 1];
        arr[count - 1] = 100;

        // 执行下沉操作
        int downNum = 0;
        // 如果新arr[0]节点的孩子节点索引没有越界且它们的值小于arr[0]则执行交换
        while (downNum * 2 + 1 <= count - 1 && arr[downNum * 2 + 1] != 100 &&
                downNum * 2 + 2 <= count - 1 && arr[downNum * 2 + 2] != 100 &&
                (arr[downNum] > arr[downNum * 2 + 1] ||
                        arr[downNum] > arr[downNum * 2 + 1])) {
            // 找到孩子节点更小值与父节点交换
            boolean left = true;
            int minChild = arr[downNum * 2 + 1];
            if (minChild > arr[downNum * 2 + 2]) {
                minChild = arr[downNum * 2 + 2];
                left = false;
            }
            // 执行交换
            int temp = arr[downNum];
            arr[downNum] = minChild;

            // 更新孩子节点值以及更新下沉指标
            if (left) {
                arr[downNum * 2 + 1] = temp;
                downNum = downNum * 2 + 1;
            } else {
                arr[downNum * 2 + 2] = temp;
                downNum = downNum * 2 + 2;
            }
        }
        count--;
        return result;
    }

    public void print() {
        Arrays.stream(this.arr).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);

//        minHeap.insert(4);
//
//        minHeap.print();
//
//        minHeap.insert(3);
//
//        minHeap.print();
//
//        minHeap.insert(2);
//
//        minHeap.print();
//
//        minHeap.insert(0);
//
//        minHeap.print();
//
//        minHeap.insert(1);
//
//        minHeap.print();

//        minHeap.insert(-1);

//        0 1 2 3 4

        for (int i = 0; i < 10; i++) {
            minHeap.insert(i);
        }

        minHeap.print();

        // 测试deleteMin操作

        minHeap.deleteMin();
        minHeap.print();
    }
}
