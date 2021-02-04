package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author djl
 * @create 2021/2/4 13:41
 * 基数排序(桶排序)介绍:
 * 1) 基数排序（radix sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或 bin sort，顾
 * 名思义，它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
 * 2) 基数排序法是属于稳定性的排序，基数排序法的是效率高的 稳定性排序法
 * 3) 基数排序(Radix Sort)是桶排序的扩展
 * 4) 基数排序是 1887 年赫尔曼·何乐礼发明的。它是这样实现的：将整数按位数切割成不同的数字，然后按每个
 * 位数分别比较。
 *
 * 基数排序的说明:
 * 1) 基数排序是对传统桶排序的扩展，速度很快.
 * 2) 基数排序是经典的空间换时间的方式，占用内存很大, 当对海量数据排序时，容易造成 OutOfMemoryError 。
 * 3) 基数排序时稳定的。[注:假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些
 * 记录的相对次序保持不变，即在原序列中，r[i]=r[j]，且 r[i]在 r[j]之前，而在排序后的序列中，r[i]仍在 r[j]之前，
 * 则称这种排序算法是稳定的；否则称为不稳定的]
 * 4) 有负数的数组，我们不用基数排序来进行排序, 如果要支持负数，参考: https://code.i-harness.com/zh-CN/q/e98fa9
 */
public class RadixSort {
    public static void main(String[] args) {
        //int arr[] = { 53, 3, 542, 748, 14, 214};
        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
//        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        radixSort(arr);
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
//System.out.println("基数排序后 " +Arrays.toString(arr));
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
//根据前面的推导过程，我们可以得到最终的基数排序代码
//1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
//得到最大数是几位数
        int maxLength = (max + "").length();
//定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
//说明
//1. 二维数组包含 10 个一维数组
//2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
//3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
//为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
//可以这里理解
//比如：bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];
//这里我们使用循环将代码处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
//(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
//取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
//放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
//按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
//遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
//如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
//循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
//取出元素放入到 arr
                        arr[index++] = bucket[k][l];
                    }
                }
//第 i+1 轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;
            }
//System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" +Arrays.toString(arr));
        }

        /*
//第 1 轮(针对每个元素的个位进行排序处理)
for(int j = 0; j < arr.length; j++) {
//取出每个元素的个位的值
int digitOfElement = arr[j] / 1 % 10;
//放入到对应的桶中
bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
bucketElementCounts[digitOfElement]++;
}
//按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
int index = 0;
//遍历每一桶，并将桶中是数据，放入到原数组
for(int k = 0; k < bucketElementCounts.length; k++) {
//如果桶中，有数据，我们才放入到原数组
if(bucketElementCounts[k] != 0) {
//循环该桶即第 k 个桶(即第 k 个一维数组), 放入
for(int l = 0; l < bucketElementCounts[k]; l++) {
//取出元素放入到 arr
arr[index++] = bucket[k][l];
}
}
//第 l 轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！

bucketElementCounts[k] = 0;
}
System.out.println("第 1 轮，对个位的排序处理 arr =" +Arrays.toString(arr));
//==========================================
//第 2 轮(针对每个元素的十位进行排序处理)
for (int j = 0; j < arr.length; j++) {
// 取出每个元素的十位的值
int digitOfElement = arr[j] / 10 % 10; //748 / 10 => 74 % 10 => 4
// 放入到对应的桶中
bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
bucketElementCounts[digitOfElement]++;
}
// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
index = 0;
// 遍历每一桶，并将桶中是数据，放入到原数组
for (int k = 0; k < bucketElementCounts.length; k++) {
// 如果桶中，有数据，我们才放入到原数组
if (bucketElementCounts[k] != 0) {
// 循环该桶即第 k 个桶(即第 k 个一维数组), 放入
for (int l = 0; l < bucketElementCounts[k]; l++) {
// 取出元素放入到 arr
arr[index++] = bucket[k][l];

}
}
//第 2 轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
bucketElementCounts[k] = 0;
}
System.out.println("第 2 轮，对个位的排序处理 arr =" +Arrays.toString(arr));
//第 3 轮(针对每个元素的百位进行排序处理)
for (int j = 0; j < arr.length; j++) {
// 取出每个元素的百位的值
int digitOfElement = arr[j] / 100 % 10; // 748 / 100 => 7 % 10 = 7
// 放入到对应的桶中
bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
bucketElementCounts[digitOfElement]++;
}
// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
index = 0;
// 遍历每一桶，并将桶中是数据，放入到原数组
for (int k = 0; k < bucketElementCounts.length; k++) {
// 如果桶中，有数据，我们才放入到原数组
if (bucketElementCounts[k] != 0) {
// 循环该桶即第 k 个桶(即第 k 个一维数组), 放入
for (int l = 0; l < bucketElementCounts[k]; l++) {
// 取出元素放入到 arr
arr[index++] = bucket[k][l];
}
}
//第 3 轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
bucketElementCounts[k] = 0;
}
System.out.println("第 3 轮，对个位的排序处理 arr =" +Arrays.toString(arr));

         */

    }
}
