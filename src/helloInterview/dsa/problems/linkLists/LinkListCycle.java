package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class LinkListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LinkListCycle linkListCycle = new LinkListCycle();
        ListNode tail = new ListNode(5);
        ListNode list1 = new ListNode(4, tail);
        ListNode list2 = new ListNode(3,  list1);
        ListNode list3 = new ListNode(2, list2);
        ListNode head = new ListNode(1, list3);
        tail.next = list2;
        System.out.println(linkListCycle.hasCycle(head));
    }
}
