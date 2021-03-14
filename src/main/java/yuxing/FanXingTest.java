package yuxing;

import java.util.ArrayList;

/**
 * @author djl
 * @create 2021/3/14 16:49
 */
public class FanXingTest {

    public static void main(String[] args) {
        // java 里面的泛型集合???
//        ArrayList<String> arrayList = new ArrayList<>();

        YuXingArrayList<String> yuXingArrayList = new YuXingArrayList<>(5);
        yuXingArrayList.add("a");
        yuXingArrayList.add("b");
        yuXingArrayList.add("b");
        yuXingArrayList.add("b");
        yuXingArrayList.add("b");

        yuXingArrayList.add("b");
        yuXingArrayList.add("b");
        yuXingArrayList.add("b");
        yuXingArrayList.add("b");

        System.out.println("------------");

        YuXingArrayList<Person> yuXingArrayList1=new YuXingArrayList<>(2);
        yuXingArrayList1.add(new Person(18, "张三"));
        yuXingArrayList1.add(new Person(18, "张三"));
        yuXingArrayList1.add(new Person(18, "张三"));
    }

}
