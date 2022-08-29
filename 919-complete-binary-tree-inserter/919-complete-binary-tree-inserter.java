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

class CBTInserter {
    HashMap<Integer, TreeNode> index;

    public void helper(TreeNode root, int idx){
        if(root == null) return;
        index.put(idx, root);
        
        helper(root.left, 2 * idx + 1);
        helper(root.right, 2 * idx + 2);
    }
    
    public CBTInserter(TreeNode root) { 
        index = new HashMap<>();
        helper(root, 0); 
    }
    
    public int insert(int val) {
        TreeNode parent = index.get((index.size() - 1) / 2);
        TreeNode child = new TreeNode(val);
        index.put(index.size(), child);
        
        if(index.size() % 2 == 0) parent.left = child;
        else parent.right = child;
        
        return parent.val;
    }
    
    public TreeNode get_root() {
        return index.getOrDefault(0, null);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */