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
    int maxPathSum(TreeNode *root,int &sum)
    {    
        if(root == NULL) return 0;
        int l = maxPathSum(root->left,sum);
        int r = maxPathSum(root->right,sum);
        int height = max({l + root->val, r + root->val, root->val});
        sum = max({sum, height, l + r + root->val}); 
        return height;
    }
    int maxPathSum(TreeNode* root) {
        if(root == NULL) return 0;
        int sum = INT_MIN;
        int i = maxPathSum(root, sum);
        return sum;
    }
};