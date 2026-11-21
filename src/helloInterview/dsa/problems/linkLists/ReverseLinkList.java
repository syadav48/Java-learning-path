package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
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
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        ListNode tail = new ListNode(5);
        ListNode list1 = new ListNode(4, tail);
        ListNode list2 = new ListNode(3,  list1);
        ListNode list3 = new ListNode(2, list2);
        ListNode head = new ListNode(1, list3);
        ListNode node = reverseLinkList.reverseList(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}
