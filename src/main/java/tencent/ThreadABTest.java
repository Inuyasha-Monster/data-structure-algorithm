package tencent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author djl
 * @create 2021/3/3 21:18
 */
public class ThreadABTest {
    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);

        Thread threadA = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    semaphoreA.acquire();
                    if (i % 2 == 1) {
                        System.out.println("A:" + i);
                    }
                    semaphoreB.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    semaphoreB.acquire();
                    if (i % 2 == 0) {
                        System.out.println("B:" + i);
                    }
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
