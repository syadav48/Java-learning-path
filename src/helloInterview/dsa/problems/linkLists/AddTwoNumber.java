package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(6, listNode4);
        ListNode listNode6 = new ListNode(5, listNode5);
        System.out.println(addTwoNumber.addTwoNumbers(listNode3, listNode6));
    }
}
