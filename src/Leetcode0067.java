public class Leetcode0067 {

    class Solution {
        public String addBinary(String a, String b) {
            //每次取最后一位进行相加，存入StringBuffer
            StringBuffer sb = new StringBuffer();
            int l1 = a.length() - 1;
            int l2 = b.length() - 1;
            int count = 0; // 记录进位
            while(l1 >= 0 || l2 >= 0 || count > 0){//count>0说明有进位，否则可能提前结束
                count += (l1 >= 0) ? a.charAt(l1--) - '0' : 0;
                count += (l2 >= 0) ? b.charAt(l2--) - '0' : 0;
                sb.append(count % 2);
                count = count / 2;
            }
            return sb.reverse().toString();
        }
    }

}
