import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 */

public class Leetcode0093 {
    class Solution {
        List<String> list = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
            search(1, s, "");
            return list;
        }

        /**
         * @param n ：第n个片段
         * @param s ：剩余字符串
         * @param address ：地址
         */
        public void search(int n, String s, String address) {
            if (n == 5 && s.length() == 0) {
                list.add(address.substring(1));
                return;
            }
            if (n >= 5) {
                return;
            }

            // 获取剩余块数
            int remain = 5 - n;
            if (s.length() < remain || s.length() > 3 * remain) {
                return;
            }

            for (int i = 1; i <= 3; i++) { // 判断3块
                if (s.length() < i) {
                    return;
                }
                String part = s.substring(0, i);
                int num = Integer.parseInt(part);
                //比较长度，判断是否为0xx类型
                if (part.length() != String.valueOf(num).length()) {
                    return;
                }
                if (num > 255) { // 取值范围为0~255
                    return;
                }
                search(n + 1, s.substring(i), address + "." + part);
            }
        }
    }
}
