package lru;

import com.sun.xml.internal.ws.api.message.Header;
import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * @author djl
 * @create 2021/2/27 9:24
 */
public class MyLRU<K, V> {

    private final int size;
    private final HashMap<K, V> hashMap;
    private final DoubleLinkList doubleLinkList;

    public MyLRU(int size) {
        this.size = size;
        this.hashMap = new HashMap<>((int) Math.ceil(size / 0.75) + 1, 0.75f);
        this.doubleLinkList = new DoubleLinkList();
    }

    public V put(K key, V value) {

        // 检查数量是否超过
        if (hashMap.size() >= size) {
            // 表示当前空间已经使用完毕需要通过LRU移除元素了
            K eldestKey = this.doubleLinkList.getEldestKeyAndRemoveIt();
            // 移除hashmap中的对应对象
            hashMap.remove(eldestKey);
        }

        // 加入hashmap
        hashMap.put(key, value);

        Node node = new Node();
        node.key = key;
        // 加入头节点下面
        doubleLinkList.add(node);

        return value;
    }

    public V get(K key) {
        // 提升对应的key的node到首部
        doubleLinkList.insertHeader(key);
        // 返回hashmap对应对象
        V v = this.hashMap.get(key);
        return v;
    }

    public void print() {
        this.doubleLinkList.print();
    }

    class DoubleLinkList {

        // 创建一个空头节点作为辅助节点
        private Node head = new Node();

        // 初始化尾指针指向头节点
        private Node tail = head;

        public void print() {
            Node cur = head.next;
            while (cur != null) {
                System.out.println(cur.key);
                cur = cur.next;
            }
        }

        public void add(Node node) {
            if (node == null) {
                throw new IllegalArgumentException("node empty");
            }
            // 添加元素到链表头部
            Node cur = head.next;
            if (cur == null) {
                head.next = node;
                this.tail = head.next;
                return;
            }

            // 斩断原始指针
            node.next = head.next;
            node.pre = head;
            head.next = node;
            cur.pre = node;
        }

        // 将key对应的node放置与头部节点的下一个节点,作为链表的第一个有效节点
        public void insertHeader(K key) {
            // 查找当前key对应的node
            Node cur = head.next;
            while (cur != null && !cur.key.equals(key)) {
                cur = cur.next;
            }
            // 检查是否找得到
            if (cur == null) {
                // 直接抛出异常
                throw new IllegalArgumentException("找不到key:" + key + "所对应的对象");
            }
            // 将该节点从链表取出来
            cur.pre.next = cur.next;
            // 需要判断是否本身就是尾部节点
            if (cur.next != null) {
                cur.next.pre = cur.pre;
            }

            // 将该节点插入到header头节点之后
            cur.next = head.next;
            head.next.pre = cur;
            cur.pre = head;
            head.next = cur;

            // 更新尾指针
            Node temp = head.next;
            while (temp.next != null) {
                temp = temp.next;
            }
            this.tail = temp;
        }

        public K getEldestKeyAndRemoveIt() {
            K key = this.tail.key;

            // 移除末尾节点
            Node newTail = this.tail.pre;
            newTail.next = null;
            this.tail.pre = null;
            // 更新链表为末尾节点
            this.tail = newTail;

            return key;
        }
    }

    // 链表节点
    class Node {
        private K key;
        private Node pre;
        private Node next;
    }
}
