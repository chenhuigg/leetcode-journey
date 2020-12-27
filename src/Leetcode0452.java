import java.util.Arrays;

public class Leetcode0452 {

    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;

            // 排序
            Arrays.sort(points, (w1, w2) -> w1[0] < w2[0] ? -1 : 1);

            // 射击次数
            int count = 1;
            // 维护射击区间的右边界
            int right = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > right) { // 新的气球左端点大于射击区间右边界，更新射击区间右边界
                    count++;
                    right = points[i][1];
                } else { // 新的气球左端点小于等于射击区间的右边界
                    if (points[i][1] < right) { // 如果右端点也比射击区间右边界小
                        right = points[i][1];
                    }
                }
            }

            return count;
        }
    }
}
