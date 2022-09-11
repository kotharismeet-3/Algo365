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
    
    vector<vector<int>> usingTwoStack(TreeNode* root) {
        vector<vector<int>> ans;
        int flag = 1;
        stack<TreeNode*>odd, even;
        if(root != NULL) odd.push(root);
        
        while(!odd.empty() || !even.empty()) {
            vector<int>v;
            if(flag%2) {
                v.clear();
                int _size = odd.size();
                for (int i=0;i<_size;i++) {
                    TreeNode* curr = odd.top();
                    odd.pop();
                    v.push_back(curr->val);
                    if(curr->left != NULL) even.push(curr->left);
                    if(curr->right != NULL) even.push(curr->right);
                }
            } else {
                v.clear();
                int _size = even.size();
                for (int i=0;i<_size;i++) {
                    TreeNode* curr = even.top();
                    even.pop();
                    v.push_back(curr->val);
                    if(curr->left != NULL) odd.push(curr->left);
                    if(curr->right != NULL) odd.push(curr->right);            
                }
            }
            ans.push_back(v);
        }
        return ans;
    }
    
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>>ans;
        
        queue<TreeNode*>q;
        bool flag = true;
        if(root != NULL) q.push(root);
        
        while(!q.empty()) {
            int _size = q.size();
            vector<int>temp(_size);
            for (int i=0;i<_size;i++) {
                TreeNode* curr = q.front();
                q.pop();
                int index = flag ? i : _size - i - 1;
                temp[index] = curr->val;
                if(curr->left != NULL) q.push(curr->left);
                if(curr->right != NULL) q.push(curr->right);   
            }
            ans.push_back(temp);
            flag = !flag;
        }
        
        return ans;
    }
};
