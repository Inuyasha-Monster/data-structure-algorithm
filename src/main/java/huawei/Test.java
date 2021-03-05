package huawei;

import java.math.BigInteger;

/**
 * @author djl
 * @create 2021/3/5 21:06
 */
public class Test {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1 == o2); // false 比较引用

//        public boolean equals(Object obj) {
//            return (this == obj);
//        }
        System.out.println(o1.equals(o2)); // false 根据上述所示默认是比较引用

        float f1 = 0.1f;
        float f2 = 0.1f;

        System.out.println(f1 == f2); // true 如果是基础类型则操作符重载了的表示比较的值是否相等

        Float f11 = 0.1f;
        Float f22 = 0.1f;

        System.out.println(f11 == f22); // false 比较引用是否相等
        System.out.println(f11.equals(f22)); // true 比较值类型是否相等

        Float aFloat = Float.valueOf(0.1f);
        Float bFloat = Float.valueOf(0.1f);

        System.out.println(aFloat == bFloat); // false 比较引用是否相等
        System.out.println(aFloat.equals(bFloat)); // true 比较值类型是否相等

        int test = test();
        System.out.println("test = " + test);

        System.out.println();

        Integer integer1 = Integer.valueOf(127); //new Integer(1); //Integer.valueOf(-129);
        Integer integer2 = Integer.valueOf(127); ////new Integer(1); //Integer.valueOf(-129);
        System.out.println(integer1 == integer2);
        System.out.println(integer1.equals(integer2));

        System.out.println();

        BigInteger bigInteger1 = BigInteger.valueOf(16);
        BigInteger bigInteger2 = BigInteger.valueOf(16);
//        System.out.println(bigInteger1);
//        System.out.println(bigInteger2);
        System.out.println(bigInteger1 == bigInteger2);
        System.out.println(bigInteger1.equals(bigInteger2));

    }

    public static int test() {
        int a = 0;
        try {
            System.out.println("try");
            throw new IllegalArgumentException();
        } catch (Exception exception) {
            System.out.println("catch");
            return a;
        } finally {
            System.out.println("finally");
            a = a + 1;
            return a;
        }
    }
}
