                    Problem
                       │
                     choose
                       ↓
                    recurse
                       ↓
                ┌──────┴──────┐
                │             │
             success        failure
                │             │
             answer          undo
                              │
                              ↓
                       try next choice

void backtrack(...) {

    if (isComplete()) {
        result.add(...);
        return;
    }

    for (each choice) {

        // 1. Choose
        makeChoice();

        // 2. Explore
        backtrack(...);

        // 3. Undo
        undoChoice();
    }
}

path.add(x);

backtrack(...);

path.remove(path.size() - 1);


The Backtracking State:
state =
current position
current path
remaining target
used elements
board state

backtrack(
nums,
start,
path,
result
);

SUBSET
↓
start index


PERMUTATION
↓
used[]

Candidates can only be used once.   
Arrays.sort(candidates);
if (i > start &&
candidates[i] == candidates[i - 1]) {
continue;
}
backtrack(
candidates,
target - candidates[i],
i + 1,
path,
result
);

//Letter Combination:
private void backtrack(
String digits,
int index,
StringBuilder path,
List<String> result) {

    if (index == digits.length()) {
        result.add(path.toString());
        return;
    }

    String letters =
        mapping[digits.charAt(index) - '0'];

    for (char c : letters.toCharArray()) {

        path.append(c);

        backtrack(
            digits,
            index + 1,
            path,
            result
        );

        path.deleteCharAt(path.length() - 1);
    }
}

String Partitioning:
for (int end = start; end < s.length(); end++) {

    if (isPalindrome(start, end)) {

        path.add(s.substring(start, end + 1));

        backtrack(
            s,
            end + 1,
            path,
            result
        );

        path.remove(path.size() - 1);
    }
}

BACKTRACKING
│
├── 1. SUBSETS
│      └── start index
│
├── 2. PERMUTATIONS
│      └── used[]
│
├── 3. COMBINATIONS
│      └── start index
│
├── 4. PARTITIONING
│      └── choose cut position
│
├── 5. GRID / MATRIX
│      └── visited + directions
│
└── 6. CONSTRAINT PLACEMENT
└── N-Queens / Sudoku


The patterns mapped to problems: 

| Pattern                  | Classic problems        |
| ------------------------ | ----------------------- |
| Subsets                  | Subsets                 |
| Subsets + duplicates     | Subsets II              |
| Permutation              | Permutations            |
| Permutation + duplicates | Permutations II         |
| Combination              | Combinations            |
| Combination reuse        | Combination Sum         |
| Combination no reuse     | Combination Sum II      |
| Partition                | Palindrome Partitioning |
| String choices           | Letter Combinations     |
| Grid DFS                 | Word Search             |
| Constraint placement     | N-Queens                |
| Constraint solving       | Sudoku                  |
| Path exploration         | Maze problems           |


subsets?
permutations?
combinations?
arrangements?
partitions?
paths?
boards?



The common idea is:

Make a decision → check constraints → recursively explore → undo if necessary.

The extra ingredient is pruning:

Don't explore a branch once you already know it cannot produce a valid answer.

