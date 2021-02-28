package window;

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
        int[] arr = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
        int[] result = leetCode239.maxSlidingWindow(arr, 5);
        for (int i : result) {
            System.out.print(i + " ");
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
//    public int[] maxSlidingWindow2(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//
//        PriorityQueue
//
//        for (int i = 0; i < nums.length - k + 1; i++) {
//
//        }
//    }
}
