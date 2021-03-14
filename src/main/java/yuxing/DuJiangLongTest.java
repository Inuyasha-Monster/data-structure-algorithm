package yuxing;

/**
 * @author djl
 * @create 2021/3/14 17:02
 */
public class DuJiangLongTest {
    public static void main(String[] args) {
        DuJiangLongArrayList<DuPerson> duJiangLongArrayList = new DuJiangLongArrayList<DuPerson>(2);
        duJiangLongArrayList.add(new DuPerson(18, "张三", "会java会c#"));
        duJiangLongArrayList.add(new DuPerson(19, "王五", "会java会c#"));
        duJiangLongArrayList.add(new DuPerson(20, "李四", "会java会c#"));


        duJiangLongArrayList.print();
    }
}
