package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author djl
 * @create 2021/2/4 10:15
 * 选择排序:
 * 选择式排序也属于内部排序法，是从欲排序的数据中，按指定的规则选出某一元素，再依规定交换位置后达到
 * 排序的目的。
 * 具体:
 * 选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：第一次从 arr[0]~arr[n-1]中选取最小值，
 * 与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，与 arr[1]交换，第三次从 arr[2]~arr[n-1]中选取最小值，与 arr[2]
 * 交换，…，第 i 次从 arr[i-1]~arr[n-1]中选取最小值，与 arr[i-1]交换，…, 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值，
 * 与 arr[n-2]交换，总共通过 n-1 次，得到一个按排序码从小到大排列的有序序列。
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};

        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快.
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);

//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
//在推导的过程，我们发现了规律，因此，可以使用 for 来解决
        //选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置 min
                    minIndex = j; // 重置 minIndex
                }
            }
// 将最小值，放在 arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//System.out.println("第"+(i+1)+"轮后~~");
//System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
    }

    /*
//使用逐步推导的方式来，讲解选择排序
//第 1 轮
//原始的数组 ： 101, 34, 119, 1
//第一轮排序 : 1, 34, 119, 101
//算法 先简单--》 做复杂， 就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决
//第 1 轮
int minIndex = 0;
int min = arr[0];
for(int j = 0 + 1; j < arr.length; j++) {
if (min > arr[j]) { //说明假定的最小值，并不是最小
min = arr[j]; //重置 min
minIndex = j; //重置 minIndex
}
}
//将最小值，放在 arr[0], 即交换
if(minIndex != 0) {
arr[minIndex] = arr[0];
arr[0] = min;
}
System.out.println("第 1 轮后~~");
System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
//第 2 轮
     minIndex = 1;
min = arr[1];
for (int j = 1 + 1; j < arr.length; j++) {
if (min > arr[j]) { // 说明假定的最小值，并不是最小
min = arr[j]; // 重置 min
minIndex = j; // 重置 minIndex
}
}
// 将最小值，放在 arr[0], 即交换
if(minIndex != 1) {
arr[minIndex] = arr[1];
arr[1] = min;
}
System.out.println("第 2 轮后~~");
System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
//第 3 轮
minIndex = 2;
min = arr[2];
for (int j = 2 + 1; j < arr.length; j++) {
if (min > arr[j]) { // 说明假定的最小值，并不是最小
min = arr[j]; // 重置 min
minIndex = j; // 重置 minIndex
}
}
// 将最小值，放在 arr[0], 即交换
if (minIndex != 2) {
arr[minIndex] = arr[2];
arr[2] = min;
}
System.out.println("第 3 轮后~~");
System.out.println(Arrays.toString(arr));// 1, 34, 101, 119
     */
}
