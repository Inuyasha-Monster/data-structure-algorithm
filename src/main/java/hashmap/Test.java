package hashmap;

/**
 * @author djl
 * @create 2021/3/1 21:23
 */
public class Test {
    public static void main(String[] args) {
        int aa = "Aa".hashCode();
        int bb = "BB".hashCode();
        System.out.println("Aa = " + aa);
        System.out.println("BB = " + bb);

        int ab = "Ab".hashCode();
        int bc = "BC".hashCode();
        System.out.println("Ab = " + ab);
        System.out.println("BC = " + bc);

        System.out.println("AaBB = " + "AaBB".hashCode());
        System.out.println("BBAa = " + "BBAa".hashCode());
    }
}
