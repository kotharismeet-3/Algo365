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
    int minDepth(TreeNode* root) {
        if( root == NULL) return 0;
        int lHeight = minDepth(root->left);
        // as nodes can be max 10^5 for skewed tree max height can be same, if not present will take 1 as min
        if(lHeight == 0) lHeight = (int)1e6;
        int rHeight = minDepth(root->right);
        // as nodes can be max 10^5 for skewed tree max height can be same, if not present will take 1 as min
        if(rHeight == 0) rHeight = (int)1e6;
        // if it's leave node return 1
        if(lHeight == rHeight && rHeight == (int)1e6) return 1;
        return min(lHeight, rHeight)+1;
    }
};
