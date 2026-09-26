package helloInterview.dsa.dfs;

import java.util.List;

public class NAryMaxDepth {
    public int maxDepth(NAryNode root) {
        if(root == null){
            return 0;
        }
        int max = 0;
        for(NAryNode node: root.children){
            max = Math.max(max, maxDepth(node));
        }
        return 1 + max;
    }
    public static void main(String[] args) {
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
