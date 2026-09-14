package helloInterview.dsa2.twoPointer.BST;

import helloInterview.dsa.dfs.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return dfs(root, k, seen);

    }
    public boolean dfs(TreeNode treeNode, int k, Set<Integer> set){
        if(treeNode == null){
            return false;
        }
        int required = k - treeNode.val;
        if(set.contains(required)){
            return true;
        }
        set.add(treeNode.val);
        System.out.println(set);
        return dfs(treeNode.left, k, set) || dfs(treeNode.right, k, set);
    }
    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        TreeNode leaf1 = new TreeNode(7);
        TreeNode leaf2 = new TreeNode(6, null, leaf1);
        TreeNode leaf3 = new TreeNode(2);
        TreeNode leaf4 = new TreeNode(4);
        TreeNode leaf5 = new TreeNode(3, leaf3, leaf4);
        TreeNode root = new TreeNode(5, leaf5, leaf2);

        System.out.println(findTarget.findTarget(root, 9));
    }
}
