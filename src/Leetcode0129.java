import util.TreeNode;

public class Leetcode0129 {

    class Solution {
        int count = 0;
        public int sumNumbers(TreeNode root) {
            search(0, root);
            return count;
        }

        private void search(int val, TreeNode root) {
            if (root == null) {
                return;
            }

            val = val * 10 + root.val;

            if (root.left == null && root.right == null) {
                count += val;
            }
            search(val, root.left);
            search(val, root.right);
        }
    }
}
