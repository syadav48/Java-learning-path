    package helloInterview.dsa.problems.linkLists;

    import helloInterview.dsa.linkList.ListNode;

    public class DetectCycle {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    ListNode ptr = head;
                    while (ptr != slow){
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;

        }
        public static void main(String[] args) {
            DetectCycle detectCycle = new DetectCycle();
            ListNode tail = new ListNode(-4);
            ListNode list1 = new ListNode(0, tail);
            ListNode list2 = new ListNode(2,  list1);
            ListNode head = new ListNode(3, list2);
            tail.next = list2;

            System.out.println(detectCycle.detectCycle(head));
        }
    }
