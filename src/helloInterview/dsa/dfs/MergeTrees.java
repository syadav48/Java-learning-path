package helloInterview.dsa.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }
    public static void main(String[] args) {
      TreeNode treeNode1 = new TreeNode(5);
      TreeNode treeNode2 = new TreeNode(3, treeNode1, null);
      TreeNode treeNode3 = new TreeNode(2);
      TreeNode treeNode4 = new TreeNode(1, treeNode2, treeNode3);

        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(3, null, treeNode5);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(1, null, treeNode7);
        TreeNode treeNode9 = new TreeNode(2, treeNode8, treeNode6);

        MergeTrees mergeTrees = new MergeTrees();
        mergeTrees.mergeTrees(treeNode4, treeNode9);
    }
}
