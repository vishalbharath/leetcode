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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        func(ans,root,0);
        return ans;
    }
    void func(vector<vector<int>> & ans, TreeNode* temp,int x){
        if(temp==NULL){
            return ;
        }
        if(ans.size()<=x){
            ans.push_back({});
        }
        ans[x].push_back(temp -> val);
        func(ans, temp->left, x+1);
        func(ans, temp->right, x+1);
    }
};
