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
    public static enum State {
        CAMERA, NEED, COVERED;
    }
    
    int cameras = 0;
    
    public State dfs(TreeNode root){
        if(root == null) return State.COVERED;
        
        State left = dfs(root.left);
        State right = dfs(root.right);
        
        if(left == State.NEED || right == State.NEED){
            cameras++;
            return State.CAMERA;
        }
        
        if(left == State.CAMERA || right == State.CAMERA){
            return State.COVERED;
        }
        
        return State.NEED;
    }
        
    public int minCameraCover(TreeNode root) {
        State ans = dfs(root);
        if(ans == State.NEED) cameras++;
        return cameras;
    }
}