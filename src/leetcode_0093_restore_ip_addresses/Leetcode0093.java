package leetcode_0093_restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

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
