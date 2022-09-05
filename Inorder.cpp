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
    
    void recursivePreorder(TreeNode* root, vector<int>& ans) {
        if(root == NULL) return;
        ans.push_back(root->val);
        recursivePreorder(root->left,ans);        
        recursivePreorder(root->right,ans);
    }
    
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int>ans;
        // recursivePreorder(root,ans);
        stack<TreeNode*> st;
        st.push(root);
        while(!st.empty()) {
            TreeNode* curr = st.top();
            st.pop();
            if(curr != NULL) {
                ans.push_back(curr->val);
                // stack is reverse
                if(curr->right != NULL) st.push(curr->right);
                if(curr->left != NULL) st.push(curr->left);
            }
        }
        return ans;
    }
};
