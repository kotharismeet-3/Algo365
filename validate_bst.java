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

    private void inorderTraversal(TreeNode root, List<Integer> traversal) {
        if(root == null) return;
        inorderTraversal(root.left, traversal);
        traversal.add((Integer) root.val);
        inorderTraversal(root.right, traversal);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        inorderTraversal(root, traversal);
        int listSize = traversal.size();
        for(int i=1; i < listSize; i++) {
            if(traversal.get(i-1) >= traversal.get(i)) return false;
        }
        return true;
    }
}