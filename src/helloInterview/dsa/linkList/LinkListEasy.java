package helloInterview.dsa.linkList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkListEasy {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (list1 != null && list2 != null){
            if(list1.val >= list2.val){
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if(list1 != null){
             curr.next = list1;
        }
        if(list2 != null){
             curr.next = list2;
        }
        return dummyNode.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        ListNode curr = head;
        while (curr != null){
            sum = (sum << 1) | curr.val;
            curr = curr.next;
        }
        return sum;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(0, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);

        ListNode listNode7 = new ListNode(1);
        ListNode listNode8 = new ListNode(1, listNode7);
        ListNode listNode9 = new ListNode(2, listNode8);
        ListNode listNode10 = new ListNode(3, listNode9);
        ListNode listNode11 = new ListNode(3, listNode10);
        LinkListEasy listEasy = new LinkListEasy();
        listEasy.mergeTwoLists(listNode3, listNode6);
        System.out.println(listEasy.deleteDuplicates(listNode11));
        System.out.println(listEasy.getDecimalValue(listNode6));
    }
}
