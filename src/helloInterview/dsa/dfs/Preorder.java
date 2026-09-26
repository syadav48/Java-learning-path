package helloInterview.dsa.dfs;

import helloInterview.dsa.dfs.Nary.NaryMethods;

import java.util.ArrayList;
import java.util.List;

public class Preorder {
    public List<Integer> preorder(NAryNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    public void dfs(NAryNode node, List<Integer> result){
        if(node == null) return;
        result.add(node.val);
        for(NAryNode child: node.children){
            preorder(child);
        }
    }
    public static void main(String[] args) {
        Preorder preorder1 = new Preorder();
        NAryNode node1 = new NAryNode(4);
        NAryNode node2 = new NAryNode(2);
        NAryNode node3 = new NAryNode(5);
        NAryNode node4 = new NAryNode(6);
        NAryNode node5 = new NAryNode(3, List.of(node3, node4));
        NAryNode root = new NAryNode(1, List.of(node5, node2, node1));
        NAryMaxDepth nAryMaxDepth = new NAryMaxDepth();
        System.out.println(nAryMaxDepth.maxDepth(root));
    }
}
