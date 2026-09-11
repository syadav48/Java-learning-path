package helloInterview.dsa.linkList;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        List<Integer> reversed = list.reversed();

        return list.equals(reversed);
    }
    public static void main(String[] args) {
        PalindromeLinkList list = new PalindromeLinkList();
        ListNode tail = new ListNode(5);
        ListNode listNode2 = new ListNode(4, tail);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode head = new ListNode(5, listNode4);
        System.out.println(list.isPalindrome(head));
    }
}
