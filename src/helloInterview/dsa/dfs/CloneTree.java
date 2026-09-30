package helloInterview.dsa.dfs;

public class CloneTree {
    public TreeNode clone(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Create a new node with the same value
        TreeNode newNode = new TreeNode(root.val);
        // Recursively clone left and right subtrees
        newNode.left = clone(root.left);
        newNode.right = clone(root.right);
        return newNode;
    }
}

