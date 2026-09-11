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
    public static ListNode deleteNode(ListNode head, int target){
        if(head.val == target){
            return head.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            if(curr.val == target){
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return curr;
    }
    public static ListNode fastAndSlow(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            System.out.println(prev + "  prev");
        }
        return prev;
    }
    public static ListNode mergeList(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode current = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return head;

    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode listNode2 = new ListNode(11, tail);
        ListNode listNode3 = new ListNode(7, listNode2);
        ListNode listNode4 = new ListNode(9, listNode3);
        ListNode head = new ListNode(3, listNode4);
        traverse(head);
        deleteNode(head, 7);
        System.out.println(search(head, 7));
        System.out.println(length(head));
        System.out.println(head);
        System.out.println(fastAndSlow(head));
        System.out.println("###################");
        ListNode reverseHead = reverse(head);
        System.out.println(head);
        System.out.println(reverseHead);

    }
}
