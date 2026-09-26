package helloInterview.dsa.dfs;

import java.util.ArrayList;
import java.util.List;

public class PreorderTravrsal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
    public static void main(String[] args) {
        PreorderTravrsal preorderTravrsal = new PreorderTravrsal();
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(8, treeNode1, null);
        TreeNode treeNode4 = new TreeNode(3, null, treeNode3);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(5, treeNode2, treeNode5);
        TreeNode treeNode7 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(2, treeNode7, treeNode6);
        TreeNode treeNode9 = new TreeNode(1, treeNode8, treeNode4);
        TreeNode treeNode10 = new TreeNode(3);
        TreeNode treeNode11 = new TreeNode(2, treeNode10, null);
        TreeNode treeNode12 = new TreeNode(1, null, treeNode11);
        System.out.println(preorderTravrsal.preorderTraversal(treeNode9));
        //System.out.println(preorderTravrsal.preorderTraversal(treeNode12));
    }
}
