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
    
    void recursivePostorder(TreeNode* root, vector<int>& ans) {
        if(root == NULL) return;
        recursivePostorder(root->left,ans);        
        recursivePostorder(root->right,ans);
        ans.push_back(root->val);
    }
    
    vector<int> postOrderUsingTwoStacks(TreeNode* root) {
        vector<int>ans;
        stack<TreeNode*> st1, st2;
        st1.push(root);
        while(!st1.empty()) {
            TreeNode* curr = st1.top();
            st1.pop();
            if(curr != NULL) {
                st2.push(curr);
                if(curr->left != NULL) st1.push(curr->left);
                if(curr->right != NULL) st1.push(curr->right);
            }
        }
        while(!st2.empty()) {
            TreeNode* curr = st2.top();
            st2.pop();
            ans.push_back(curr->val);
        }
        return ans;
    }
    
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int>ans;
        // recursivePostorder(root, ans);
        // return postOrderUsingTwoStacks(root);
        stack<TreeNode*>st;
        TreeNode* curr=root;
        
        while( curr != NULL || !st.empty()) {
            if(curr != NULL) {
                st.push(curr);
                curr = curr->left;
            }
            else {
                TreeNode* temp = (st.top())->right;
                if(temp == NULL) {
                    temp = st.top();
                    st.pop();
                    ans.push_back(temp->val);
                    while(!st.empty() && temp == (st.top())->right) {
                        temp = st.top();
                        st.pop();
                        ans.push_back(temp->val);
                    }
                }
                else curr = temp;
            }
        }
        
        return ans;
        // 
    }
};
