package recursion;

/**
 * @author djl
 * @create 2020/12/9 10:27
 */
public class RecursionTest {

    public static void main(String[] args) {

//        递归用于解决什么样的问题
//        1) 各种数学问题如: 8 皇后问题 , 汉诺塔, 阶乘问题, 迷宫问题, 球和篮子的问题(google 编程大赛)
//        2) 各种算法中也会使用到递归，比如快排，归并排序，二分查找，分治算法等.
//        3) 将用栈解决的问题-->第归代码比较简洁

        //通过打印问题，回顾递归调用机制
        test(4);
        int res = factorial(3);
        System.out.println("res=" + res);
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } //else {
        System.out.println("n=" + n);
// }
    }

    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n; // 1 * 2 * 3
        }
    }
}
