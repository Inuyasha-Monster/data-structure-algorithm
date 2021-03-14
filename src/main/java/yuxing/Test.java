package yuxing;

/**
 * @author djl
 * @create 2021/3/14 14:56
 * spring spring mvc springboot mybatics(数据库访问的一个ORM工具)
 * mysql redis(内存数据库) linux
 */
public class Test {
    public static void main(String[] args) {
        // 1. java中为什么要重写hashCode和equals?
        // object.equals() 原始object对象比较的是什么东西?

        Object obj1 = new Object(); // 直接object对象
        Object obj2 = new Object();
        System.out.println(obj1 == obj2); // true 还是 false  == 这个叫做符号重载 ;  == 在不同的对象当中表示的意思是不一样的 ; 结论 == 如果是作用于引用对象那么比较的是 内存地址(引用) , 如果作用的是基础类型的话比较的 数值
        System.out.println(obj1.equals(obj2));// true 还是 false

        int num1 = 1;
        int num2 = 1;
        System.out.println(num1 == num2);

        int num11 = new Integer("1"); // 包装对象拆箱
        int num12 = new Integer("1");
        System.out.println(num11 == num12);

        Integer num111 = new Integer(1);
        Integer num222 = new Integer(1);
        System.out.println(num111 == num222);
        System.out.println(num111.equals(num222));

        System.out.println("-------------------------");

        Integer num1111 = Integer.valueOf(1);
        Integer num2222 = Integer.valueOf(1);
        System.out.println(num1111 == num2222); // true 为什么呢??? 内存地址是不是一样的?是
        System.out.println(num1111.equals(num2222));

        // 探究一下为什么 num1111和num2222 内存地址一样 @530 地址是一样的


        Integer num11111 = Integer.valueOf(128);  // 127 128 129 188  分界线在哪里的? 那些数字的内存地址是一样 1 2 3 4 5 .... ? 到那个数字为止呢??
        Integer num22222 = Integer.valueOf(128);
        System.out.println(num11111 == num22222); // 这里的答案是什么??? 是不是还是比较的内存地址
        System.out.println(num11111.equals(num22222)); // 这里的答案是什么??? true 比较值

        Integer num111111 = Integer.valueOf(127);
        Integer num222222 = Integer.valueOf(127);
        System.out.println(num111111 == num222222); // true 127就是分界线 为什么呢?因为我看了源码里面就是127是分界线
        System.out.println(num111111.equals(num222222));

        // 总结一下 Integer.valueOf(?); 的范围是 [-128,127] 如果在此区间的话直接返回cache缓存对象

        System.out.println("----");

        float f1 = 0.1f;
        float f2 = 0.1f;
        System.out.println(f1 == f2);

        System.out.println("----");

        Float f11 = 0.1f; // Float大写的是什么=>对这个float基础类型的[包装类]
        Float f22 = 0.1f;
        System.out.println(f11 == f22); // 内存地址 @530
    }
}
