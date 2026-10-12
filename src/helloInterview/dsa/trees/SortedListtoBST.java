package helloInterview.dsa.trees;

import helloInterview.dsa.dfs.TreeNode;
import helloInterview.dsa.linkList.ListNode;

public class SortedListtoBST {
    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }
    public static void main(String[] args) {
        SortedListtoBST listtoBST = new SortedListtoBST();
        ListNode tail = new ListNode(9);
        ListNode listNode = new ListNode(5, tail);
        ListNode listNode1 = new ListNode(0, listNode);
        ListNode listNode2 = new ListNode(-3, listNode1);
        ListNode head = new ListNode(10, listNode2);
        listtoBST.sortedListToBST(head);
    }
}
