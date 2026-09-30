package helloInterview.dsa.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSEasy2 {
    int sum = 0;
    private int val;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
        String binary = String.valueOf(root.val) +
                String.valueOf(sumRootToLeaf(root.left)) +
                String.valueOf(sumRootToLeaf(root.right));
        System.out.println(binary);
        sum += Integer.parseInt(binary, 2);

        return sum;
    }

    public int sumRootToLeafOpt(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int current) {
        if(root == null){
            return 0;
        }
        current = current * 2 + root.val;
        //Leaf:
        if(root.left == null && root.right == null){
            return current;
        }
        System.out.println(current);
        return dfs(root.left, current) + dfs(root.right, current);
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
       return dfsUnival(root, root.val);
    }

    private boolean dfsUnival(TreeNode root, int val) {
        if(root == null) return true;
        if(root.val != val){
            return false;
        }
        return dfsUnival(root.left, val) && dfsUnival(root.right, val);

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfsSimilar(root1, list1);
        dfsSimilar(root2, list2);
        return list1.equals(list2);

    }

    private void dfsSimilar(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        dfsSimilar(root.left, list);
        dfsSimilar(root.right, list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root != null){
            dfsPaths(root, "", list);
        }
        return list;
    }

    private void dfsPaths(TreeNode root, String path, List<String> list) {
        if(root == null){
            return;
        }
        path = path.isEmpty() ? String.valueOf(root.val) : path + "->" + root.val;
        if(root.left == null && root.right == null){
            list.add(path);
            return;
        }
        dfsPaths(root.left, path, list);
        dfsPaths(root.right, path, list);
    }


    public static void main(String[] args) {
        DFSEasy2 dfsEasy2 = new DFSEasy2();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(0, treeNode1, treeNode);
        TreeNode treeNode6= new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(1, treeNode3, treeNode6);
        TreeNode treeNode5 = new TreeNode(1, treeNode2, treeNode4);
        System.out.println(dfsEasy2.sumRootToLeafOpt(treeNode5));

        TreeNode treeNode9 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(4, treeNode7, treeNode9);

        TreeNode treeNode13 = new TreeNode(2);
        TreeNode treeNode14 = new TreeNode(3);
        TreeNode treeNode15 = new TreeNode(7, treeNode14, treeNode13);


        System.out.println(dfsEasy2.leafSimilar(treeNode8, treeNode15));

        TreeNode treeNode10 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(1, treeNode11, treeNode10);
        System.out.println(dfsEasy2.isUnivalTree(treeNode12));

        System.out.println(dfsEasy2.binaryTreePaths(treeNode8));
    }
}
