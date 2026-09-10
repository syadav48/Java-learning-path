package helloInterview.dsa.bfs;

import helloInterview.dsa.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<Integer> bfs(TreeNode node){
        if(node == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            result.add(currNode.val);
            if(currNode.left != null){
                queue.offer(currNode.left);
            }
            if(currNode.right != null){
                queue.offer(currNode.right);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        BFS bfs = new BFS();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2, treeNode1, treeNode2);

        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(7, treeNode3, treeNode4);
        TreeNode treeNode7 = new TreeNode(4, treeNode5, treeNode6);

        System.out.println(bfs.bfs(treeNode7));




    }
}
