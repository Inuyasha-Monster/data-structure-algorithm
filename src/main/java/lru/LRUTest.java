package lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author djl
 * @create 2021/2/27 9:01
 */
public class LRUTest {
    public static void main(String[] args) {

        // 测试原有的linkedhashmap的插入有序和访问有序
//        LinkedHashMap<String, String> simpleLRU = new LinkedHashMap<String, String>(5, 0.75f, true);
//
//        for (int i = 0; i < 5; i++) {
//            simpleLRU.put("key" + i, "value" + i);
//        }
//
//        System.out.println("simpleLRU = " + simpleLRU.size());
//
//        Set<Map.Entry<String,String>> entrySet = simpleLRU.entrySet();
//        for(Map.Entry<String,String> entry : entrySet){
//            System.out.println("key:"+entry.getKey()+";  Value: "+entry.getValue());
//        }
//
//        System.out.println("测试手动访问 key3 , 检测是否会移动到链表头部成为最近最新的访问元素");
//
//        simpleLRU.get("key3");
//        simpleLRU.get("key2");
//
//        Set<Map.Entry<String,String>> entrySet2 = simpleLRU.entrySet();
//        for(Map.Entry<String,String> entry : entrySet2){
//            System.out.println("key:"+entry.getKey()+";  Value: "+entry.getValue());
//        }

        SimpleLRU<String, String> simpleLRU = new SimpleLRU<>(5);

        for (int i = 0; i < 5; i++) {
            simpleLRU.put("key" + i, "value" + i);
        }
        System.out.println("simpleLRU size = " + simpleLRU.size());

        Set<Map.Entry<String, String>> entrySet = simpleLRU.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("key:" + entry.getKey() + ";  Value: " + entry.getValue());
        }

        simpleLRU.get("key2");

        System.out.println("after get key2:");

        Set<Map.Entry<String, String>> entrySet2 = simpleLRU.entrySet();
        for (Map.Entry<String, String> entry : entrySet2) {
            System.out.println("key:" + entry.getKey() + ";  Value: " + entry.getValue());
        }

        System.out.println("after add new entry");

        simpleLRU.put("key5", "value5");

        Set<Map.Entry<String, String>> entrySet3 = simpleLRU.entrySet();
        for (Map.Entry<String, String> entry : entrySet3) {
            System.out.println("key:" + entry.getKey() + ";  Value: " + entry.getValue());
        }
    }
}
