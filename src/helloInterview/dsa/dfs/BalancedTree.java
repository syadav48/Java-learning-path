package helloInterview.dsa.dfs;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = caculateHeight(root.left);
        int rightHeight = caculateHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int caculateHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = caculateHeight(root.left);
        int right = caculateHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean isBalancedOpt(TreeNode root) {
       return checkHeight(root) != 1;
    }
    private int checkHeight(TreeNode node){
        if (node == null) return 0;
        int left = checkHeight(node.left);
        int right = checkHeight(node.right);
        if(left == -1) return -1;
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BalancedTree balancedTree = new BalancedTree();
//        TreeNode treeNode = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(15);
//        TreeNode treeNode2 = new TreeNode(20, treeNode1, treeNode);
//        TreeNode treeNode3 = new TreeNode(9);
//        TreeNode treeNode4 = new TreeNode(3, treeNode3, treeNode2);

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode10 = new TreeNode(4);
        TreeNode treeNode11 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode10, treeNode11);
        TreeNode treeNode12 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(2, treeNode3, treeNode12);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(5, treeNode2, treeNode5);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(2, treeNode7, treeNode6);
        TreeNode treeNode9 = new TreeNode(1, treeNode4, treeNode1);
        System.out.println(balancedTree.isBalanced(treeNode9));
    }
}
