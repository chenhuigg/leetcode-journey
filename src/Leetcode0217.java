import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Leetcode0217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set set = new HashSet();
            for (int num : nums) {
                set.add(num);
            }
            return nums.length != set.size();
        }
    }

    public static void main(String[] args) {

    }
}
