package helloInterview.dsa.backTrack;

import helloInterview.dsa.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TotalPathSum {
    public List<List<Integer>> pathSum(TreeNode root, int tareget){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, new ArrayList<>(), 0, tareget, result);
        return result;
    }
    private void backtrack(TreeNode node, List<Integer> path, int total, int target, List<List<Integer>> result){
        if(node == null){
            return;
        }
        path.add(node.val);
        total += node.val;
        if(total > target){
            path.remove(path.size() - 1);
            return;
        }
        if(node.left == null && node.right == null){
            // add the path to the result
            // note we have to make a copy (new ArrayList<>(path)) of the path
            // since future recursive calls modify path
            if(total == target){
                result.add(new ArrayList<>(path));
            }
        }else {
            backtrack(node.left, path, total, target, result);
            backtrack(node.right, path, total, target, result);
        }
        path.remove(path.size() - 1);
    }
        public static void main(String[] args) {
        TotalPathSum totalPathSum = new TotalPathSum();
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(3, treeNode, treeNode1);
        TreeNode treeNode3 = new TreeNode(2, treeNode2, null);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(1, treeNode5, treeNode6);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(3);
        TreeNode treeNode10 = new TreeNode(8, treeNode8, treeNode9);
        TreeNode treeNode11 = new TreeNode(2, treeNode7, treeNode10);
        TreeNode root = new TreeNode(4, treeNode3, treeNode11);
        System.out.println(totalPathSum.pathSum(root, 11));

    }
}
