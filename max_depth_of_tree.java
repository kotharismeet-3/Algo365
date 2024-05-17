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
        return 1 + Math.max(
            heightThroughDFS(root.left), 
            heightThroughDFS(root.right)
        );
    }

    public int maxDepth(TreeNode root) {
        return heightThroughDFS(root);
    }
}