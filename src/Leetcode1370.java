public class Leetcode1370 {

    class Solution {
        public String sortString(String s) {
            int [] count = new int[26]; // 用于保存字母出现的次数
            int length = s.length();

            for (int i = 0; i < length; i++) { // 统计字母出现的次数
                count[s.charAt(i) - 'a']++;
            }

            StringBuffer sb = new StringBuffer();
            while (sb.length() < length) {
                for (int i = 0; i < 26; i++) { // 正序查找
                    if (count[i] > 0) {
                        sb.append((char) (i + 'a'));
                        count[i]--;
                    }
                }

                for (int i = 25; i >= 0; i--) { // 倒序查找
                    if (count[i] > 0) {
                        sb.append((char) (i + 'a'));
                        count[i]--;
                    }
                }
            }
            return sb.toString();
        }
    }
}
