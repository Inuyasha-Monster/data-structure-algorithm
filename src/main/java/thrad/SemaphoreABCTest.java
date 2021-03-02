package thrad;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author djl
 * @create 2021/3/2 11:32
 * 题目:ABC三个线程交替打印ABCABC...
 * 答案:通过三个信号量来解决
 */
public class SemaphoreABCTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        Thread threadA = new Thread(() -> {
            while (true) {
                try {
                    semaphoreA.acquire();
                    System.out.print("A");
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                try {
                    semaphoreB.acquire();
                    System.out.print("B");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            while (true) {
                try {
                    semaphoreC.acquire();
                    System.out.print("C");
                    System.out.println();
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
