public class Leetcode0026 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int length = nums.length;
            if (nums.length == 0) return 0;

            int i = 0;
            for (int j = 1; j < length; j++) {
                if (nums[i] != nums[j]) {
                    nums[++i] = nums[j];
                }
            }

            return i + 1;
        }
    }

}
