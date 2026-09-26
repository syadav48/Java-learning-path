package helloInterview.dsa.dfs;

import java.util.ArrayList;
import java.util.List;

public class PostOrderNTraversal {
    public List<Integer> postorder(NAryNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    public void dfs(NAryNode node, List<Integer> result){
        if(node == null) return;
        for(NAryNode child: node.children){
            dfs(child, result);
        }
        result.add(node.val);
    }
    public static void main(String[] args) {

    }
}
