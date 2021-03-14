package yuxing;

import java.util.Collections;
import java.util.Set;

/**
 * @author djl
 * @create 2021/3/14 17:15
 */
public class Test2 {
    public static void main(String[] args) {
        // 1.不可变(什么是不可变??为什么不可变??) 因为源代码里面直接写了不能改会抛出 UnsupportedOperationException 异常
        // 2.Only是什么意思?? 就是说当前集合只有一个元素所以也保证了集合不包含重复元素,因为它只有一个元素
        Set<String> singleton = Collections.singleton("a");
        System.out.println("singleton = " + singleton);

        for (String s : singleton) {
            System.out.println("s = " + s);
        }

        // add 不支持就是说白了:不能给你用这个方法
//        boolean e = singleton.add("e");
//        System.out.println("e = " + e);
    }
}
