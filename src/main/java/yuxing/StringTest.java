package yuxing;

/**
 * @author djl
 * @create 2021/3/14 16:31
 */
public class StringTest {

    public static void main(String[] args) {
        // 举例说明什么情况字符串的hashcode相同但是equals不同???
        String str1 = "Aa";

        System.out.println("str1 = " + str1.hashCode());

//        Character[] characters = new Character[]{'A', 'a'};

        String str2 = "BB";
        System.out.println("str2 = " + str2.hashCode());

        System.out.println(str1.equals(str2));

        // 特殊情况,因为一个再好哈希算法都会有冲突的,所以一个好的算法是为了尽可能避免冲突,而不是没有冲突

        String str11 = "AaBB";

        System.out.println("str11 = " + str11.hashCode());

        String str22 = "BBBB";

        System.out.println("str22 = " + str22.hashCode());

    }


}
