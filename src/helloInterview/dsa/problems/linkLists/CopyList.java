package helloInterview.dsa.problems.linkLists;
import helloInterview.dsa.linkList.NodeList;

public class CopyList {
    public NodeList copyRandomList(NodeList head) {
        return new NodeList(5);
    }
    public static void main(String[] args) {
        CopyList copyList = new CopyList();
        NodeList dummy = new NodeList(5);
        System.out.println(copyList.copyRandomList(dummy));
    }
}
