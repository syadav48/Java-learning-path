Alright — let’s break **`super`** down fully like we did with `constructor` and `this`, then explain exactly why **`super` and `this` cannot be called together** in the same constructor.

---

# **`super` Keyword in Java – Complete Notes**

## **1. What is `super`?**

`super` is a reference variable in Java that **refers to the immediate parent class object**.
It is **used only in inheritance**.

---

## **2. Uses of `super`**

### **A. Calling Parent Class Constructor**

* If you don’t explicitly call `super(...)`, Java inserts `super();` **as the first statement** automatically in the constructor.
* `super(...)` **must be the first statement** in the constructor if used.
* Purpose: Ensure parent class initialization happens before child class initialization.

**Example from your code:**

```java
class A extends Object {
    public A() {
        super(); // calls Object() constructor
        System.out.println("in A");
    }
    public A(int a) {
        super();
        System.out.println("in parametrized A");
    }
}

class B extends A {
    public B(int b) {
        super(5); // calls parameterized constructor of A
        System.out.println("in parametrized B");
    }
}
```

**Execution for `new B(5)`**:

1. `B(int b)` → calls `super(5)` (A’s parameterized constructor).
2. `A(int a)` → calls `super()` (Object class constructor).
3. `Object()` constructor runs (implicit).
4. Prints `"in parametrized A"`.
5. Back to `B(int b)`, prints `"in parametrized B"`.

---

### **B. Accessing Parent Class Methods**

If a method in the child class overrides the parent’s method, `super.methodName()` calls the **parent version**.

```java
class A {
    void show() { System.out.println("A’s show"); }
}
class B extends A {
    void show() {
        super.show(); // Calls A's show
        System.out.println("B’s show");
    }
}
```

---

### **C. Accessing Parent Class Variables**

When a child class variable **hides** the parent’s variable, `super.variable` accesses the parent’s version.

```java
class A {
    int num = 10;
}
class B extends A {
    int num = 20;
    void print() {
        System.out.println(num);       // 20
        System.out.println(super.num); // 10
    }
}
```

---

## **3. The Special Case: `super` in Topmost Class**

* Every class in Java **implicitly extends** `Object` if no other superclass is specified.
* In your code:

```java
class A extends Object { ... }
```

`super();` inside `A()` calls **`Object()`**, which is the **root constructor** in Java.

* `Object` class is part of `java.lang` package.
* It has a **default no-arg constructor**.

---

## **4. Why `super()` and `this()` cannot be used in the same constructor**

### **Reason:**

* **`super()`** calls a **constructor in the parent class**.
* **`this()`** calls another **constructor in the same class**.
* Both must be **the first statement** in a constructor.
* Since there can only be **one first statement**, you cannot have both in the same constructor.

**Invalid example:**

```java
class Test extends Parent {
    Test() {
        super(); // must be first
        this(5); // must also be first → ❌ compile-time error
    }
}
```

**Compiler Error:**

```
Constructor call must be the first statement in a constructor
```

**Correct approach:**

* If you need both effects, chain them indirectly:

  * `this()` calls another constructor in the same class.
  * That constructor can call `super()`.

**Example:**

```java
class B extends A {
    B() {
        super(); // only here
        System.out.println("Default B");
    }
    B(int b) {
        this(); // calls default B(), which calls super()
        System.out.println("Param B");
    }
}
```

---

## **5. Summary Table**

| Feature           | `super()`                | `this()`                              |
| ----------------- | ------------------------ | ------------------------------------- |
| Refers to         | Parent class object      | Current class object                  |
| Calls             | Parent class constructor | Another constructor in the same class |
| Must be first?    | Yes                      | Yes                                   |
| Together allowed? | No                       | No                                    |

---

If you like, I can also make a **step-by-step memory + call stack diagram** showing exactly what happens in `new B(5)` from your code, including Object → A → B calls. That would make the constructor chaining and `super` flow crystal clear.
