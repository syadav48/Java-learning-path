LINKED LIST
│
├── 1. Basic traversal
│
├── 2. Pointer manipulation
│      ├── insert
│      └── delete
│
├── 3. Reverse
│      ├── entire list
│      ├── sublist
│      └── K groups
│
├── 4. Fast + Slow
│      ├── middle
│      ├── cycle detection
│      ├── cycle start
│      └── palindrome
│
├── 5. Two pointers
│      └── Nth from end
│
├── 6. Dummy node
│      ├── remove
│      ├── merge
│      └── insertion
│
├── 7. Merge
│      ├── two sorted lists
│      └── merge sort
│
└── 8. Advanced
├── intersection
├── reverse K groups
└── LRU Cache


Pattern 1 — Traversal:

ListNode curr = head;

while (curr != null) {
curr = curr.next;
}

Pattern 2 — Reverse:

ListNode prev = null;
ListNode curr = head;

while (curr != null) {

    ListNode next = curr.next;

    curr.next = prev;

    prev = curr;
    curr = next;
}

return prev;

Pattern 3 — Fast/Slow:

ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}

Pattern 4 — Dummy:

ListNode dummy = new ListNode(0);
dummy.next = head;


Pattern 5 — Two pointers with a gap:

ListNode slow = head;
ListNode fast = head;

for (int i = 0; i < k; i++) {
fast = fast.next;
}

while (fast != null) {
slow = slow.next;
fast = fast.next;
}


1. Traversal
   ↓
2. Insert / Delete
   ↓
3. Reverse Linked List
   ↓
4. Find Middle
   ↓
5. Detect Cycle
   ↓
6. Nth Node From End
   ↓
7. Merge Two Sorted Lists
   ↓
8. Palindrome
   ↓
9. Intersection
   ↓
10. Reverse Sublist
    ↓
11. Reverse K Groups
    ↓
12. Merge Sort
    ↓
13. Doubly Linked List
    ↓
14. LRU Cache