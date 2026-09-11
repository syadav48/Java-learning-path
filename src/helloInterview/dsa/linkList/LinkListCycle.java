package helloInterview.dsa.linkList;

import java.util.HashSet;
import java.util.Set;

public class LinkListCycle {
     public boolean hasCycle(ListNode head){
         Set<ListNode> visitedNodes = new HashSet<>();
         ListNode currentNode = head;
         while (currentNode != null){
             if(visitedNodes.contains(currentNode)){
                 return true;
             }
             visitedNodes.add(currentNode);
             currentNode = currentNode.next;
         }
         return false;
     }
    public boolean hasCycleOpt(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
         LinkListCycle cycle = new LinkListCycle();
        ListNode tail = new ListNode(0);
        ListNode tail1 = new ListNode(2, tail);
        ListNode listNode2 = new ListNode(3, tail1);
        ListNode listNode4 = new ListNode(4, listNode2);
        ListNode head = new ListNode(5, listNode4);
        System.out.println(cycle.hasCycle(head));
    }
}
