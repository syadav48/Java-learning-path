package helloInterview.dsa.linkList;

public class LinkList {
    public static void traverse(ListNode head){
        ListNode curr = head;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public static boolean search(ListNode head, int target){
        ListNode curr = head;
        while (curr != null){
            System.out.println(curr.val);
            if(curr.val == target) return true;
            curr = curr.next;
        }
        return false;
    }
    public static int length(ListNode head){
        ListNode curr = head;
        int count = 0;
        while (curr.next != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
    public static ListNode insert(ListNode head, int index, int val){
        ListNode newNode = new ListNode(val);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        } else if (index == length(head)) {
            // impl further...
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode listNode2 = new ListNode(11, tail);
        ListNode listNode3 = new ListNode(7, listNode2);
        ListNode listNode4 = new ListNode(9, listNode3);
        ListNode head = new ListNode(3, listNode4);
        traverse(head);
        System.out.println(search(head, 7));
        System.out.println(length(head));

    }
}
