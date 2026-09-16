package helloInterview.dsa.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }
    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> result){
        if(node == null){
            return;
        }
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(node.val == target){
                result.add(new ArrayList<>(path));
            }
        }
        dfs(node.left, target- node.val, path, result);
        dfs(node.right, target- node.val, path, result);
        path.remove(path.size() - 1);
    }
    public static void main(String[] args) {
        PathSumII pathSumII = new PathSumII();
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(1, treeNode1, treeNode2);
        System.out.println(pathSumII.pathSum(treeNode3, 3));
    }
}
