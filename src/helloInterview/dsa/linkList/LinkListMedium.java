package helloInterview.dsa.linkList;

public class LinkListMedium {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        LinkListMedium listMedium = new LinkListMedium();
        ListNode tail = new ListNode(5);
        ListNode listNode1 = new ListNode(4, tail);
        ListNode listNode2 = new ListNode(3, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);
        listMedium.removeNthFromEnd(listNode4, 2); // 1235
    }
}
