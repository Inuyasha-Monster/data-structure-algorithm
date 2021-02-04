package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author djl
 * @create 2021/2/4 9:53
 * 冒泡排序:
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待排序序列从前向后（从下标较小的元素开始）, 依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
 * 优化：
 * 因为排序的过程中，各元素不断接近自己的位置， 如果一趟比较下来没有进行过交换 ， 就说明序列有序，因此要在
 * 排序过程中设置一个标志 flag 判断元素是否进行过交换。从而减少不必要的比较。(这里说的优化，可以在冒泡排
 * 序写好后，在进行)
 * 过程:
 * (1) 一共进行 数组的大小-1 次 大的循环
 * (2)每一趟排序的次数在逐渐的减少
 * (3) 如果我们发现在某趟排序中，没有发生一次交换， 可以提前结束冒泡排序。这个就是优化
 */
public class BubbleSort {
    public static void main(String[] args) {


//为了容量理解，我们把冒泡排序的演变过程，给大家展示
//测试一下冒泡排序的速度 O(n^2), 给 80000 个数据，测试
//创建要给 80000 个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        // 测试结果: 根据cpu运算能力而定
//        排序前的时间是=2021-02-04 10:10:43
//        排序后的时间是=2021-02-04 10:10:54

//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

/*
        int arr[] = {3, 9, -1, 10, 20};
        int temp;

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        // 第一趟排序，就是将第一大的数排在倒数第一位
        for (int j = 0; j < arr.length - 1; j++) {
// 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

// 第二趟排序，就是将第二大的数排在倒数第二位
        for (int j = 0; j < arr.length - 1 - 1; j++) {
// 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));
// 第三趟排序，就是将第三大的数排在倒数第三位
        for (int j = 0; j < arr.length - 1 - 2; j++) {
// 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));
// 第四趟排序，就是将第 4 大的数排在倒数第 4 位

        for (int j = 0; j < arr.length - 1 - 3; j++) {
// 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));
        */
    }

    // 将前面额冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
// 冒泡排序 的时间复杂度 O(n^2), 自己写出
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
// 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//System.out.println("第" + (i + 1) + "趟排序后的数组");
//System.out.println(Arrays.toString(arr));
            if (!flag) { // 在一趟排序中，一次交换都没有发生过,说明当前的数组元素已经是有序的了,就直接退出
                break;
            } else {
                flag = false; // 重置 flag!!!, 进行下次判断
            }
        }
    }
}
