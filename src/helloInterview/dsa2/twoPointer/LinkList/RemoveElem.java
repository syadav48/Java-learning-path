package helloInterview.dsa2.twoPointer.LinkList;

import helloInterview.dsa.linkList.ListNode;

public class RemoveElem {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }

        }
        return dummy.next;
    }
    public static void main(String[] args) {
        RemoveElem removeElem = new RemoveElem();
        ListNode tail = new ListNode(6);
        ListNode listNode1 = new ListNode(5, tail);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(6, listNode3);
        ListNode listNode5 = new ListNode(2, listNode4);
        ListNode head = new ListNode(1, listNode5);
        System.out.println(removeElem.removeElements(head, 6));
        ListNode curr = head;
        while (curr != null){
            System.out.println(curr.val + ": val");
            curr = curr.next;

        }
    }
}
