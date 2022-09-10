class Solution {
    List<Integer> inorder = new ArrayList<>();
    
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        inorder.add(root.val);
        dfs(root.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return inorder;
    }
}