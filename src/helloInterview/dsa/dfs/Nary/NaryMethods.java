package helloInterview.dsa.dfs.Nary;

import helloInterview.dsa.dfs.NAryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryMethods {
   // dfs pattern
    public void dfs(NAryNode root){
        System.out.println(root.val);
        for (NAryNode node: root.children){
            dfs(node);
        }
    }

    // root -> children
    public void preorder(NAryNode root){
        if(root == null){
            return;
        }
        dfs(root);
    }
    // children -> root
    public void postorder(NAryNode root){
        if(root == null){
            return;
        }
        for (NAryNode node: root.children){
            postorder(node);
        }
        System.out.println(root.val);
    }

    public List<List<Integer>> levelOrder(NAryNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<NAryNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NAryNode node = queue.poll();
                level.add(node.val);
                for (NAryNode node1: node.children){
                    queue.offer(node1);
                }
            }
            res.add(level);
        }
        return res;
    }
    public int maxValue(NAryNode root){
        if(root == null){
           return Integer.MIN_VALUE;
        }
        int max = root.val;
        for(NAryNode node: root.children){
          max = Math.max(max, maxValue(node));
        }
        return max;
    }
    public int height(NAryNode root){
        if(root == null){
            return 0;
        }
        int maxChild = 0;
        for (NAryNode node: root.children){
            maxChild = Math.max(maxChild, height(node));
        }
        return 1 + maxChild;
    }
    public int countNodes(NAryNode root) {

        if (root == null) {
            return 0;
        }

        int count = 1;

        for (NAryNode child : root.children) {
            count += countNodes(child);
        }

        return count;
    }



    public static void main(String[] args) {

    }
}
