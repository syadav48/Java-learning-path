Alright — let’s break down **static variable**, **static method**, and **static block** in Java with both **theory** and **practical examples** so it sticks in memory.

---

## **1. Static in Java – Concept Overview**

In Java, `static` means **belonging to the class, not the object**.

* **Static variable** → shared across all objects of the class.
* **Static method** → can be called without creating an object.
* **Static block** → executes only once when the class is loaded into memory.

---

## **2. Class Loading & Object Instantiation Flow**

When you run a Java program:

1. **Class Loading** → JVM loads the `.class` file into memory.

   * Static variables are allocated.
   * Static blocks are executed.
2. **Object Instantiation** → `new` keyword creates objects in heap memory.

   * Instance variables are allocated.
   * Constructor runs.

---

## **3. Static Variable**

* Belongs to the class.
* Only **one copy** exists in memory, shared by all objects.
* Stored in **method area** (part of JVM memory).

**Example:**

```java
class Counter {
    static int count = 0; // static variable

    Counter() {
        count++;
        System.out.println("Count: " + count);
    }
}

public class StaticVariableExample {
    public static void main(String[] args) {
        Counter c1 = new Counter(); // Count: 1
        Counter c2 = new Counter(); // Count: 2
        Counter c3 = new Counter(); // Count: 3
    }
}
```

Here, `count` is shared among all `Counter` objects.

---

## **4. Static Method**

* Can be called **without an object**.
* Can only access:

  * **Static variables** directly.
  * **Static methods** directly.
* Cannot access instance variables (because they belong to objects).

**Example:**

```java
class MathUtil {
    static int square(int x) {
        return x * x;
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        // Calling without creating an object
        System.out.println(MathUtil.square(5)); // 25
    }
}
```

---

## **5. Static Block**

* Runs **only once** when the class is loaded.
* Used for **static initialization**.
* Executes before the `main()` method.

**Example:**

```java
class InitExample {
    static int num;

    static {
        System.out.println("Static block executed");
        num = 10;
    }
}

public class StaticBlockExample {
    public static void main(String[] args) {
        System.out.println("Main method started");
        System.out.println("Num: " + InitExample.num);
    }
}
```

**Output:**

```
Static block executed
Main method started
Num: 10
```

---

## **6. Full Example Showing All Together**

```java
class Demo {
    static int staticVar; // Static variable
    int instanceVar;      // Instance variable

    // Static block
    static {
        System.out.println("Static block: Class is loading...");
        staticVar = 100;
    }

    // Constructor
    Demo(int val) {
        System.out.println("Constructor: Object is created");
        instanceVar = val;
    }

    // Static method
    static void staticMethod() {
        System.out.println("Static method: staticVar = " + staticVar);
    }

    // Instance method
    void instanceMethod() {
        System.out.println("Instance method: instanceVar = " + instanceVar);
    }
}

public class StaticConceptDemo {
    public static void main(String[] args) {
        // Class loads now → static block runs
        Demo.staticMethod(); // No object needed

        // Creating first object
        Demo obj1 = new Demo(10);
        obj1.instanceMethod();

        // Creating second object
        Demo obj2 = new Demo(20);
        obj2.instanceMethod();
    }
}
```

**Output:**

```
Static block: Class is loading...
Static method: staticVar = 100
Constructor: Object is created
Instance method: instanceVar = 10
Constructor: Object is created
Instance method: instanceVar = 20
```

---

## **7. Key Takeaways**

| Feature          | Static Variable              | Static Method                | Static Block           |
| ---------------- | ---------------------------- | ---------------------------- | ---------------------- |
| **When created** | At class loading             | At class loading             | At class loading       |
| **Memory**       | Method area (JVM)            | Method area                  | Method area            |
| **Access**       | Shared by all objects        | Can be called without object | Executes automatically |
| **Usage**        | Shared data (e.g., counters) | Utility/helper methods       | Static initialization  |
| **Runs**         | Exists till program ends     | Called explicitly            | Once per class load    |

---

If you like, I can also **draw a memory diagram** showing when static and instance members are created, so you visually see **method area, heap, and stack** during execution.
That’s especially useful for understanding **class loading vs. object creation**.
