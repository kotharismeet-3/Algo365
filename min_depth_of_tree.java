/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int heightThroughDFS(TreeNode root) {
        // base case
        if(root == null) return 0;
        // NLR
        int leftH = heightThroughDFS(root.left);
        int rightH = heightThroughDFS(root.right);
        // IMP check for left or right skewed tree
        if(leftH == 0) return 1 + rightH;
        if(rightH == 0) return 1 + leftH;
        return 1 + Math.min(leftH, rightH);
    }
    public int minDepth(TreeNode root) {
        return heightThroughDFS(root);
    }
}