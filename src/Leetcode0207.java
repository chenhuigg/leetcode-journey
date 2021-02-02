import java.util.*;

public class Leetcode0207 {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses]; // 存储入度
            List<List<Integer>> edges = new ArrayList<>(); // 构建邻接表

            // 初始化入度和邻接表
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }

            for (int[] pre : prerequisites) {
                inDegree[pre[0]]++; // 记录入度
                edges.get(pre[1]).add(pre[0]);
            }

            Queue<Integer> queue = new LinkedList();
            // 将没有前置课程的课程编号放入队列中
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // 记录能完成的选修课程的数量
            int count = 0;
            while (!queue.isEmpty()) {
                count++;
                List<Integer> list = edges.get(queue.poll());
                if (list == null) continue;

                for (int val : list) {
                    int num = --inDegree[val];
                    // 入度为0，继续加入到队列中
                    if (num == 0) queue.offer(val);
                }
            }

            return count == numCourses;
        }
    }


}
