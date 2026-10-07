package helloInterview.dsa.linkList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){};
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String str = String.valueOf(val);
        return String.valueOf(val);
    }
    public ListNode createLinkList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;

        // Iterate through the rest of the array
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }
    public void traverse(ListNode head){
        ListNode curr = head;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
