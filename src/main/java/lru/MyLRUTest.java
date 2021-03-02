package lru;

/**
 * @author djl
 * @create 2021/2/27 10:17
 */
public class MyLRUTest {
    public static void main(String[] args) {
        MyLRU<String, String> myLRU = new MyLRU<>(5);

        System.out.println("lru size = " + 5);

        for (int i = 0; i < 5; i++) {
            myLRU.put("key" + i, "value" + i);
        }

        myLRU.print();


        myLRU.put("key5", "value5");

        System.out.println("after put key5");

        myLRU.print();

        System.out.println("after get key2");

        myLRU.get("key2");

        myLRU.print();


        myLRU.put("key6", "value6");

        System.out.println("after put key6");

        myLRU.print();

        System.out.println("after get key3");

        myLRU.get("key3");

        myLRU.print();

        myLRU.put("key7", "value7");

        System.out.println("after put key7");

        myLRU.print();

        System.out.println("get key4 after key4 被lru淘汰了");

        myLRU.get("key4");
    }
}
