package helloInterview.dsa.linkList;

public class FindLength {
    public int findLength(ListNode head){
        int length = 0;
        ListNode current = head;
        while (current != null){
            length += 1;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        FindLength findLength = new FindLength();
        ListNode listNode3 = new ListNode(4);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(2, listNode2);
        ListNode listNode = new ListNode(1, listNode1);

        System.out.println(findLength.findLength(listNode));

    }
}
