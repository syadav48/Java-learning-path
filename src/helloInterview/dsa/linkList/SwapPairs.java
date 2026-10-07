package helloInterview.dsa.linkList;

import java.util.List;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true){
            ListNode second = groupPrev;
            // finding 2nd node
            for (int i = 0; i < 2; i++) {
                second = second.next;
                if(second == null){
                    return dummy.next;
                }
            }

            // save next group:
            ListNode groupNext = second.next;

            // reversing current group:
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // connect prev group
            ListNode groupStart = groupPrev.next;
            groupPrev.next = second;

            // move to next group:
            groupPrev = groupStart;
        }
    }

    public static void traverse(ListNode head){
        ListNode curr = head;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        SwapPairs pairs = new SwapPairs();
        ListNode listNode = new ListNode(5);
        ListNode listNode0 = new ListNode(4, listNode);
        ListNode listNode1 = new ListNode(3, listNode0);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode head = new ListNode(1, listNode2);
        traverse(head);
        System.out.println("b4 traversing");
        ListNode listNode3 = pairs.swapPairs(head);
        traverse(listNode3);
        System.out.println("after traversal");

    }
}
