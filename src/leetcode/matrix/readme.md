Excellent — this is the **right approach** 👏
Let’s build a **“Matrix Problem Notesheet for Java (LeetCode-focused)”**, containing all the **core methods, concepts, and key patterns** you’ll need — **not the answers**, but **the tools**.

---

## 🧩 MATRIX PROBLEM NOTESHEET (for Java / LeetCode)

---

### 🔹 1. Basic Matrix Declaration & Traversal

```java
int[][] matrix = new int[rows][cols];
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

**Traversal patterns:**

```java
for (int i = 0; i < matrix.length; i++) { // rows
    for (int j = 0; j < matrix[0].length; j++) { // columns
        System.out.print(matrix[i][j] + " ");
    }
}
```

🔸 **Key methods/properties:**

* `matrix.length` → number of rows
* `matrix[0].length` → number of columns

---

### 🔹 2. Row-wise & Column-wise Operations

| Operation       | Code                                                                 | Notes                                            |
| --------------- | -------------------------------------------------------------------- | ------------------------------------------------ |
| Sum of a Row    | `int sum = Arrays.stream(matrix[i]).sum();`                          | Quick way using streams                          |
| Sum of a Column | `int sum = 0; for(int i=0;i<matrix.length;i++) sum += matrix[i][j];` | Manual loop                                      |
| Reverse Row     | `Collections.reverse(Arrays.asList(matrix[i]));`                     | Works only if using `Integer[][]`, not `int[][]` |
| Sort Row        | `Arrays.sort(matrix[i]);`                                            | Sorts row elements                               |
| Sort Column     | Extract column into array → sort → put back                          | Common in matrix sorting                         |

---

### 🔹 3. Common Matrix Utility Methods

```java
Arrays.deepToString(matrix); // print full 2D array
```

Example:

```java
System.out.println(Arrays.deepToString(matrix));
```

Output:

```
[[1, 2, 3], [4, 5, 6]]
```

---

### 🔹 4. Directions (for BFS / DFS problems)

Often used in problems like “island count”, “matrix traversal”, “flood fill”, etc.

```java
int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // 4-directional
int[][] dirs8 = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}}; // 8-directional
```

Usage:

```java
for (int[] dir : dirs) {
    int newR = r + dir[0];
    int newC = c + dir[1];
    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
        // process
    }
}
```

---

### 🔹 5. Matrix Rotations & Transformations

| Operation             | Concept                                         | Key Point                                     |
| --------------------- | ----------------------------------------------- | --------------------------------------------- |
| **Transpose**         | Swap row/column → `matrix[i][j] ↔ matrix[j][i]` | Only for square matrix                        |
| **Rotate 90°**        | Transpose + reverse each row                    | Classic LeetCode question                     |
| **Flip vertically**   | Reverse row order                               | `Collections.reverse(Arrays.asList(matrix));` |
| **Flip horizontally** | Reverse each row                                | `for each row → reverse()`                    |

Example (Transpose):

```java
for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
```

---

### 🔹 6. Searching in Matrix

| Type            | Concept               | Pattern                                  |
| --------------- | --------------------- | ---------------------------------------- |
| Sorted row-wise | Binary Search per row | `Arrays.binarySearch(matrix[i], target)` |
| Sorted row+col  | Start from top-right  | `O(m+n)`                                 |
| Unspecific      | Nested loops          | `O(m*n)`                                 |

---

### 🔹 7. DFS / BFS Template for Matrix

**DFS (Recursive):**

```java
void dfs(int[][] grid, int r, int c, boolean[][] visited) {
    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c]) return;
    visited[r][c] = true;
    for (int[] dir : dirs)
        dfs(grid, r + dir[0], c + dir[1], visited);
}
```

**BFS (Queue-based):**

```java
Queue<int[]> q = new LinkedList<>();
q.offer(new int[]{r, c});
visited[r][c] = true;
while(!q.isEmpty()){
    int[] cell = q.poll();
    for(int[] dir : dirs){
        int nr = cell[0] + dir[0];
        int nc = cell[1] + dir[1];
        if(isValid(nr, nc, grid, visited)){
            q.offer(new int[]{nr, nc});
            visited[nr][nc] = true;
        }
    }
}
```

---

### 🔹 8. Validity Check Helper (Always Useful)

```java
boolean isValid(int r, int c, int[][] grid) {
    return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
}
```

---

### 🔹 9. Prefix Sum / Dynamic Programming on Matrix

Used in range sum queries, max path, etc.

**2D Prefix Sum:**

```java
int[][] prefix = new int[m+1][n+1];
for (int i = 1; i <= m; i++) {
    for (int j = 1; j <= n; j++) {
        prefix[i][j] = matrix[i-1][j-1]
                       + prefix[i-1][j]
                       + prefix[i][j-1]
                       - prefix[i-1][j-1];
    }
}
```

Then range sum `(r1,c1) → (r2,c2)`:

```java
int sum = prefix[r2+1][c2+1] - prefix[r1][c2+1] - prefix[r2+1][c1] + prefix[r1][c1];
```

---

### 🔹 10. Common Patterns on LeetCode

| Category   | Concept                      | Example Problem                      |
| ---------- | ---------------------------- | ------------------------------------ |
| Traversal  | Spiral order, diagonal order | “Spiral Matrix”, “Diagonal Traverse” |
| Path       | BFS/DFS, Dijkstra            | “Shortest Path in Binary Matrix”     |
| DP         | Submatrix sums, max square   | “Maximal Square”, “Minimum Path Sum” |
| Simulation | Rotating, spreading          | “Game of Life”, “Flood Fill”         |
| Search     | Matrix Binary Search         | “Search a 2D Matrix”                 |
| Counting   | Islands, regions             | “Number of Islands”                  |

---

### 🔹 11. Java Tricks for Clean Code

✅ **Cloning array**

```java
int[][] copy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
```

✅ **Convert List<List<Integer>> → int[][]**

```java
int[][] arr = list.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
```

✅ **Stream flatten**

```java
int sum = Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
```

---

### 🧠 Bonus — Problem Solving Tips

1. **Think in directions** — almost every matrix question is about movement (4 or 8 directions).
2. **Boundaries are everything** — always check `i >= 0 && i < rows`.
3. **Mark visited** — either use `visited[][]` or modify the grid temporarily.
4. **Use small helper methods** — for cleaner recursion/BFS.
5. **Dry run on a 3x3 grid** — small grids reveal patterns.
6. **In dynamic programming**, focus on **dependencies (top, left, diagonal)**.

---

Would you like me to turn this into a **printable cheat sheet (PDF)** or a **markdown note file** (so you can open it in VS Code or Obsidian)?
