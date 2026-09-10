package helloInterview.dsa.dfs;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(20, treeNode3, treeNode4);
        TreeNode treeNode = new TreeNode(3, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(1, null, treeNode5);
        System.out.println(maxDepth.maxDepth(treeNode));
        System.out.println(maxDepth.maxDepth(treeNode6));
    }
}
