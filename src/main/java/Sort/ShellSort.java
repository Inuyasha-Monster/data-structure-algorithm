package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author djl
 * @create 2021/2/4 10:44
 * 希尔排序:
 * 尔排序也是一种 插入排序，它是简单插入排序经过改进之后的一个 更高效的版本，也称为 [缩小增量排序]。
 * 思想:
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含
 * 的关键词越来越多， 当增量减至 1 时，整个文件恰被分成一组，算法便终止
 * 举例:
 * 有一群小牛, 考试成绩分别是 {8,9,1,7,2,3,5,4,6,0} 请从小到大排序. 请分别使用
 * 1) 希尔排序时， 对有序序列在插入时采用 交换法, 并测试排序速度.
 * 2) 希尔排序时， 对有序序列在插入时采用 移动法, 并测试排序速度
 * 3) 代码实现
 */
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
// 创建要给 80000 个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
//        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
//        shellSort(arr); //交换式
        shellSort2(arr);//移位方式
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
//System.out.println(Arrays.toString(arr));

//
//        排序前的时间是=2021-02-04 10:52:39
//        排序前的时间是=2021-02-04 10:52:39

    }

    // 使用逐步推导的方式来编写希尔排序
// 希尔排序时， 对有序序列在插入时采用交换法,
// 思路(算法) ===> 代码
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
// 根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
// 遍历各组中所有的元素(共 gap 组，每组有个元素), 步长 gap
                for (int j = i - gap; j >= 0; j -= gap) {
// 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//System.out.println("希尔排序第" + (++count) + "轮 =" +Arrays.toString(arr));
        }
    }

    /*
// 希尔排序的第 1 轮排序
// 因为第 1 轮排序，是将 10 个数据分成了 5 组
for (int i = 5; i < arr.length; i++) {
// 遍历各组中所有的元素(共 5 组，每组有 2 个元素), 步长 5
for (int j = i - 5; j >= 0; j -= 5) {
// 如果当前元素大于加上步长后的那个元素，说明交换
if (arr[j] > arr[j + 5]) {
temp = arr[j];

arr[j] = arr[j + 5];
arr[j + 5] = temp;
}
}
}
System.out.println("希尔排序 1 轮后=" +Arrays.toString(arr));//
// 希尔排序的第 2 轮排序
// 因为第 2 轮排序，是将 10 个数据分成了 5/2 = 2 组
for (int i = 2; i < arr.length; i++) {
// 遍历各组中所有的元素(共 5 组，每组有 2 个元素), 步长 5
for (int j = i - 2; j >= 0; j -= 2) {
// 如果当前元素大于加上步长后的那个元素，说明交换
if (arr[j] > arr[j + 2]) {
temp = arr[j];
arr[j] = arr[j + 2];
arr[j + 2] = temp;
}
}
}
System.out.println("希尔排序 2 轮后=" +Arrays.toString(arr));//
// 希尔排序的第 3 轮排序
// 因为第 3 轮排序，是将 10 个数据分成了 2/2 = 1 组
for (int i = 1; i < arr.length; i++) {
// 遍历各组中所有的元素(共 5 组，每组有 2 个元素), 步长 5
for (int j = i - 1; j >= 0; j -= 1) {
// 如果当前元素大于加上步长后的那个元素，说明交换
if (arr[j] > arr[j + 1]) {
temp = arr[j];
arr[j] = arr[j + 1];
arr[j + 1] = temp;
}
}
}
System.out.println("希尔排序 3 轮后=" +Arrays.toString(arr));//
*/

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
// 增量 gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
// 从第 gap 个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
//移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
//当退出 while 后，就给 temp 找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
