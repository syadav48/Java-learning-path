Alright — let’s make a **complete, clear, and compact note on Lambda Expressions in Java** using your example plus more practical cases.

---

## **Lambda Expression in Java**

### **Definition**

A **lambda expression** is a short block of code which takes in parameters and returns a value. It is used primarily to implement functional interfaces (interfaces with only one abstract method) in a cleaner, more concise way than anonymous classes.

**Syntax:**

```java
(parameters) -> expression
(parameters) -> { statements; }
```

---

### **Key Points**

* Introduced in **Java 8**.
* Can only be used with **functional interfaces** (marked with `@FunctionalInterface`).
* Eliminates boilerplate code of **anonymous inner classes**.
* Improves readability, especially in APIs like **Streams** and **Collections**.

---

### **Functional Interface**

A functional interface has **exactly one abstract method** (can have multiple default or static methods).

```java
@FunctionalInterface
interface A {
    int add(int a, int b);
}
```

---

### **Examples**

#### 1. Your Example (Two Parameters)

```java
@FunctionalInterface
interface A {
    int add(int a, int b);
}

public class LamdaInf {
    public static void main(String[] args) {
        A obj = (i, j) -> i + j;
        int res = obj.add(5, 6);
        System.out.println(res); // 11
    }
}
```

---

#### 2. Single Parameter Example

```java
@FunctionalInterface
interface Printer {
    void print(String msg);
}

public class SingleParamLambda {
    public static void main(String[] args) {
        Printer p = msg -> System.out.println("Message: " + msg);
        p.print("Hello Lambda!");
    }
}
```

---

#### 3. No Parameter Example

```java
@FunctionalInterface
interface Greeter {
    void greet();
}

public class NoParamLambda {
    public static void main(String[] args) {
        Greeter g = () -> System.out.println("Hello World");
        g.greet();
    }
}
```

---

#### 4. Multi-line Lambda with Return

```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class MultiLineLambda {
    public static void main(String[] args) {
        MathOperation multiply = (a, b) -> {
            System.out.println("Multiplying...");
            return a * b;
        };
        System.out.println(multiply.operate(3, 4)); // 12
    }
}
```

---

#### 5. Lambda with Java Collections

```java
import java.util.*;

public class CollectionLambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        // ForEach with Lambda
        names.forEach(name -> System.out.println("Name: " + name));

        // Sorting with Lambda
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names);
    }
}
```

---

### **When to Use Lambdas**

| **Scenario**                            | **Why Lambda Helps**              |
| --------------------------------------- | --------------------------------- |
| Implementing short, single-method logic | Removes verbose anonymous classes |
| Iterating over collections (forEach)    | Cleaner, functional style         |
| Filtering, mapping with Streams         | Easy inline logic                 |
| Passing behavior as a parameter         | Functional programming style      |

---

### **Lambda vs Anonymous Class**

| Feature              | Lambda Expression                     | Anonymous Class                    |
| -------------------- | ------------------------------------- | ---------------------------------- |
| Syntax               | Short, clean                          | Verbose                            |
| Functional Interface | Required                              | Not necessarily                    |
| `this` reference     | Refers to **enclosing class**         | Refers to anonymous class instance |
| Multiple methods     | ❌ Not possible (only single abstract) | ✅ Possible                         |

---

### **Limitations**

* Can only be used with **functional interfaces**.
* Cannot define multiple abstract methods.
* Less explicit if logic is long — may harm readability.

---

### **Bonus – Lambda with Streams**

```java
import java.util.*;

public class StreamLambda {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        nums.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .forEach(System.out::println);
    }
}
```

*Output:*

```
4
16
```

---

If you want, I can also make a **Lambda Expression Mind Map** showing syntax, examples, advantages, and limitations all in one page so you can **revise in under 2 minutes**. That would make your Java notes more exam-ready.
