/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 */
public class Leetcode0091 {

    class Solution {
        public int numDecodings(String s) {
            int len = s.length();

            int[] dp = new int[len + 1];
            dp[len] = 1; // 最末尾赋值为1，方便处理

            if (s.charAt(len - 1) != '0') { // 计算最后一位解码数量
                dp[len - 1] = 1;
            }

            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    continue;
                }
                int sum = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
                if (sum <= 26) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else {
                    dp[i] = dp[i + 1];
                }
            }

            return dp[0];
        }
    }
}
