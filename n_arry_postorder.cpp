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
    vector<int> postorder(Node* root) {
        vector<int>ans;
        stack<Node*> st1, st2;
        st1.push(root);
        while(!st1.empty()) {
            Node* curr = st1.top();
            st1.pop();
            if(curr != NULL) {
                st2.push(curr);
                for(auto it: curr->children) {
                    st1.push(it);
                }
            }
        }
        while(!st2.empty()) {
            Node* curr = st2.top();
            st2.pop();
            ans.push_back(curr->val);
        }
        return ans;
    }
};
