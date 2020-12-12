package leetcode_0538_convert_bst_to_greater_tree;

import util.TreeNode;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 */
public class Leetcode0538 {

    class Solution {
        private int presum = 0;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return root;
            }
            convertBST(root.right);
            root.val += presum;
            presum = root.val;
            convertBST(root.left);
            return root;
        }
    }

}
