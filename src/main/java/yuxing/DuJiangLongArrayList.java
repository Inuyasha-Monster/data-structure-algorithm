package yuxing;

/**
 * @author djl
 * @create 2021/3/14 17:01
 */
public class DuJiangLongArrayList<T extends Person> extends YuXingArrayList<T> {
    /**
     * @param size 俞星集合能够存放最大数量的值
     */
    public DuJiangLongArrayList(int size) {
        super(size);
    }

    // 写其他的功能方法,做不到不影响 YuXingArrayList 的代码,是不是体现了一个扩展的思想,达到不干扰上层对象的情况下,扩展它的功能啊

    public void print() {
        for (Object value : super.values) {
            System.out.println((T) value);
        }
    }
}
