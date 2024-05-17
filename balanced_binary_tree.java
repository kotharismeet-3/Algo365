
class Solution {
    Boolean balanced = true;

    public int dfs(TreeNode root) {
        if(!balanced) return 0;

        if(root == null) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        // System.out.println(root.val + " " + Math.abs(leftHeight - rightHeight));
        if(Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
            return 0;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }
}