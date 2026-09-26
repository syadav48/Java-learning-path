package helloInterview.dsa.dfs;

import java.util.ArrayList;
import java.util.List;

 public class NAryNode {
    public int val;
    public List<NAryNode> children;

    public NAryNode() {}

    public NAryNode(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public NAryNode(int _val, List<NAryNode> _children) {
        val = _val;
        children = _children;
    }
};
