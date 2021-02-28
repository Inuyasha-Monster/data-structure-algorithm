package leetcode.window;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author djl
 * @create 2021/2/28 10:07
 * 滑动窗口的最大值:
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class LeetCode239 {

    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();

        int[] arr = new int[]{6, 3, -1, -3, 5, 3, 6, 7};
        int[] result = leetCode239.maxSlidingWindow(arr, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println("采用优先级队列解答:");
        int[] window2 = leetCode239.maxSlidingWindow2(arr, 3);
        for (int i : window2) {
            System.out.println(i + " ");
        }

        System.out.println("采用自用优先级队列");
        int[] result2 = leetCode239.maxSlidingWindow3(arr, 3);
        for (int i : result2) {
            System.out.println(i + " ");
        }
    }


    /**
     * 此方法的时间复杂度最坏的情况:数组单调递增每次的计算结果不能复用,导致时间复杂度O(n*k),不过可以CA通过
     *
     * @param nums
     * @param k
     * @return
     */
    @Deprecated
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 创建结果数组所需的空间
        int[] result = new int[nums.length - k + 1];
        // 标记暂存最大值是否有效
        boolean ok = false;
        // 假设最大值为-1通过判断上次计算结果是否可以复用
        int max = -1;
        // 最大值的索引
        int maxIndex = -1;
        // 循环推动窗口移动
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (ok) {
                // 直接使用前一次窗口暂存数据比较滑动的新1一个窗口的数值
                if (nums[i + k - 1] >= max) {
                    max = nums[i + k - 1];
                    maxIndex = i + k - 1;
                }
            } else {
                max = nums[i];
                maxIndex = i;
                // 寻找k窗口的最大值
                for (int j = 1; j < k; j++) {
                    if (nums[i + j] >= max) {
                        max = nums[i + j];
                        maxIndex = i + j;
                    }
                }
            }
            // 如果上次窗口结果最大值不是窗口第一个数字则后续的窗口可以复用于比较
            if (maxIndex != i) {
                ok = true;
            } else {
                ok = false;
            }
            result[i] = max;
        }
        return result;
    }

    /**
     * 使用优先级队列来维护k窗口的数据
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        // 定义优先级队列
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                // 比较每个元素的值,如果不相等直接比较值,如果值相等则比较索引位置
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        // 初始化k窗口的优先级队列
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        // 滑动窗口找到最大值
        int[] result = new int[nums.length - k + 1];
        // 赋值第一个窗口的最大值
        result[0] = pq.peek()[0];
        // 开始滑动
        for (int i = k; i < nums.length; ++i) {
            // 将新滑动的值以及索引加入优先级队列
            pq.offer(new int[]{nums[i], i});
            // 二叉堆的最大元素的索引小于等于当前索引则移除 ( 判断当前堆顶元素是否在当前的滑动窗口中 )
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }
}
