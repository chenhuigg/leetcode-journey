public class Leetcode0190 {

    /*public class Solution {
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result <<= 1;
                result += (1 & n);
                n >>= 1;
            }
            return result;
        }
    }*/

    /*public class Solution {
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result <<= 1;
                result |= n & 1;
                n >>= 1;
            }
            return result;
        }
    }*/

    public class Solution {
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 33; i++) {
                result |= n & 1;
                result <<= 1;
                n >>= 1;
            }
            return result;
        }
    }

}
