import util.TreeNode;

import java.util.*;

public class Leetcode0119 {

    /*class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();                // 记录当前层中节点个数
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.remove();     // 取出队首元素
                    if (i == 0) result.add(curr.val);   // 当前层最右边的元素
                    if (curr.right != null) queue.add(curr.right);
                    if (curr.left != null) queue.add(curr.left);
                }
            }

            return result;
        }
    }*/

    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode node, int level) {
            if (node == null) return;

            if (level == result.size()) {
                result.add(node.val);
            }

            if (node.right != null) dfs(node.right, level + 1);
            if (node.left != null) dfs(node.left, level + 1);
        }
    }

}
