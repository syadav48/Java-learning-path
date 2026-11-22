package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        RemoveNthNode removeNthNode = new RemoveNthNode();
        ListNode tail = new ListNode(5);
        ListNode list1 = new ListNode(4, tail);
        ListNode list2 = new ListNode(3,  list1);
        ListNode list3 = new ListNode(2, list2);
        ListNode head = new ListNode(1, list3);
        System.out.println(removeNthNode.removeNthFromEnd(head, 5));
    }
}
