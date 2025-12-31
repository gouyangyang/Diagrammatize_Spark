package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gouyy
 * @version 1.0
 * @date 2025/12/31 10:03
 */
/**
 * LeetCode 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 找出数组中和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *  https://leetcode.cn/problems/two-sum/description/
 */
public class TwoSum {

    /**
     * 使用哈希表解法（推荐）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 两个整数的下标数组
     */
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表，key为数组元素值，value为数组下标
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素需要配对的数字
            int complement = target - nums[i];

            // 如果哈希表中存在配对的数字，直接返回结果
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // 将当前元素放入哈希表
            map.put(nums[i], i);
        }

        // 题目保证有解，这里不会执行到
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 暴力解法（不推荐，仅供对比）
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 两个整数的下标数组
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // 示例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("示例 1: [" + result1[0] + ", " + result1[1] + "]");

        // 示例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("示例 2: [" + result2[0] + ", " + result2[1] + "]");

        // 示例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("示例 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}
