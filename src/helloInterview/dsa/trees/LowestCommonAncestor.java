package helloInterview.dsa.trees;

import helloInterview.dsa.dfs.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode rootLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode rootRight = lowestCommonAncestor(root.right, p, q);

        if(rootLeft != null && rootRight != null){
            return root;
        }
        return rootLeft != null ? rootLeft : rootRight;
    }
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
           return lowestCommonAncestorBST(root.left, p, q);
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorBST(root.right, p, q);
        }
        return root;
    }
    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(1, treeNode2, treeNode1);

        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(2, treeNode4, treeNode5);

        TreeNode treeNode7 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(5, treeNode7, treeNode6);

        TreeNode treeNode9 = new TreeNode(3, treeNode8, treeNode3);




        System.out.println(lowestCommonAncestor.lowestCommonAncestor(treeNode9, treeNode8, treeNode3));
    }
}
