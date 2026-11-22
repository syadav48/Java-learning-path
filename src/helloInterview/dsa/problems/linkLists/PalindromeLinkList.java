package helloInterview.dsa.problems.linkLists;

import helloInterview.dsa.linkList.ListNode;

public class PalindromeLinkList {
    //find middle
    // reverse middle
    // traverse and compare
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode curr = head;
        ListNode reversedMiddle = reverse(findMiddle(head));
        while (reversedMiddle != null){
            if(curr.val != reversedMiddle.val){
                return false;
            }
            curr = curr.next;
            reversedMiddle = reversedMiddle.next;
        }
        return true;
    }
    private ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
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
        PalindromeLinkList palindromeLinkList = new PalindromeLinkList();
        ListNode tail = new ListNode(1);
        ListNode list1 = new ListNode(2, tail);
        ListNode list2 = new ListNode(2,  list1);
        ListNode head = new ListNode(1, list2);
        System.out.println(palindromeLinkList.isPalindrome(head));

    }
}
