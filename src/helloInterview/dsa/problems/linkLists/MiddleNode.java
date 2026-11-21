package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        MiddleNode middleNode = new MiddleNode();
        ListNode tail = new ListNode(5);
        ListNode list1 = new ListNode(4, tail);
        ListNode list2 = new ListNode(3,  list1);
        ListNode list3 = new ListNode(2, list2);
        ListNode head = new ListNode(1, list3);
        System.out.println(middleNode.middleNode(head));
    }
}
