Absolutely. **Graphs are one of the biggest DSA topics**, but the good news is that you don't need to memorize 50 unrelated graph problems.

The key is to recognize the **graph pattern**.

For your interview preparation, I would organize Graphs like this:

```text
                         GRAPH
                           │
          ┌────────────────┼────────────────┐
          │                │                │
       Traversal        Shortest Path      Connectivity
          │                │                │
      BFS / DFS       BFS / Dijkstra    DSU / DFS
          │                │                │
      Grid DFS/BFS    0-1 BFS / Bellman   Components
      Islands         Floyd Warshall      Cycle
      Flood Fill      DAG shortest path   Redundant Edge
          │
          │
   ┌──────┴────────┐
   │               │
 Topological      Advanced
   Sort              │
   │              MST
 Kahn / DFS       Prim/Kruskal
   │              Bridges
 Courses          Articulation
 Dependencies     SCC
```

And there is another very important way to classify a graph problem:

```text
Question
   │
   ├── "Can I reach?"
   │       → DFS / BFS
   │
   ├── "How many groups?"
   │       → DFS/BFS / DSU
   │
   ├── "Shortest path?"
   │       → BFS / Dijkstra / 0-1 BFS / Bellman-Ford
   │
   ├── "Ordering/dependency?"
   │       → Topological Sort
   │
   ├── "Connect everything with minimum cost?"
   │       → MST
   │
   ├── "Does a cycle exist?"
   │       → DFS / BFS / DSU / Topological
   │
   └── "Critical connection?"
           → Bridges / Articulation Points
```

Let's build this properly.

---

# 1. First understand what a Graph actually is

A graph is simply:

```text
Vertices + Edges
```

Example:

```text
       A
      / \
     B   C
     |   |
     D---E
```

Vertices:

```text
A B C D E
```

Edges:

```text
A-B
A-C
B-D
C-E
D-E
```

That's it.

Everything else—BFS, DFS, Dijkstra, MST, topological sort—is a **way of asking questions about these relationships**.

---

# 2. Graph Types You MUST recognize

Before choosing an algorithm, identify the graph.

## Undirected

```text
A ----- B
```

Means:

```text
A → B
B → A
```

Example:

```text
friend relationship
```

---

## Directed

```text
A -----> B
```

Means:

```text
A → B
```

but not necessarily:

```text
B → A
```

Examples:

```text
course prerequisite
dependency
follow relationship
```

---

## Weighted

```text
A --5--> B
```

Edge has a cost:

```text
5
```

Examples:

```text
road distance
flight cost
network latency
```

---

## Unweighted

```text
A ---- B
```

Every edge effectively has equal cost.

This distinction becomes **extremely important for shortest path**.

---

## Cyclic

```text
A → B
↑   ↓
└── C
```

There is a cycle.

---

## DAG

Directed Acyclic Graph:

```text
A → B → D
↓   ↓
C → E
```

No directed cycle.

DAGs unlock:

```text
Topological Sort
DAG DP
Shortest path in DAG
```

---

# 3. How do we represent a Graph in Java?

Most interview questions use an adjacency list.

For:

```text
0 -- 1
|    |
2 -- 3
```

we can represent:

```java
List<List<Integer>> graph =
        new ArrayList<>();
```

Then:

```java
graph.get(0) → [1, 2]
graph.get(1) → [0, 3]
graph.get(2) → [0, 3]
graph.get(3) → [1, 2]
```

---

# 4. Build an Undirected Graph

```java
public List<List<Integer>> buildGraph(
        int n,
        int[][] edges) {

    List<List<Integer>> graph =
            new ArrayList<>();

    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {

        int u = edge[0];
        int v = edge[1];

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    return graph;
}
```

Why both?

```java
graph.get(u).add(v);
graph.get(v).add(u);
```

Because the graph is undirected.

---

# 5. Directed Graph

For:

```text
0 → 1
0 → 2
2 → 3
```

only:

```java
graph.get(u).add(v);
```

```java
for (int[] edge : edges) {

    int u = edge[0];
    int v = edge[1];

    graph.get(u).add(v);
}
```

This tiny difference causes a LOT of graph bugs.

---

# 6. The first major Graph pattern

# Pattern 1 — DFS

The most fundamental graph algorithm.

Think:

> "Explore everything reachable from this node."

```java
void dfs(
        int node,
        List<List<Integer>> graph,
        boolean[] visited) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited);
        }
    }
}
```

Mental picture:

```text
        A
       / \
      B   C
     /     \
    D       E
```

Start at A:

```text
A
↓
B
↓
D
↓
backtrack
↓
C
↓
E
```

DFS =

```text
Go deep → hit dead end → backtrack
```

---

# 7. DFS Pattern Problems

DFS appears in:

### Connectivity

> Can I reach B from A?

### Number of components

> How many disconnected groups exist?

### Islands

> How many connected land regions?

### Flood fill

> Change all connected cells.

### Cycle detection

> Is there a cycle?

### Path existence

> Is there a path?

### Backtracking on grids

> Can I form this word?

---

# 8. Grid Problems ARE Graph Problems

This is one of the biggest interview insights.

Consider:

```text
1 1 0
1 0 0
0 0 1
```

You might think:

> "This is a matrix problem."

But conceptually:

```text
Each cell = node
Adjacent cells = edges
```

So:

```text
(0,0)
 /   \
(0,1) (1,0)
```

The same DFS/BFS applies.

---

# 9. Grid DFS Template

```java
void dfs(int[][] grid, int r, int c) {

    if (r < 0 ||
        r >= grid.length ||
        c < 0 ||
        c >= grid[0].length ||
        grid[r][c] == 0) {

        return;
    }

    grid[r][c] = 0;

    dfs(grid, r + 1, c);
    dfs(grid, r - 1, c);
    dfs(grid, r, c + 1);
    dfs(grid, r, c - 1);
}
```

The four directions:

```text
       up
       ↑
left ← cell → right
       ↓
      down
```

---

# 10. Pattern 2 — Number of Connected Components

Suppose:

```text
0 -- 1

2 -- 3

4
```

There are:

```text
3 components
```

Algorithm:

```java
int count = 0;

for (int i = 0; i < n; i++) {

    if (!visited[i]) {

        dfs(i);

        count++;
    }
}
```

Important mental model:

> **Every time you discover an unvisited node, you found a new component.**

Classic problems:

* Number of Provinces
* Number of Connected Components
* Friend Circles
* Connected components in undirected graph

---

# 11. Pattern 3 — Flood Fill

Example:

```text
1 1 1
1 1 0
1 0 1
```

Start:

```text
(1,1)
```

Change connected `1`s to `2`.

This is simply:

```text
DFS/BFS + boundary checking
```

Problem:

**Flood Fill**

---

# 12. Pattern 4 — Number of Islands

This is one of the most important graph interview problems.

```text
1 1 0
1 0 0
0 0 1
```

Treat:

```text
1 = node
```

Adjacent 1s:

```text
edge
```

Then:

```text
DFS each unvisited island
```

Algorithm:

```java
int islands = 0;

for (int r = 0; r < rows; r++) {

    for (int c = 0; c < cols; c++) {

        if (grid[r][c] == '1') {

            islands++;

            dfs(grid, r, c);
        }
    }
}
```

This single pattern solves a huge family of matrix questions.

---

# 13. DFS vs BFS

Both explore connected regions.

But the mental models differ.

### DFS

```text
Explore deeply
```

Useful for:

```text
components
cycle detection
backtracking
islands
path existence
```

### BFS

```text
Explore level by level
```

Useful when you care about:

```text
shortest number of edges
minimum steps
distance
levels
```

That distinction is crucial.

---

# 14. Pattern 5 — BFS Shortest Path

Suppose:

```text
A -- B -- C
     |
     D
```

Every edge has equal cost.

Question:

> Minimum number of edges from A to D?

BFS.

Why?

```text
Level 0:
A

Level 1:
B

Level 2:
C D
```

The first time we reach D:

```text
distance = 2
```

---

# 15. BFS Template

```java
Queue<Integer> queue = new LinkedList<>();

boolean[] visited = new boolean[n];

queue.offer(source);
visited[source] = true;

while (!queue.isEmpty()) {

    int node = queue.poll();

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {

            visited[neighbor] = true;

            queue.offer(neighbor);
        }
    }
}
```

---

# 16. BFS + Distance

```java
int[] distance = new int[n];

Arrays.fill(distance, -1);

Queue<Integer> queue = new LinkedList<>();

queue.offer(source);
distance[source] = 0;

while (!queue.isEmpty()) {

    int node = queue.poll();

    for (int neighbor : graph.get(node)) {

        if (distance[neighbor] == -1) {

            distance[neighbor] =
                    distance[node] + 1;

            queue.offer(neighbor);
        }
    }
}
```

Now:

```text
distance[x]
```

means:

> minimum number of edges from source to x.

---

# 17. Pattern 6 — Multi-Source BFS

This is an extremely important pattern.

Suppose:

```text
1 0 0
0 0 0
0 0 1
```

Two sources exist.

Instead of BFS from each source separately:

```text
source A → BFS
source B → BFS
```

put **both sources into the queue initially**.

```text
Queue:

A
B
```

Then BFS expands simultaneously.

This answers:

> distance to the nearest source.

Used in:

* Rotting Oranges
* 01 Matrix
* Walls and Gates
* Fire spread
* Infection spread
* Nearest facility problems

---

# 18. Multi-source BFS mental model

Imagine fire starts here:

```text
🔥 . . .
. . . .
. . 🔥
```

Both fires expand simultaneously:

```text
🔥 → → 
↓
```

The BFS wavefront represents time.

That's why Multi-source BFS is so powerful for:

> **minimum time for something to spread/reach everywhere.**

---

# 19. Pattern 7 — Cycle Detection

Cycle detection depends on graph type.

This is where many candidates make mistakes.

---

# Undirected Graph Cycle

Suppose:

```text
A ----- B
 \     /
   \ /
    C
```

There is a cycle.

During DFS, if you see a visited node, that alone isn't enough.

Why?

Because:

```text
A -- B
```

When DFS goes:

```text
A → B
```

B sees A as already visited.

But that's not a cycle.

A is simply the **parent**.

So you need:

```text
current node
+
parent
```

Template:

```java
boolean dfs(
        int node,
        int parent,
        List<List<Integer>> graph,
        boolean[] visited) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {

            if (dfs(
                    neighbor,
                    node,
                    graph,
                    visited)) {

                return true;
            }

        } else if (neighbor != parent) {

            return true;
        }
    }

    return false;
}
```

Key rule:

```text
visited neighbor
+
neighbor != parent
=
cycle
```

---

# 20. Directed Graph Cycle Detection

This is different.

You can't use the undirected parent rule.

Use:

```text
visited
+
current recursion path
```

Three states are useful:

```text
0 = unvisited
1 = currently visiting
2 = completely processed
```

DFS:

```java
boolean dfs(
        int node,
        List<List<Integer>> graph,
        int[] state) {

    state[node] = 1;

    for (int neighbor : graph.get(node)) {

        if (state[neighbor] == 1) {
            return true;
        }

        if (state[neighbor] == 0 &&
            dfs(neighbor, graph, state)) {

            return true;
        }
    }

    state[node] = 2;

    return false;
}
```

The key idea:

```text
edge → node currently in recursion stack
        ↓
      cycle
```

---

# 21. Why directed cycle detection matters

Consider:

```text
Course A → Course B
Course B → Course C
Course C → Course A
```

You cannot finish the courses because dependencies loop.

This leads directly to:

# Topological Sort.

---

# 22. Pattern 8 — Topological Sort

Topological ordering means:

> Put nodes in an order such that every prerequisite comes before the dependent node.

Example:

```text
A → C
B → C
C → D
```

Valid order:

```text
A B C D
```

or:

```text
B A C D
```

But:

```text
C A B D
```

is invalid.

---

# 23. Topological Sort = DAG

Topological sorting only works if:

```text
Directed
+
Acyclic
```

Therefore:

```text
DAG
```

means:

```text
Directed Acyclic Graph
```

---

# 24. Topological Pattern A — Kahn's Algorithm

This uses:

```text
BFS + indegree
```

Calculate:

```text
indegree[node]
```

Example:

```text
A → C
B → C
C → D
```

Indegree:

```text
A = 0
B = 0
C = 2
D = 1
```

Start with nodes having:

```text
indegree = 0
```

Queue:

```text
A
B
```

Process A:

```text
C: 2 → 1
```

Process B:

```text
C: 1 → 0
```

Now:

```text
C
```

enters queue.

Then C:

```text
D: 1 → 0
```

Then D.

---

# 25. Kahn Template

```java
Queue<Integer> queue = new LinkedList<>();

for (int i = 0; i < n; i++) {

    if (indegree[i] == 0) {
        queue.offer(i);
    }
}

int count = 0;

while (!queue.isEmpty()) {

    int node = queue.poll();

    count++;

    for (int neighbor : graph.get(node)) {

        indegree[neighbor]--;

        if (indegree[neighbor] == 0) {
            queue.offer(neighbor);
        }
    }
}
```

If:

```text
count == n
```

no cycle.

If:

```text
count < n
```

cycle exists.

---

# 26. Topological Problems

This pattern is critical.

### Course Schedule

```text
Can I finish all courses?
```

→ Topological sort / cycle detection.

### Course Schedule II

```text
Give me valid course order.
```

→ Topological sort.

### Alien Dictionary

```text
Infer character ordering.
```

→ Build directed graph + Topological Sort.

### Build System Dependencies

```text
A depends on B
```

→ Topological Sort.

---

# 27. Pattern 9 — DFS Topological Sort

Alternative to Kahn.

DFS:

```text
visit dependencies
then add current node
```

So:

```java
void dfs(int node) {

    visited[node] = true;

    for (int next : graph.get(node)) {

        if (!visited[next]) {
            dfs(next);
        }
    }

    result.add(node);
}
```

Then:

```java
Collections.reverse(result);
```

But cycle detection must be handled using the three-state approach.

For interviews, I recommend knowing **Kahn's algorithm extremely well**, because it makes dependency problems visually obvious.

---

# 28. Pattern 10 — Union Find / DSU

This is another major graph pattern.

DSU =

```text
Disjoint Set Union
```

It answers:

> Are these two nodes already connected?

Imagine:

```text
1   2   3   4
```

Initially:

```text
{1} {2} {3} {4}
```

Connect:

```text
1-2
```

Now:

```text
{1,2} {3} {4}
```

Connect:

```text
2-3
```

Now:

```text
{1,2,3} {4}
```

---

# 29. DSU operations

Two important operations:

```text
find(x)
union(a,b)
```

`find(x)`:

> Which group does x belong to?

`union(a,b)`:

> Merge their groups.

With:

```text
Path Compression
+
Union by Rank/Size
```

operations are effectively:

```text
O(α(n))
```

which is practically constant.

---

# 30. DSU Template

```java
class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];

        return true;
    }
}
```

---

# 31. When should DSU trigger in your mind?

When you see:

```text
connect
merge
groups
components
already connected?
```

especially when edges are being added dynamically.

Classic problems:

* Number of Provinces
* Redundant Connection
* Accounts Merge
* Graph Valid Tree
* Number of Connected Components
* Kruskal's MST

---

# 32. DSU vs DFS

This is a common interview question.

### DFS/BFS

Best when:

> I want to explore the graph.

### DSU

Best when:

> I want to maintain connectivity as edges are added.

Think:

```text
DFS
→ Explore

DSU
→ Merge
```

---

# 33. Pattern 11 — Shortest Path

This is a HUGE category.

First ask:

```text
What kind of edge weights do I have?
```

That determines the algorithm.

---

# Case 1: Unweighted Graph

```text
A -- B -- C
```

Use:

```text
BFS
```

Complexity:

```text
O(V + E)
```

---

# Case 2: Weight = 0 or 1

```text
A --0-- B
A --1-- C
```

Use:

```text
0-1 BFS
```

with:

```text
Deque
```

Rule:

```text
weight 0 → addFirst()

weight 1 → addLast()
```

This is a beautiful connection between your Queue/Deque topic and Graphs.

---

# Case 3: Non-negative weights

```text
A --5-- B
A --2-- C
```

Use:

# Dijkstra

Usually implemented with:

```text
Min Heap
```

Store:

```text
(distance, node)
```

---

# 34. Dijkstra Mental Model

Suppose:

```text
A --4-- B
|       |
1       2
|       |
C --3-- D
```

Start:

```text
distance[A] = 0
```

Heap:

```text
(0,A)
```

Take smallest:

```text
A
```

Relax:

```text
B = 4
C = 1
```

Heap:

```text
(1,C)
(4,B)
```

Take C.

Maybe C gives D:

```text
D = 4
```

Continue.

The key operation is:

# Relaxation

```java
if (dist[node] + weight < dist[neighbor]) {

    dist[neighbor] =
        dist[node] + weight;

    pq.offer(
        new int[]{
            dist[neighbor],
            neighbor
        }
    );
}
```

---

# 35. Critical Dijkstra mistake

Dijkstra does **NOT** work correctly with negative edge weights.

If:

```text
weight < 0
```

you need another approach, depending on the problem.

Usually:

```text
Bellman-Ford
```

or specialized techniques.

---

# 36. Case 4 — Negative Weights

Use:

# Bellman-Ford

It repeatedly relaxes all edges.

For:

```text
V vertices
```

perform:

```text
V - 1
```

relaxation rounds.

Complexity:

```text
O(VE)
```

Its important advantage:

> Can handle negative edge weights.

It can also detect negative cycles.

---

# 37. Case 5 — All-pairs shortest path

Question:

> Shortest distance between every pair of vertices?

Think:

# Floyd-Warshall

Dynamic programming approach.

```text
dist[i][j]
```

Try every intermediate node `k`:

```text
dist[i][j] =
    min(
        dist[i][j],
        dist[i][k] + dist[k][j]
    );
```

Complexity:

```text
O(V³)
```

Useful when:

```text
V is relatively small
```

and you need:

```text
all → all
```

---

# 38. Shortest Path Decision Tree

This is worth memorizing:

```text
                    SHORTEST PATH
                          │
             ┌────────────┴────────────┐
             │                         │
       Unweighted                  Weighted
             │                         │
            BFS                 ┌──────┴──────┐
                                │             │
                           Non-negative     Negative
                                │             │
                           Dijkstra      Bellman-Ford
                                │
                           weight 0/1?
                                │
                              0-1 BFS
```

And:

```text
All pairs?
    ↓
Floyd-Warshall
```

---

# 39. Pattern 12 — Minimum Spanning Tree

Now a different problem.

Not shortest path.

Suppose:

```text
A --4-- B
| \     |
2  5    1
|    \  |
C --3-- D
```

We want:

> Connect all vertices with minimum total edge cost.

This is:

# Minimum Spanning Tree

Two major algorithms:

```text
Kruskal
Prim
```

---

# 40. Kruskal

Sort edges by weight:

```text
1
2
3
4
5
```

Then:

> Keep adding the smallest edge that does NOT create a cycle.

This screams:

```text
DSU
```

Algorithm:

```text
sort edges
+
DSU
```

Mental model:

```text
Smallest edge
     ↓
Would it create cycle?
     ↓
NO → take it
YES → skip
```

---

# 41. Prim

Prim grows the MST from a starting node.

At every step:

> Choose the cheapest edge connecting the current tree to a new node.

This uses:

```text
Min Heap
```

So:

```text
Kruskal
→ Sort + DSU

Prim
→ Min Heap + Graph
```

This is another important connection between your Heap and Graph preparation.

---

# 42. Pattern 13 — Bipartite Graph

A graph is bipartite if we can divide nodes into two groups such that:

```text
No edge connects nodes within the same group.
```

Think coloring:

```text
Group 0     Group 1

A -------- B
|          |
D -------- C
```

Color:

```text
A = 0
B = 1
C = 0
D = 1
```

Use:

```text
BFS/DFS
+
2-coloring
```

---

# 43. Bipartite Template

```java
int[] color = new int[n];

Arrays.fill(color, -1);

for (int i = 0; i < n; i++) {

    if (color[i] != -1) {
        continue;
    }

    Queue<Integer> queue = new LinkedList<>();

    queue.offer(i);
    color[i] = 0;

    while (!queue.isEmpty()) {

        int node = queue.poll();

        for (int neighbor : graph.get(node)) {

            if (color[neighbor] == -1) {

                color[neighbor] =
                        1 - color[node];

                queue.offer(neighbor);

            } else if (
                color[neighbor] == color[node]
            ) {

                return false;
            }
        }
    }
}

return true;
```

Classic problem:

**Is Graph Bipartite?**

---

# 44. Pattern 14 — Backtracking + Graph

You already learned backtracking.

Graphs can also become a search space.

Example:

```text
Word Ladder
```

You transform:

```text
hit
→ hot
→ dot
→ dog
→ cog
```

Each word is a node.

A valid transformation is an edge.

Then:

```text
Word transformation
→ Graph
→ BFS
```

This is an important interview trick:

> Sometimes the graph isn't explicitly given. **You have to construct the graph mentally.**

---

# 45. Word Ladder

Suppose:

```text
hit
hot
dot
dog
lot
log
cog
```

Edges exist when two words differ by one character.

Then:

```text
hit → hot → dot → dog → cog
```

Question:

> Minimum transformations?

BFS.

Why?

Every transformation has equal cost.

---

# 46. Pattern 15 — Implicit Graph

This is a major FAANG pattern.

The graph may not look like:

```text
edges = [[0,1], [1,2]]
```

Instead:

```text
State = node
Legal move = edge
```

Examples:

### Word Ladder

```text
word = node
one-letter transformation = edge
```

### Sliding Puzzle

```text
board state = node
valid move = edge
```

### Knight Moves

```text
position = node
knight move = edge
```

### Lock combinations

```text
combination = node
turning wheel = edge
```

Then ask:

> What algorithm would I use if these were ordinary graph nodes?

Often:

```text
BFS
```

---

# 47. Pattern 16 — Graph + Backtracking

Sometimes you need:

> Find all possible paths.

Example:

```text
A → B → D
 \    \
  → C → D
```

Find all paths:

```text
A-B-D
A-C-D
```

DFS + backtracking:

```java
path.add(node);

for (int next : graph.get(node)) {
    dfs(next);
}

path.remove(path.size() - 1);
```

This is:

```text
Graph DFS
+
Backtracking
```

---

# 48. Important Graph Mistake #1

Using:

```java
visited[node] = true;
```

at the wrong time.

For normal BFS, mark visited when **enqueuing**, not when dequeuing.

Correct:

```java
if (!visited[next]) {

    visited[next] = true;

    queue.offer(next);
}
```

Otherwise the same node may enter the queue multiple times.

---

# 49. Important Graph Mistake #2

Forgetting disconnected components.

Suppose:

```text
0 -- 1

2 -- 3

4
```

If you do:

```java
dfs(0);
```

you only visit:

```text
0,1
```

You don't visit:

```text
2,3,4
```

For whole graph problems:

```java
for (int i = 0; i < n; i++) {

    if (!visited[i]) {
        dfs(i);
    }
}
```

---

# 50. Important Graph Mistake #3

Confusing directed and undirected edges.

Undirected:

```java
graph.get(u).add(v);
graph.get(v).add(u);
```

Directed:

```java
graph.get(u).add(v);
```

This affects:

```text
DFS
cycle detection
indegree
topological sort
```

---

# 51. Important Graph Mistake #4

Using DFS for shortest path in an unweighted graph.

DFS can find:

```text
a path
```

but not necessarily:

```text
the shortest path
```

For equal-weight edges:

```text
BFS
```

---

# 52. Important Graph Mistake #5

Using Dijkstra with negative edges.

Remember:

```text
Dijkstra
→ non-negative weights
```

Negative weights:

```text
Bellman-Ford
```

---

# 53. Important Graph Mistake #6

Not distinguishing cycle types.

```text
Undirected:
visited + parent

Directed:
visited + recursion state
```

Don't mix these templates.

---

# 54. Important Graph Mistake #7

Using DSU for everything.

DSU is excellent for:

```text
connectivity
merging components
dynamic edge addition
cycle detection in undirected graph
Kruskal
```

But it doesn't naturally answer:

```text
shortest path
path reconstruction
ordering
distance
```

Use the appropriate algorithm.

---

# 55. Important Graph Mistake #8

Not considering graph size.

For:

```text
V = 10
```

Floyd-Warshall:

```text
O(V³)
```

may be completely fine.

For:

```text
V = 100,000
```

it isn't.

You need to think about:

```text
V = vertices
E = edges
```

Most graph algorithms are expressed in terms of:

```text
O(V + E)
```

---

# 56. Graph Complexity Cheat Sheet

| Pattern               | Algorithm      |     Complexity |
| --------------------- | -------------- | -------------: |
| DFS                   | DFS            |         O(V+E) |
| BFS                   | BFS            |         O(V+E) |
| Components            | DFS/BFS        |         O(V+E) |
| Bipartite             | BFS/DFS        |         O(V+E) |
| Cycle                 | DFS/BFS        |         O(V+E) |
| Topological           | Kahn           |         O(V+E) |
| Topological           | DFS            |         O(V+E) |
| DSU                   | Union/Find     |          ~O(1) |
| Unweighted shortest   | BFS            |         O(V+E) |
| 0/1 shortest          | 0-1 BFS        |         O(V+E) |
| Non-negative shortest | Dijkstra       | O((V+E) log V) |
| Negative weights      | Bellman-Ford   |          O(VE) |
| All-pairs             | Floyd-Warshall |          O(V³) |
| MST                   | Kruskal        |     O(E log E) |
| MST                   | Prim + heap    |     O(E log V) |

---

# 57. The Graph Decision Flowchart

This is the part I want you to remember most.

```text
                     GRAPH PROBLEM
                           │
                           ▼
                Is the graph explicit?
                     /          \
                   NO            YES
                   │              │
             Construct          Continue
              states
                   │
                   ▼
               BFS / DFS
```

Then:

```text
What are they asking?
        │
        ├── Reachability?
        │      ↓
        │    DFS/BFS
        │
        ├── Connected components?
        │      ↓
        │    DFS/BFS/DSU
        │
        ├── Grid?
        │      ↓
        │    DFS/BFS
        │
        ├── Shortest path?
        │      ↓
        │   ┌───────────────┐
        │   │               │
        │ unweighted     weighted
        │   │               │
        │  BFS        ┌─────┴─────┐
        │             │           │
        │          non-negative  negative
        │             │           │
        │         Dijkstra    Bellman-Ford
        │
        ├── Weight 0/1?
        │      ↓
        │    0-1 BFS
        │
        ├── Dependency/order?
        │      ↓
        │  Topological Sort
        │
        ├── Two groups?
        │      ↓
        │  Bipartite
        │
        ├── Dynamic connectivity?
        │      ↓
        │     DSU
        │
        ├── Connect all nodes cheaply?
        │      ↓
        │     MST
        │
        └── Critical edges/nodes?
               ↓
         Bridges / Articulation
```

---

# 58. The Graph Pattern Map

Here's the full interview map I would keep in your DSA notes:

```text
GRAPH
│
├── A. REPRESENTATION
│   ├── Adjacency List
│   ├── Adjacency Matrix
│   └── Edge List
│
├── B. TRAVERSAL
│   ├── DFS
│   ├── BFS
│   ├── Grid DFS
│   ├── Grid BFS
│   └── Multi-source BFS
│
├── C. CONNECTIVITY
│   ├── Components
│   ├── Provinces
│   ├── Flood Fill
│   ├── Number of Islands
│   └── DSU
│
├── D. CYCLE
│   ├── Undirected DFS
│   ├── Undirected BFS
│   ├── DSU
│   └── Directed DFS
│
├── E. TOPOLOGICAL
│   ├── Kahn
│   ├── DFS
│   ├── Course Schedule
│   └── Alien Dictionary
│
├── F. SHORTEST PATH
│   ├── BFS
│   ├── Multi-source BFS
│   ├── 0-1 BFS
│   ├── Dijkstra
│   ├── Bellman-Ford
│   └── Floyd-Warshall
│
├── G. MST
│   ├── Kruskal + DSU
│   └── Prim + Heap
│
├── H. SPECIAL STRUCTURE
│   ├── Bipartite
│   ├── DAG
│   ├── Implicit Graph
│   └── State Graph
│
└── I. ADVANCED
    ├── Bridges
    ├── Articulation Points
    ├── SCC
    └── Eulerian Path/Circuit
```

---

# 59. Problems mapped to patterns

Instead of memorizing solutions, map the problem to the pattern:

| Problem type                | Pattern                             |
| --------------------------- | ----------------------------------- |
| Number of Islands           | Grid DFS/BFS                        |
| Flood Fill                  | DFS/BFS                             |
| Rotting Oranges             | Multi-source BFS                    |
| Clone Graph                 | DFS/BFS + HashMap                   |
| Number of Provinces         | DFS/BFS/DSU                         |
| Graph Valid Tree            | DFS/DSU                             |
| Redundant Connection        | DSU                                 |
| Course Schedule             | Topological Sort                    |
| Course Schedule II          | Topological Sort                    |
| Alien Dictionary            | Topological Sort                    |
| Is Graph Bipartite          | BFS/DFS coloring                    |
| Word Ladder                 | Implicit graph + BFS                |
| Open the Lock               | State graph + BFS                   |
| Shortest Path Binary Matrix | BFS                                 |
| Network Delay Time          | Dijkstra                            |
| Cheapest Flights            | Shortest path variants              |
| Path With Minimum Effort    | Dijkstra / binary-search variants   |
| Min Cost to Connect Points  | MST                                 |
| Connecting Cities           | MST                                 |
| Accounts Merge              | DSU                                 |
| Swim in Rising Water        | Graph + Dijkstra / other approaches |
| Reconstruct Itinerary       | Eulerian path                       |
| Critical Connections        | Bridges                             |
| Number of Good Paths        | Advanced DSU                        |
| Evaluate Division           | DFS graph                           |

---

# 60. The 80/20 Graph Preparation

You don't need to master every advanced algorithm immediately.

For **product-company / FAANG interviews**, I'd structure your learning:

### Tier 1 — Absolutely master

```text
DFS
BFS
Grid DFS/BFS
Multi-source BFS
Connected Components
Cycle Detection
Topological Sort
Bipartite
```

### Tier 2 — Very important

```text
DSU
Dijkstra
MST
0-1 BFS
Implicit Graph / State Graph
```

### Tier 3 — Important

```text
Bellman-Ford
Floyd-Warshall
Bridges
Articulation Points
Eulerian Path
SCC
```

---

# 61. One final mental model

You've now learned:

```text
ARRAY
  ↓
Two Pointer / Sliding Window / Prefix

LINKED LIST
  ↓
Fast-Slow / Reverse / Dummy

TREE
  ↓
DFS / BFS / Tree DP

BACKTRACKING
  ↓
Choose → Explore → Undo

HEAP
  ↓
Best current candidate

QUEUE
  ↓
FIFO / BFS

DEQUE
  ↓
Window + monotonicity
```

And now:

```text
GRAPH
  ↓
What relationship exists between states?
  ↓
How do I traverse those states?
  ↓
What am I optimizing?
```

Then:

```text
Reach?
    → DFS/BFS

Shortest?
    → BFS/Dijkstra/etc.

Connected?
    → DFS/BFS/DSU

Dependency?
    → Topological Sort

Minimum connection cost?
    → MST

Two groups?
    → Bipartite

Repeatedly choose minimum?
    → Heap + Graph

Critical connection?
    → Bridges
```

**That is the graph mindset.**

The biggest jump for you now is not learning more algorithms; it's learning to look at an unfamiliar problem and convert it into:

```text
STATE
  ↓
NODE

VALID TRANSITION
  ↓
EDGE

QUESTION
  ↓
GRAPH ALGORITHM
```

For example:

```text
Word Ladder

word
 ↓
NODE

one-character transformation
 ↓
EDGE

minimum transformations
 ↓
BFS
```

or:

```text
Course Schedule

course
 ↓
NODE

prerequisite relationship
 ↓
DIRECTED EDGE

valid ordering
 ↓
TOPOLOGICAL SORT
```

or:

```text
Network routing

city/server
 ↓
NODE

connection
 ↓
WEIGHTED EDGE

minimum cost
 ↓
DIJKSTRA
```

That **state → edge → question → algorithm** transformation is probably the single most valuable graph skill for interviews.
