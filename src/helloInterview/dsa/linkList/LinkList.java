package helloInterview.dsa.linkList;

public class LinkList {
    public static void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static boolean search(ListNode head, int target) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            if (curr.val == target) return true;
            curr = curr.next;
        }
        return false;
    }

    public static int length(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static ListNode insert(ListNode head, int index, int val) {
        ListNode newNode = new ListNode(val);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index == length(head)) {
            // impl further...
        }
        return head;
    }

    public static ListNode deleteNode(ListNode head, int target) {
        if (head.val == target) {
            return head.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == target) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode fastAndSlow(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            System.out.println(prev + "  prev");
        }
        return prev;
    }

    public static ListNode insertAtHead(ListNode head, int val) {
        ListNode currHead = new ListNode(val);
        currHead.next = head;
        return currHead;
    }

    public static ListNode insertAtEnd(ListNode head, int val) {
        ListNode currEnd = new ListNode(val);
        ListNode currNode = head;
        if (head == null) {
            return currEnd;
        }
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = currEnd;
        return currNode;
    }

    public static void insertAfter(ListNode node, int val) {
        if (node == null) {
            return;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
    }

    public static ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return head;
    }

    public ListNode delete(ListNode head, int target) {

        if (head == null) {
            return null;
        }

        if (head.val == target) {
            return head.next;
        }

        ListNode curr = head;

        while (curr.next != null) {

            if (curr.next.val == target) {
                curr.next = curr.next.next;
                break;
            }

            curr = curr.next;
        }

        return head;
    }

    public static ListNode reverseLinkList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            System.out.println(prev + " curr:" + curr + " :next" + next);
        }

        return prev;
    }

    public static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        if(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                ListNode ptr = head;

                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }

                return ptr;
            }
        }

        return null;
    }

    public static ListNode nthNodeFromEnd(ListNode head, int n){
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode removeNthNodeFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return slow;
    }

    public ListNode merge(
            ListNode list1,
            ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        }

        if (list2 != null) {
            curr.next = list2;
        }

        return dummy.next;
    }

    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = middleNode(head);
        ListNode second = reverse(slow);
        ListNode first = head;
        while (second != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
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

        System.out.println("&&&&&&&&&&&&&&&&&&&&");
        ListNode tail1 = new ListNode(4);
        ListNode listNode8 = new ListNode(3, tail1);
        ListNode listNode7 = new ListNode(2, listNode8);
        ListNode listNode6 = new ListNode(1, listNode7);
        System.out.println(reverseLinkList(listNode6));

    }
}
