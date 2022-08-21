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
        int left, right;
        Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    int max = 0;
    
    public Pair dfs(TreeNode root){
        if(root == null) return new Pair(0, 0);
        
        Pair curr = new Pair(0, 0);
        
        if(root.left != null){
            Pair left = dfs(root.left);
            curr.left = 1 + left.right;
            max = Math.max(max, curr.left);
        } 
        
        if(root.right != null){
            Pair right = dfs(root.right);
            curr.right = 1 + right.left;
            max = Math.max(max, curr.right);
        }
        
        return curr;
    }
    
    public int longestZigZag(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }
}