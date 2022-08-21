/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static class Pair{
        int coins;
        int size;
        Pair(int coins, int size){
            this.coins = coins;
            this.size = size;
        }
    }
    
    int ans;
    public Pair dfs(TreeNode root){
        if(root == null) return new Pair(0, 0);
        
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        ans = ans + Math.abs(left.coins - left.size)
                  + Math.abs(right.coins - right.size);
        
        return new Pair(root.val + left.coins + right.coins, 
                        1 + left.size + right.size);
    }
    
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
}