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
    
    void recursiveInorder(TreeNode* root, vector<int>& ans) {
        if(root == NULL) return;
        recursiveInorder(root->left,ans); 
        ans.push_back(root->val);
        recursiveInorder(root->right,ans);
    }
    
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int>ans;
        // recursiveInorder(root,ans);
        stack<TreeNode*>st;
        TreeNode* curr=root;
        while(true) {
            if(curr != NULL) {
                st.push(curr);
                curr = curr->left;
            }
            else {
                if(st.empty()) break;
                curr = st.top();
                st.pop();
                ans.push_back(curr->val);
                curr = curr->right;
            }
        }
        return ans;
    }
};
