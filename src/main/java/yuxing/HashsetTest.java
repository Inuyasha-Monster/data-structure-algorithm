package yuxing;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author djl
 * @create 2021/3/14 15:30
 */
public class HashsetTest {
    public static void main(String[] args) {

        // 存储的不同的人
        HashSet<Person> personHashSet = new HashSet<>();

        boolean ok = personHashSet.add(new Person(18, "张三"));
        System.out.println("是否添加成功 = " + ok);

        boolean ok1 = personHashSet.add(new Person(18, "张三"));
        System.out.println("是否添加成功 = " + ok1);

        boolean b1 = personHashSet.add(new Person(22, "张三"));
        System.out.println("b1 = " + b1);
        boolean b2 =personHashSet.add(new Person(4, "张三"));
        System.out.println("b2 = " + b2);

        Iterator<Person> iterator = personHashSet.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println("person = " + person);
        }

        // 为什么两个age和name都相同的张三可以放进去??? 是否跟Person类中没有重写equals方法和hashcode方法有关系??

        // 如果重写了对象的equals方法

        // 如果我们业务对象的

        HashSet<String> stringHashSet = new HashSet<>();



    }
}
