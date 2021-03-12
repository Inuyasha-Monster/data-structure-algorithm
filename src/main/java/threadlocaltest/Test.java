package threadlocaltest;

/**
 * @author djl
 * @create 2021/3/12 13:42
 */
public class Test {

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(() -> {
                stringThreadLocal.set(String.valueOf(temp));



            }).start();
        }
    }
}
