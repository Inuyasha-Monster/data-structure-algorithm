package yuxing;

/**
 * @author djl
 * @create 2021/3/14 16:51
 * 自定义一个泛型集合
 */
public class YuXingArrayList<T> {

    /**
     * @param size 俞星集合能够存放最大数量的值
     */
    public YuXingArrayList(int size) {
        // 初始化数组以及设置最大长度
        this.values = new Object[size];
    }

    // 因为protected的保护等级是允许子类的访问
    protected Object[] values; // 构建一个数组的时候,它长度是确定的值这个是代码的规则规范

    private int index = 0;

    public void add(T person) {
        // 是不是要判断一下数组满了啊
        if (index > values.length - 1) {
            System.out.println("满了兄弟");
            return;
        }
        values[index] = person;
        index++; // 0 1 2 3 4
    }
}
