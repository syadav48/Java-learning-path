Here’s a **brief but interview-ready** note on the `final` keyword in Java based on your example (and a few additions for completeness).

---

## **`final` Keyword in Java**

The `final` keyword in Java is used to **restrict changes**.
It can be applied to:

1. **Variables** → make the variable constant (cannot be reassigned).
2. **Methods** → prevent method overriding.
3. **Classes** → prevent inheritance.

---

### **1. Final Variable**

* Once initialized, its value cannot be changed.
* Must be assigned **at declaration** or inside a **constructor** (for instance variables).
* Commonly used for constants (`static final`).

```java
final int x = 10; // cannot reassign x later
x = 20; // ❌ Compile-time error
```

---

### **2. Final Method**

* A method declared as `final` **cannot be overridden** by subclasses.
* Used for methods whose behavior should not be altered for security or design reasons.

```java
class A {
    final void show() {
        System.out.println("Hello from A");
    }
}
class B extends A {
    // void show() { } ❌ Compile-time error (can't override)
}
```

---

### **3. Final Class**

* A class declared as `final` **cannot be inherited**.
* Used to prevent modification or to secure immutable classes (e.g., `String` is `final`).

```java
final class A {}
class B extends A {} // ❌ Compile-time error
```

---

### **Example Based on Your Code**

```java
final class Calc {
    final public void show() {
        System.out.println("by Surya");
    }
    public int add(int a, int b) {
        return a + b;
    }
}

class AdvCalc extends Calc { // ❌ Error: Cannot subclass final class
    public void show() { } // ❌ Error: Cannot override final method
}

public class FinalExample {
    public static void main(String[] args) {
        Calc obj = new Calc();
        obj.show();
        System.out.println(obj.add(4, 5));
    }
}
```

---

### **Key Points for Interviews**

1. **Performance**:

   * The JVM can optimize `final` methods by inlining, as it knows they won’t be overridden.

2. **Security**:

   * Prevents accidental or malicious overriding of sensitive methods.

3. **Design Intent**:

   * Signals that a class or method is **complete** and not meant to be extended.

4. **Static + Final**:

   * Used for constants (`public static final int MAX = 100;`).

5. **Final vs Immutable**:

   * `final` variable → reference cannot be changed.
   * Immutable object → internal state cannot be changed (needs defensive coding).

6. **Blank Final Variables**:

   * Declared without initialization but **must** be initialized in the constructor or initializer block.

---

✅ **Possible Interview Question**:

* *Q*: Can we declare a constructor as `final`?
  *A*: No, because constructors are not inherited, so there's no point in marking them as final.

---

If you want, I can prepare a **comparison table of `final` variable vs method vs class** for quick revision before interviews. That way, you'll have a ready 30-second recall. Would you like me to do that?
