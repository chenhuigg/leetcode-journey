public class Leetcode0135 {

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalGas = 0;
            int totalCost = 0;

            for (int i = 0; i < gas.length; i++) {
                totalGas += gas[i];
                totalCost += cost[i];
            }

            if (totalGas < totalCost) { // 必定无法到达
                return -1;
            }

            int start = 0;  // 起始位置
            int sum = 0;    // 剩余油量
            for (int i = 0; i < gas.length; i++) {
                // gas[i]：当前加油站油量
                // cost[i]：到达下一个加油站需要消耗的油量
                sum += gas[i] - cost[i];
                if (sum < 0) {
                    start = i + 1;
                    sum = 0;
                }
            }

            return start;
        }
    }

}
