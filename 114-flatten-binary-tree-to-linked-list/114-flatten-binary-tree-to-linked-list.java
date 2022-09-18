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
    class Pair{
        TreeNode head, tail;
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    
    public Pair dfs(TreeNode root){
        if(root == null) return new Pair(null, null);
        if(root.left == null && root.right == null){
            return new Pair(root, root);
        }
        
        if(root.left == null){
            Pair r = dfs(root.right);
            root.right = r.head;
            r.tail.right = null;
            return new Pair(root, r.tail);
        }
        
        if(root.right == null){
            Pair l = dfs(root.left);
            root.left = null;
            root.right = l.head;
            l.tail.right = null;
            return new Pair(root, l.tail);
        }
        
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        
        root.left = null;
        root.right = l.head;
        l.tail.right = r.head;
        r.tail.right = null;
        return new Pair(root, r.tail);
    }
    
    public void flatten(TreeNode root) {
        if(root != null) dfs(root);
    }
    
}