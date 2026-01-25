package leetcode.solution;

/**
 * @author gouyy
 * @version 1.0
 * @date 2026/1/12 0:27
 */
public class SolutionTest {
    public static void main(String []args){
        Solution test = new Solution();
        // 示例1 输出: "apbqcr"
        System.out.println(test.mergeAlternately("abc","pqr"));
        // 示例2 输出: "apbqrs"
        System.out.println(test.mergeAlternately("ab","pqrs"));
        // 示例3 输出: "apbqcd"
        System.out.println(test.mergeAlternately("abcd","pq"));
    }
}



















