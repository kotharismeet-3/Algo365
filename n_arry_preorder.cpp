/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int>ans;
        stack<Node*>st;
        st.push(root);
        while(!st.empty()) {
            Node* curr = st.top();
            st.pop();
            if(curr != NULL) {
                ans.push_back(curr->val);
                // whole right
                reverse(curr->children.begin(), curr->children.end());
                for (auto it: curr->children) {
                    st.push(it);
                }
            }
        }
        return ans;
    }
};
