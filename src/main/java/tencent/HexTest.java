package tencent;

/**
 * @author djl
 * @create 2021/3/3 22:14
 */
public class HexTest {
    public static void main(String[] args) {
        String hex = "abcfff";
        Integer x = Integer.parseInt(hex,16);
        System.out.println(x);

        int i = h2d(hex);
        System.out.println("i = " + i);
    }

    static int h2d(String s) {
        int i = 0, l = s.length(), n = 0;
        while (i < l) {
            int x = s.codePointAt(i);
            n = n << 4 | (x > '9' ? x - ('A' - 10) : x - '0');
            i += 1;
        }
        return n;
    }
}
