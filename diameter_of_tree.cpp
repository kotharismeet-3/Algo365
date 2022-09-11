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
    
    
    
    int diameter (TreeNode* root, int& globalDiameter) {
        if( root == NULL ) return 0;
        int lHeight = diameter(root->left, globalDiameter);
        int rHeight = diameter(root->right, globalDiameter);
        globalDiameter = max(globalDiameter, lHeight+rHeight);
        return 1+max(lHeight,rHeight);
    }
    
    int diameterOfBinaryTree(TreeNode* root) {
        int globalDiameter = 0;
        diameter(root, globalDiameter);
        return globalDiameter;
    }
};
