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

    public boolean DFS(TreeNode p, TreeNode q) {
        // base case
        if((p == null && q != null) || (p != null && q == null)) return false;
        else if(p == null && q == null) return true;
        // NLR
        return (p.val == q.val && DFS(p.left, q.right) && DFS(p.right, q.left));        
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return DFS(root.left, root.right);
    }
}