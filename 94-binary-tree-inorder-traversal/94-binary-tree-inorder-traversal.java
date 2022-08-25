class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        
        while(root != null){
            if(root.left == null) {
                inorder.add(root.val);
                root = root.right;
                continue;
            }
            
            TreeNode rightMost = root.left;
            while(rightMost.right != null && rightMost.right != root){
                rightMost = rightMost.right;
            }
            
            if(rightMost.right == null){
               // left subtree is not visited
               rightMost.right = root;
               root = root.left;
            } else {
                // left subtree is visited
                inorder.add(root.val);
                rightMost.right = null; 
                root = root.right;
            }
        }
        
        return inorder;
    }
}