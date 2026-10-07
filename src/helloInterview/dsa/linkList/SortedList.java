package helloInterview.dsa.linkList;


public class SortedList {
    // find middle, head, merge both
    public ListNode sortedList(ListNode listNode){
        if(listNode == null || listNode.next == null) return listNode;
        ListNode middle = findMiddle(listNode);
        ListNode right = middle.next;
        middle.next = null;
        ListNode leftSorted = sortedList(listNode);
        ListNode rightSorted = sortedList(right);
        return mergeLists(leftSorted, rightSorted);
    }

    private ListNode findMiddle(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode mergeLists(ListNode listNode1, ListNode listNode2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (listNode1 != null && listNode2 != null){
            if(listNode1.val >= listNode2.val){
                curr.next = listNode2;
                listNode2 = listNode2.next;
            } else {
                curr.next = listNode1;
                listNode1 = listNode1.next;
            }
            curr = curr.next;
        }
        if(listNode1 != null){
            curr.next = listNode1;
        }
        if(listNode2 != null){
            curr.next = listNode2;
        }
        return dummy.next;
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
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode head = new ListNode(1, listNode3);
        SortedList list = new SortedList();
        traverse(head);
        System.out.println("original one listed above");

        ListNode sortedHead = list.sortedList(head);
        traverse(sortedHead);
        System.out.println("sorted one listed above");
    }
}
