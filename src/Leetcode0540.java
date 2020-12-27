public class Leetcode0540 {

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (mid == 0 || nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                }
                if ((mid & 1) == 1 && nums[mid] == nums[mid - 1] || (mid & 1) == 0 && nums[mid] == nums[mid + 1]) {
                    // 左指针向右移动
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return nums[left];
        }
    }
}
