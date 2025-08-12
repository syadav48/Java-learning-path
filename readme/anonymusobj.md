Here’s a **quick note** on **Anonymous Objects** in Java:

---

## **Anonymous Objects in Java**

### **Definition**

An **anonymous object** is an object that **does not have a reference variable** — it is created and used **immediately**.

---

### **Syntax**

```java
new ClassName().methodName();
```

---

### **Example**

```java
class Demo {
    void show() {
        System.out.println("Hello from Demo");
    }
}

public class Test {
    public static void main(String[] args) {
        new Demo().show(); // Anonymous object
    }
}
```

* Here, `new Demo()` creates the object.
* `.show()` immediately calls the method.
* No variable like `Demo obj = ...` is used.

---

### **Key Points**

* **Lifetime** → Only until the statement ends. After that, it becomes eligible for garbage collection.
* **Usage** → Good for **one-time use** objects, like:

  * Passing an object as an argument
  * Quick method calls
  * Avoiding unnecessary variable declarations
* **Limitation** → Cannot reuse the object since there is no reference.

---

### **Example with Parameter**

```java
class Sum {
    Sum(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }
}

public class Main {
    public static void main(String[] args) {
        new Sum(5, 10); // Anonymous object calls constructor
    }
}
```

---

If you want, I can also give you a **memory diagram** showing how an anonymous object is created and immediately becomes eligible for GC. That would make the concept visually clear.
