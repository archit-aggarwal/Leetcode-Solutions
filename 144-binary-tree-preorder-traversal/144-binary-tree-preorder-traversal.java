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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        
        while(root != null){
            if(root.left == null) {
                preorder.add(root.val);
                root = root.right;
                continue;
            }
            
            TreeNode rightMost = root.left;
            while(rightMost.right != null && rightMost.right != root){
                rightMost = rightMost.right;
            }
            
            if(rightMost.right == null){
               // left subtree is not visited
               preorder.add(root.val);
               rightMost.right = root;
               root = root.left;
            } else {
                // left subtree is visited
                rightMost.right = null; 
                root = root.right;
            }
        }
        
        return preorder;
    }
}