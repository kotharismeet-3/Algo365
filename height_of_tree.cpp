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
        int rHeight = heightTree(root->right);
        return max(lHeight, rHeight)+1;
    }
    
    int height(TreeNode* root) {
        return heightTree(root);
    }
};
