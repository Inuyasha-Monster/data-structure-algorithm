package hash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author djl
 * @create 2021/2/26 21:42
 * 一致性Hash算法实践
 */
public class ConsistentHash<T> {
    // Hash函数接口
    private final IHashService iHashService;

    // 每个机器节点关联的虚拟节点数量
    private final int numberOfReplicas;

    // 环形虚拟节点
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>();

    public ConsistentHash(IHashService iHashService, int numberOfReplicas, Collection<T> nodes) {
        this.iHashService = iHashService;
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {
            add(node);
        }
    }

    /**
     * 增加真实节点
     *
     * @param node
     */
    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(iHashService.hash(node.toString() + i), node); // 使用 ip+编号 作为hash运算参数
        }
    }

    /**
     * 移除真实节点
     *
     * @param node
     */
    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(iHashService.hash(node.toString() + i));
        }
    }

    public T get(String key) {
        if (circle.isEmpty()) {
            return null;
        }

        // 计算原始目标hash值,通过此值寻找对应的服务器节点返回
        Long hash = iHashService.hash(key);

        // 沿环的顺时针找到一个虚拟节点
        if (!circle.containsKey(hash)) {
            // 找到基于当前hash值的下一个节点作为当前key的管辖节点
            SortedMap<Long, T> tailMap = circle.tailMap(hash);
            // 如果没有更大的hash值节点,证明超过了环状的最大节点值直接返回首节点服务器hash值,否则返回下一个节点的hash
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }

        // 返回指定hash值对应的服务器节点
        return circle.get(hash);
    }
}
