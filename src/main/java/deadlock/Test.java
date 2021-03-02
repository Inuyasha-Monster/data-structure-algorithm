package deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author djl
 * @create 2021/3/2 11:10
 */
public class Test {
    public static void main(String[] args) {
        ReentrantLock a = new ReentrantLock();
        ReentrantLock b = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            a.lock();
            try {
                try {
                    // 保证thread2启动先获取b锁
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b.lock();
                try {
                    System.out.println("-----thread1 执行-----");
                } finally {
                    b.unlock();
                }
            } finally {
                a.unlock();
            }
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            b.lock();
            try {
                a.lock();
                try {
                    System.out.println("-----thread2 执行-----");
                } finally {
                    a.unlock();
                }
            } finally {
                b.unlock();
            }
        });

        thread2.start();
    }
}
