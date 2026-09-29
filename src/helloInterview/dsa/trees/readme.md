🌳 Tree DSA — Interview Pattern Playbook:
TREE
│
├── 1. Binary Tree
│
├── 2. BST
│
├── 3. N-ary Tree
│
├── 4. Heap
│
├── 5. Trie
│
└── 6. Advanced Trees
├── Segment Tree
├── Fenwick Tree
└── AVL / Red-Black Tree

Binary Tree → BST → Heap → Trie → Segment Tree

PreOrder





                        TREE
                           │
          ┌────────────────┼────────────────┐
          │                │                │
         DFS              BFS              BST
          │                │                │
    ┌─────┼─────┐          │          ┌─────┼─────┐
    │     │     │          │          │     │     │
Pre   Inorder Post      Level Order  Search Insert Delete
│     │     │          │
│     │     │          ├── Views
│     │     │          ├── Width
│     │     │          ├── Vertical
│     │     │          └── Min Depth
│     │     │
│     │     └── Bottom-up DP
│     │
│     └── BST sorted
│
└── Serialization


Advanced:
TREE
│
├── DFS + Recursion
│
├── DFS + Backtracking
│
├── DFS + Tree DP
│
├── BFS + Queue
│
├── BFS + Coordinates
│
├── Tree + HashMap
│
├── Tree + Stack
│
├── BST Properties
│
├── Divide & Conquer
│
└── Serialization


| Feature | Binary Tree | Binary Search Tree (BST) |
| --- | --- | --- |
| **Definition** | Each node has ≤ 2 children | Binary Tree with ordering property |
| **Ordering Rule** | None | Left < Node < Right |
| **Insertion** | Anywhere, no constraints | Must follow ordering rule |
| **Search Efficiency** | $O(n)$ (may need full traversal) | $O(\\log n)$ average (halves search space each step) |
| **Deletion** | Simple removal | Must preserve BST property |
| **Duplicates** | Allowed | Usually not allowed or handled specially |
| **Applications** | General hierarchical structures | Databases, dictionaries, fast lookups |4


BST
│
├── Search
├── Insert
├── Delete
├── Validate
├── Min
├── Max
├── Successor
├── Predecessor
├── Kth Smallest
├── Kth Largest
├── LCA
└── Sorted Array → BST


33. BST Successor / Predecessor

For a BST:

Successor

Smallest value greater than current.

Predecessor

Largest value smaller than current.

These are classic BST interview concepts.

successor
↓
next element in inorder

predecessor
↓
previous element in inorder


1. Preorder / Inorder / Postorder
2. Level Order
3. Maximum Depth
4. Same Tree
5. Symmetric Tree
6. Invert Tree
7. Path Sum
8. Diameter
9. Balanced Tree
10. Lowest Common Ancestor
11. Validate BST
12. BST Search / Insert / Delete
13. Kth Smallest BST
14. Construct Tree from Traversals
15. Serialize / Deserialize

16. Right/Left View
17. Vertical Order
18. Top/Bottom View
19. Root-to-leaf paths
20. Maximum Path Sum
21. Flatten Binary Tree
22. Sorted Array → BST
23. BST Successor/Predecessor
24. Distance between nodes
25. Nodes at distance K

26. Tree DP
27. Tree + Backtracking
28. Tree + HashMap
29. Morris Traversal
30. Trie
31. Segment Tree
32. Fenwick Tree
33. AVL / Red-Black Tree

