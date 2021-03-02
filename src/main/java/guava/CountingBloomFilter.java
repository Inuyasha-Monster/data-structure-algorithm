package guava;

import orestes.bloomfilter.FilterBuilder;

/**
 * @author djl
 * @create 2021/2/27 16:00
 */
public class CountingBloomFilter {
    public static void main(String[] args) {
        orestes.bloomfilter.CountingBloomFilter<String> cbf = new FilterBuilder(10000,
                0.01).countingBits(8).buildCountingBloomFilter();

        cbf.add("zhangsan");
        cbf.add("lisi");
        cbf.add("wangwu");
        System.out.println("是否存在王五：" + cbf.contains("wangwu")); //true
        cbf.remove("wangwu");
        System.out.println("是否存在王五：" + cbf.contains("wangwu")); //false
    }
}
