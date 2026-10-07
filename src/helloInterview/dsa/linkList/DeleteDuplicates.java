package helloInterview.dsa.linkList;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null){
            boolean duplicate = false;
            while (curr.next != null && curr.val == curr.next.val){
                duplicate = true;
                curr = curr.next;
            }
            if(duplicate){
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        int[] nums = {1,2,3,3,4,4,5};
        ListNode listNode = new ListNode();
        ListNode head = listNode.createLinkList(nums);
        listNode.traverse(head);
        ListNode listNode1 = deleteDuplicates.deleteDuplicates(head);
        System.out.println("after deletion");
        listNode.traverse(listNode1);

    }
}
