import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode0102 {

    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return result;
            search(root, 0);
            return result;
        }

        private void search(TreeNode root, int level) {
            if (level >= result.size())
                result.add(new ArrayList<>());

            result.get(level).add(root.val);

            if (root.left != null) {
                search(root.left, level + 1);
            }
            if (root.right != null) {
                search(root.right, level + 1);
            }
        }
    }

}
