package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author djl
 * @create 2021/3/1 21:28
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Object, String> hashMap = new HashMap<Object, String>();
        hashMap.put("Aa", "Aa");
        hashMap.put("BB", "BB");
//        hashMap.put("AaAa", "AaAa");
//        hashMap.put("AaBB", "AaBB");
//        hashMap.put("BBAa", "BBAa");
//        hashMap.put("BBBB", "BBBB");
        hashMap.put("AaAaAa", "AaAaAa");
        hashMap.put("AaAaBB", "AaAaBB");
        hashMap.put("AaBBAa", "AaBBAa");
        hashMap.put("AaBBBB", "AaBBBB");
        hashMap.put("BBAaAa", "BBAaAa");
        hashMap.put("BBAaBB", "BBAaBB");
        hashMap.put("BBBBAa", "BBBBAa");
//        hashMap.put("BBBBBB", "BBBBBB");
//        hashMap.put(1952508096, "1952508096");
//        System.out.println("BBBBBB".hashCode());
    }
}
