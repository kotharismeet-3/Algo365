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
    vector<vector<int>>ans;
    
    void pathSumAll(TreeNode* root, int targetSum, vector<int> &v) {
        if(root  == NULL) return;
        v.push_back(root->val);
        if( targetSum == root->val && (root->left == NULL && root->right == NULL)) {
            ans.push_back(v);
            v.pop_back();
            return;
        }
        if(root->left != NULL) pathSumAll(root->left, targetSum - root->val, v); 
        
        if(root->right != NULL) pathSumAll(root->right, targetSum - root->val, v);
        v.pop_back();
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum)     {
        vector<int>v;
        pathSumAll(root, targetSum, v);
        return ans;
    }
};
