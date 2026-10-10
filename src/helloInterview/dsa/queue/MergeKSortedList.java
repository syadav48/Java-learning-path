package helloInterview.dsa.queue;

import helloInterview.dsa.linkList.ListNode;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node: lists){
            if(node != null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(3, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);

        ListNode listNode7 = new ListNode(6);
        ListNode listNode8 = new ListNode(2, listNode7);

        ListNode[] listNodes = new ListNode[]{listNode3, listNode6, listNode8};

        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode listNode = mergeKSortedList.mergeKLists(listNodes);
        listNode4.traverse(listNode);


    }
}
