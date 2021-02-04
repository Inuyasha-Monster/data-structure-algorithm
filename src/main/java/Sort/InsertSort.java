package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author djl
 * @create 2021/2/4 10:25
 * 插入排序:
 * 插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的.
 * 思想:
 * 插入排序（Insertion Sorting）的基本思想是：把 把 n 个待排序的元素看成为一个有序表和一个无序表的组合，开始时 有
 * 序表中只包含一个元素，无序表中包含有 n-1 个元素，排序过程中每次从无序表中取出第一个元素，把它的排
 * 序码依次与有序表元素的排序码进行比较，将它[插入]到有序表中的适当位置，使之成为新的有序表。
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 89};

// 创建要给 80000 个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {

            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort(arr); //调用插入排序算法

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

//
//        排序前的时间是=2021-02-04 10:39:47
//        排序前的时间是=2021-02-04 10:39:48

    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用 for 循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
//定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即 arr[1]的前面这个数的下标
// 给 insertVal 找到插入的位置
// 说明
// 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
// 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
// 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
// 当退出 while 循环时，说明插入的位置找到, insertIndex + 1
// 举例：理解不了，我们一会 debug
//这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
//System.out.println("第"+i+"轮插入");
//System.out.println(Arrays.toString(arr));
        }
    }

    /*
//使用逐步推导的方式来讲解，便利理解
//第 1 轮 {101, 34, 119, 1}; => {34, 101, 119, 1}
//{101, 34, 119, 1}; => {101,101,119,1}
//定义待插入的数
int insertVal = arr[1];
int insertIndex = 1 - 1; //即 arr[1]的前面这个数的下标
//给 insertVal 找到插入的位置
//说明
//1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
//2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
//3. 就需要将 arr[insertIndex] 后移
while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
insertIndex--;
}
//当退出 while 循环时，说明插入的位置找到, insertIndex + 1
//举例：理解不了，我们一会 debug
arr[insertIndex + 1] = insertVal;
System.out.println("第 1 轮插入");
System.out.println(Arrays.toString(arr));
//第 2 轮
insertVal = arr[2];
insertIndex = 2 - 1;
while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
insertIndex--;
}
arr[insertIndex + 1] = insertVal;
System.out.println("第 2 轮插入");
System.out.println(Arrays.toString(arr));
//第 3 轮
insertVal = arr[3];
insertIndex = 3 - 1;
while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
insertIndex--;
}
   arr[insertIndex + 1] = insertVal;
System.out.println("第 3 轮插入");
System.out.println(Arrays.toString(arr)); */

}
