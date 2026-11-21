package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null){
            curr.next = list1;
        }
        if(list2.next != null){
            curr.next = list2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode tail = new ListNode(4);
        ListNode list1 = new ListNode(2, tail);
        ListNode list2 = new ListNode(1,  list1);
        ListNode tail1 = new ListNode(1);
        ListNode list3 = new ListNode(3, tail1);
        ListNode list4 = new ListNode(4,  list3);
        System.out.println(mergeTwoLists.mergeTwoLists(list2, list4));
    }
}
