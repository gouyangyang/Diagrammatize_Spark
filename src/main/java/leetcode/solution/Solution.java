package leetcode.solution;

/**
 * @author gouyy
 * @version 1.0
 * @date 2026/1/12 0:03
 */
public class Solution {
    // 实现思路，交替从两个字符串中取字符，知道其中一个字符串用完，将剩余的字符串加到尾部。
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();

        // 交替添加字符
        while (i < len1 && j < len2) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        // 添加word1剩余的部分
        while (i < len1) {
            result.append(word1.charAt(i++));
        }

        // 添加word2剩余的部分
        while (j < len2) {
            result.append(word2.charAt(j++));
        }
        return result.toString();
    }
}