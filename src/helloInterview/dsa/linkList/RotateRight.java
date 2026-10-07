package helloInterview.dsa.linkList;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        while (k > 0){
            head = rotateOnce(head);
            k--;
        }
        return head;
    }
    private ListNode rotateOnce(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr.next != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        curr.next = head;

        return curr;
    }

    public static void traverse(ListNode head){
        if(head == null){
            return;
        }
        ListNode curr = head;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(4, listNode);
        ListNode listNode2 = new ListNode(3, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode head = new ListNode(1, listNode3);
        traverse(head);
        System.out.println("before rotation");
        ListNode listNode4 = rotateRight.rotateRight(head, 2);
        traverse(listNode4);
        System.out.println("after rotation");
    }
}
