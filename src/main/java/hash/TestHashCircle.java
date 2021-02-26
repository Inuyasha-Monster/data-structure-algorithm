package hash;

import java.util.*;

/**
 * @author djl
 * @create 2021/2/26 21:57
 * 测试基于一致性hash算法的+虚拟节点
 * 总结:
 * 由于固定服务器数量采用 数组+模运算 将无法避免服务器节点增加和减少带来的寻址路由算法的变更导致代码必须重新发布上线
 * 通过一致性hash算法构建一个有序环状数据集合,可以将数据影响的范围降低,例如:如果A服务器挂了,那么假设B服务器在A后面,也就意味着原先在A服务器的数据寻址会路由到B服务节点,但是其他服务节点的数据寻址不会发生变化
 * 优化:但是上述可能会发送热点数据都可以在一个节点上面寻址,因为本身节点可能在环状上面的位置不够均衡或者hash算法不够均衡,
 * 所以采用虚拟节点的方式,将每个服务器节点创建多个虚拟节点,将环状填充均匀,使得每个节点的数据尽量做到均衡
 */
public class TestHashCircle {

    /**
     * 机器节点的IP前缀
     */
    private static final String IP_PREFIX = "192.168.0.";

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        // 真实机器节点, 模拟10台
        List<Node<String>> nodes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            map.put(IP_PREFIX + i, 0);
            Node<String> node = new Node<>(IP_PREFIX + i, "node" + i);
            nodes.add(node);
        }

        IHashService iHashService = new HashService();
        ConsistentHash<Node<String>> consistentHash = new ConsistentHash<>(iHashService, 100, nodes);

        for (int i = 0; i < 50000; i++) {
            String data = UUID.randomUUID().toString() + i;
            Node<String> node = consistentHash.get(data);

            map.put(node.getIp(), map.get(node.getIp()) + 1);
        }

        // 打印每台真实机器节点保存的记录条数
        for (int i = 1; i <= 10; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get(IP_PREFIX + i));
        }
    }

}
