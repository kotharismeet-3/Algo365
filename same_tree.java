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
 *     }5
 * }
 */
class Solution {

    private boolean DFS(TreeNode p, TreeNode q) {
        // base case
        if((p == null && q != null) || (p != null && q == null)) return false;
        else if(p == null && q == null) return true;
        // NLR
        return (p.val == q.val && DFS(p.left, q.left) && DFS(p.right, q.right));        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return DFS(p, q);   
    }
}