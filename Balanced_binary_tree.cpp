/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    int heightTree(TreeNode* root) {
        if( root == NULL) return 0;
        int lHeight = heightTree(root->left);
        if(lHeight == -1) return -1;
        int rHeight = heightTree(root->right);
        if(rHeight == -1) return -1;
        if(abs(lHeight-rHeight) > 1) return -1;
        return max(lHeight, rHeight)+1;
    }
    
    bool isBalanced(TreeNode* root) {
        return heightTree(root) != -1;
    }
};
