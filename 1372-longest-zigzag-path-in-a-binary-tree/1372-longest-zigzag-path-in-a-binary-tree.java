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
        int max, left, right;
        Pair(int max, int left, int right){
            this.max = max;
            this.left = left;
            this.right = right;
        }
    }
    
    public Pair dfs(TreeNode root){
        if(root == null) return new Pair(0, 0, 0);
        
        Pair curr = new Pair(0, 0, 0);
        
        if(root.left != null){
            Pair left = dfs(root.left);
            curr.left = 1 + left.right;
            curr.max = Math.max(curr.max, curr.left);
            curr.max = Math.max(curr.max, left.max);
        } 
        
        if(root.right != null){
            Pair right = dfs(root.right);
            curr.right = 1 + right.left;
            curr.max = Math.max(curr.max, curr.right);
            curr.max = Math.max(curr.max, right.max);
        }
        
        return curr;
    }
    
    public int longestZigZag(TreeNode root) {
        return dfs(root).max;
    }
}