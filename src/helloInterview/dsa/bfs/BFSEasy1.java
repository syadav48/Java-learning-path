package helloInterview.dsa.bfs;

import helloInterview.dsa.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSEasy1 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode ParentX = null;
            TreeNode ParentY = null;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if(curr.left != null){
                    if(curr.left.val == x) ParentX = curr;
                    if(curr.left.val == y) ParentY = curr;
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    if(curr.right.val == x) ParentX = curr;
                    if(curr.right.val == y) ParentY = curr;
                    queue.offer(curr.right);
                }
            }
            if(ParentX != null && ParentY != null){
                return ParentX != ParentY;
            }
            if(ParentX != null || ParentY != null){
                return false;
            }
        }
        return false;
    }
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            res.add(sum/size);
            System.out.println(res);
        }
        return res;

    }
    public static void main(String[] args) {
        BFSEasy1 bfs = new BFSEasy1();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(2, treeNode1, treeNode2);

        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(7, treeNode3, treeNode4);
        TreeNode treeNode7 = new TreeNode(4, treeNode5, treeNode6);

        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(2, treeNode8, null);
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(1, treeNode9, treeNode11);

        System.out.println(bfs.isCousins(treeNode12, 4, 3));

        System.out.println(bfs.averageOfLevels(treeNode5));
    }
}
