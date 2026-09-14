package helloInterview.dsa2.twoPointer.LinkList;

import helloInterview.dsa.linkList.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while (curr1 != null){
            list1.add(curr1.val);
            curr1 = curr1.next;
        }
        while (curr2 != null){
            list2.add(curr2.val);
            curr2 = curr2.next;
        }
        System.out.println(list1 + " list2" + list2);
        Set<Integer> set = new HashSet<>();
        for(int num: list1){
            set.add(num);
        }
        for(int num: list2){
            if(set.contains(num)){
                System.out.println(num + "here is the");
                break;
            }
        }
    return headA;

    }
    public ListNode getIntersectionNodeOpt(ListNode headA, ListNode headB){
        Set<ListNode> visited = new HashSet<>();
        ListNode current = headA;
        while (current != null){
            visited.add(current);
            current = current.next;
        }
        current = headB;
        while (current != null){
            if(visited.contains(current)){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public ListNode getIntersectionNodeOptTP(ListNode headA, ListNode headB){
        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }


    public static void main(String[] args) {
        IntersectionNode intersectionNode = new IntersectionNode();
        ListNode commonTail = new ListNode(5);
        ListNode common4 = new ListNode(4, commonTail);
        ListNode common8 = new ListNode(8, common4);
        ListNode common1 = new ListNode(1, common8);

// List A
        ListNode headA = new ListNode(4, common1);

// List B
        ListNode b6 = new ListNode(6, common1);
        ListNode headB = new ListNode(5, b6);
        System.out.println(intersectionNode.getIntersectionNode(headA, headB));
    }
}
