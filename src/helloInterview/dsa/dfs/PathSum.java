package helloInterview.dsa.dfs;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if((root.left == null) && (root.right == null)){
            return targetSum == root.val;
        }
        targetSum -= root.val;
        System.out.println(targetSum);
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(4, null, treeNode);
        TreeNode treeNode2 = new TreeNode(13);
        TreeNode treeNode3 = new TreeNode(8, treeNode2, treeNode1);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(11, treeNode5, treeNode4);
        TreeNode treeNode7 = new TreeNode(4, treeNode6, null);
        TreeNode treeNode8 = new TreeNode(5, treeNode7, treeNode3);
        System.out.println(pathSum.hasPathSum(treeNode8, 22));
    }
}
