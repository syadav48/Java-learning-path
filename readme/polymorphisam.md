Alright — let’s break this down into **a complete, interview-ready note** on **Polymorphism** in Java, using your example and expanding it with important theory, examples, and common interview traps.

---

## **Polymorphism in Java**

**Definition:**
Polymorphism (Greek: *poly* = many, *morph* = forms) means **one interface, many implementations**.
In Java, polymorphism allows the **same method name** to behave differently based on the object that’s calling it.

---

### **Types of Polymorphism in Java**

1. **Compile-Time Polymorphism (Static Binding)**

   * Achieved through **method overloading**.
   * The decision of which method to call is made **at compile time**.
   * Example:

     ```java
     class Test {
         void display(int a) { System.out.println("int"); }
         void display(String s) { System.out.println("String"); }
     }
     public class Main {
         public static void main(String[] args) {
             Test t = new Test();
             t.display(5);    // int
             t.display("Hi"); // String
         }
     }
     ```

2. **Run-Time Polymorphism (Dynamic Binding)**

   * Achieved through **method overriding**.
   * The decision of which method to call is made **at runtime** based on the actual object.
   * Requires **upcasting**: reference type is parent class, object type is child class.

---

### **Your Example: Dynamic Method Dispatch**

```java
class A {
    public void show() {
        System.out.println("in A");
    }
}
class B extends A {
    public void show() {
        System.out.println("in B");
    }
}
class C extends B {
    public void show() {
        System.out.println("in C");
    }
}
public class Polymorphisam {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();  // in A

        obj = new B();
        obj.show();  // in B (runtime decision)

        obj = new C();
        obj.show();  // in C (runtime decision)
    }
}
```

#### **Key Points in This Example**

* The **reference variable** type (`A`) decides **what methods are available** at compile time.
* The **actual object** (`new B()`, `new C()`) decides **which overridden method executes** at runtime.
* This is called **Dynamic Method Dispatch**.

---

### **Rules for Method Overriding**

1. Method name and parameters must be the same as in the parent class.
2. Return type must be same or covariant (subtype allowed in Java 5+).
3. Cannot reduce access level.
4. Cannot override `final` or `static` methods.
5. If the parent method throws a checked exception, overridden method can:

   * Throw the same exception
   * Throw a subclass of that exception
   * Throw no exception

---

### **Upcasting & Downcasting**

* **Upcasting**:

  ```java
  A obj = new B(); // Allowed (Parent ref, child object)
  ```

  Gives **polymorphism**.

* **Downcasting**:

  ```java
  B b = (B) obj; // Allowed if obj is actually a B
  ```

  If not actually B → `ClassCastException`.

---

### **Why Not Achieve Polymorphism with Static Methods?**

* Static methods are **class-level** and resolved at **compile time** (Static Binding), so they don’t support runtime polymorphism.

---

### **Common Interview Questions & Traps**

1. **Can private methods be overridden?**
   ❌ No. They are not inherited, so they are hidden, not overridden.

2. **Can constructors be overridden?**
   ❌ No. Constructors are not inherited.

3. **If we do `A obj = new C();` will it call `show()` from C?**
   ✅ Yes, if overridden in C — runtime polymorphism chooses it.

4. **What if `show()` is not overridden in B or C?**
   → Inherits from the nearest superclass where it is defined.

5. **Why runtime polymorphism is called late binding?**
   Because method resolution happens **at runtime**, not compile time.

6. **Difference between Overloading vs Overriding** (Important Table):

| Feature               | Overloading (Compile Time) | Overriding (Runtime) |
| --------------------- | -------------------------- | -------------------- |
| Method Name           | Same                       | Same                 |
| Parameters            | Different                  | Same                 |
| Return Type           | Can differ                 | Same or covariant    |
| Access Modifiers      | Can change freely          | Cannot reduce access |
| Binding Time          | Compile time               | Runtime              |
| Inheritance Required? | No                         | Yes                  |

---

### **Practical Problem**

What is the output?

```java
class A {
    void show() { System.out.println("A"); }
}
class B extends A {
    void show() { System.out.println("B"); }
}
class C extends B {
    void show() { System.out.println("C"); }
}
public class Test {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();
        obj = new C();
        obj.show();
    }
}
```

**Output:**

```
B
C
```

Reason: **Runtime polymorphism** picks the method from the actual object.

---

If you want, I can also prepare a **one-page interview revision sheet for Polymorphism** that condenses all of this into diagrams, examples, and rules.
That will make it easier for quick recall before interviews.
