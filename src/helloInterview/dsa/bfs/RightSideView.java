package helloInterview.dsa.bfs;

import helloInterview.dsa.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(i == levelSize - 1){
                    result.add(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
   public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();
       TreeNode treeNode1 = new TreeNode(5);
       TreeNode treeNode2 = new TreeNode(4,treeNode1, null);
       TreeNode treeNode3 = new TreeNode(2, treeNode2, null);
       TreeNode treeNode4 = new TreeNode(3);
       TreeNode root = new TreeNode(1, treeNode3, treeNode4);
       System.out.println(rightSideView.rightSideView(root));
    }
}
