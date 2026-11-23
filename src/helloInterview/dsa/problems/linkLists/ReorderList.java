package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class ReorderList {
    // find middle
    // reverse second half
    // merge both half halves alternately.
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
       ListNode slow = head;
       ListNode fast = head;

       while (fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       ListNode second = slow.next;
       slow.next = null;
       second = reverse(second);
       ListNode first = head;
       while (second != null){
           ListNode temp1 = first.next;
           ListNode temp2 = second.next;

           first.next = second;
           second.next = temp1;
           first = temp1;
           second = temp2;
       }
    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode tail1 = new ListNode(5);
        ListNode tail = new ListNode(4, tail1);
        ListNode list2 = new ListNode(3,  tail);
        ListNode list3 = new ListNode(2, list2);
        ListNode head = new ListNode(1, list3);
        reorderList.reorderList(head);
        // 1 2 3 4 5
        // 3 4 5 -> 5 4 3
        // 1 2
        // 1 5 2 4 3
    }
}
