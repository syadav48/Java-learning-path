package helloInterview.dsa.linkList;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k ){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true){
            //1. find Kth node;
            ListNode kth = groupPrev;

            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if(kth == null){
                    return dummy.next;
                }
            }
            //2. Save next group:
            ListNode groupNext = kth.next;

            // 3. Reverse Current Group:
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            //4. connect previous group:
            ListNode groupStart = groupPrev.next;
            groupPrev.next = kth;

            //5. Move to next group:
            groupPrev = groupStart;

        }
    }

    public static void traverse(ListNode head){
        ListNode curr = head;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        ListNode head = new ListNode(1, listNode4);
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        traverse(head);
        System.out.println("b4 kth reversal");
        ListNode head1 = reverseKGroup.reverseKGroup(head, 2);
        traverse(head1);
        System.out.println("after reversal");


    }
}
