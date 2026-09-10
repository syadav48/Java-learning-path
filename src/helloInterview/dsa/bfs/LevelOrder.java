package helloInterview.dsa.bfs;

import helloInterview.dsa.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<Integer> level_order_sum(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(3, null, treeNode1);
        TreeNode treeNode3 = new TreeNode(2, treeNode2, null);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode root = new TreeNode(1, treeNode3, treeNode4);
        System.out.println(levelOrder.level_order_sum(root));
    }
}
