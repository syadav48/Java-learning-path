Great! Here's a **complete notes + practice set** for learning arrays in Java:

---

## 📝 Java Arrays: Notes

---

### ✅ 1. **Single-Dimensional Array**

* A collection of elements of the same type stored in a contiguous memory location.
* Syntax:

  ```java
  int[] arr = new int[5];
  int[] arr2 = {1, 2, 3, 4};
  ```
* Access using index:

  ```java
  arr[0] = 10;
  System.out.println(arr[0]);
  ```

---

### ✅ 2. **Multidimensional Array**

* Arrays of arrays.
* Most commonly used is **2D array**.
* Syntax:

  ```java
  int[][] matrix = new int[3][4];
  ```
* Example:

  ```java
  for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
          matrix[i][j] = i + j;
      }
  }
  ```

---

### ✅ 3. **Jagged Array**

* An array of arrays **with different lengths** for each row.
* Syntax:

  ```java
  int[][] jagged = new int[3][];
  jagged[0] = new int[2];
  jagged[1] = new int[5];
  jagged[2] = new int[3];
  ```
* Useful when data per row is not uniform.

---

### ✅ 4. **3D Array**

* Array of multidimensional arrays.
* Syntax:

  ```java
  int[][][] arr3D = new int[2][3][4];
  ```
* Example (initialization):

  ```java
  arr3D[0][1][2] = 5;
  ```

---

### ✅ 5. **Enhanced For Loop (For-each Loop)**

* Simplified loop to iterate through arrays or collections.
* Syntax:

  ```java
  for (int num : array) {
      System.out.println(num);
  }
  ```
* For 2D:

  ```java
  for (int[] row : matrix) {
      for (int col : row) {
          System.out.print(col + " ");
      }
      System.out.println();
  }
  ```

---

## 🧠 10 Java Array Practice Questions

1. Write a program to find the **sum and average** of all elements in an array.
2. Write a program to **find the maximum and minimum** element in an array.
3. Write a program to **reverse** the elements of an array.
4. Count how many times a number occurs in an array.
5. Merge two arrays into a third array.
6. Check if an array is **palindrome** (reads the same forward and backward).
7. Create a **2D matrix** and print its transpose.
8. Store marks of students in a **jagged array** (each student has different number of subjects).
9. Initialize a **3D array** with random numbers and print them.
10. Write a program to shift array elements to the right by one position.

---

Let me know if you want solutions to any of these questions or a PDF version of the notes.
