
class Solution {
    int operations = 0;
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        operations += Math.abs(left) + Math.abs(right);
        
        // (root.coins - root.size) = (left.coins - left.size) + (right.coins - right.size) + (root.val - 1)
        return left + right + (root.val - 1);
    }
    
    public int distributeCoins(TreeNode root) {
        operations = 0;
        dfs(root);
        return operations;
    }
}