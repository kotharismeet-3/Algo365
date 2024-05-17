private boolean isSameTree(TreeNode p, TreeNode q) {
    // base case
    if((p == null && q != null) || (p != null && q == null)) return false;
    else if(p == null && q == null) return true;
    // NLR
    return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));        
}

private boolean dfs(TreeNode root, TreeNode subroot) {
    if(root == null && subroot == null) return true;
    else if(
        (subroot == null) || 
        (root == null && subroot != null)) return false;

    else if(root.val == subroot.val && isSameTree(root, subroot)) return true;
    return dfs(root.left, subroot) || dfs(root.right, subroot);
}

public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    return dfs(root, subRoot);
}