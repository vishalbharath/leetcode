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
    int maxx = 0;
    int diameterOfBinaryTree(TreeNode* root) {
        func(root);
        return maxx;
    }
    int func(TreeNode* node){
        if(!node){
            return 0;
        }
        int left = func(node->left);
        int right = func(node->right);
        maxx = max(maxx, left + right);
        return max(left , right)+1;
    }
};
