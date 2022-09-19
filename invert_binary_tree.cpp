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
    
    void inorderTraversal(TreeNode* root) {
        if(root == NULL) return;
        inorderTraversal(root->left);
        inorderTraversal(root->right);
        
        TreeNode* temp = NULL; 
        if(root->right != NULL) temp = root->right;
        root->right = root->left;
        root->left = temp;
        
        return;
    }
    
    TreeNode* invertTree(TreeNode* root) {
        inorderTraversal(root);
        return root;
    }
};
