Got it ✅ — I’ll add **Method Overriding** into the inheritance notes so the concept is complete.

---

## **Inheritance in Java**

### **Definition**

Inheritance is a mechanism where **one class acquires the properties (fields) and behaviors (methods)** of another class using the `extends` keyword.

**Purpose:** Code reusability, method overriding, and creating hierarchical relationships.

---

## **1. Single Inheritance**

* **One child class inherits from one parent class.**
* **Syntax:**

```java
class Parent {
    void display() { System.out.println("Parent class"); }
}

class Child extends Parent {
    void show() { System.out.println("Child class"); }
}

public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        c.display(); // from Parent
        c.show();    // from Child
    }
}
```

---

## **2. Multilevel Inheritance**

* **Inheritance chain** → A class inherits from another class, which inherits from another.
* **Syntax:**

```java
class A {
    void methodA() { System.out.println("A class"); }
}
class B extends A {
    void methodB() { System.out.println("B class"); }
}
class C extends B {
    void methodC() { System.out.println("C class"); }
}

public class Test {
    public static void main(String[] args) {
        C obj = new C();
        obj.methodA();
        obj.methodB();
        obj.methodC();
    }
}
```

---

## **3. Method Overriding**

* **Definition:** When a subclass provides its own implementation of a method already defined in the parent class.
* **Rules:**

  1. Method name and parameters must be **identical** to the parent method.
  2. Return type must be the same (or covariant).
  3. Cannot reduce the visibility (e.g., public → private ❌).
  4. `@Override` annotation is optional but recommended.
  5. Only **inherited methods** can be overridden, not `static`, `final`, or `private` methods.
  6. Call parent version with `super.methodName()` if needed.

**Example:**

```java
class Animal {
    void sound() { System.out.println("Animal makes a sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

public class Test {
    public static void main(String[] args) {
        Animal obj = new Dog(); // Upcasting
        obj.sound(); // "Dog barks" (runtime polymorphism)
    }
}
```

---

## **4. Multiple Inheritance – Ambiguity Problem**

* **Java does not support multiple inheritance with classes** (one class extending two classes) because of the **Diamond Problem** (ambiguity).
* **Reason:**
  If two parent classes have the **same method name**, and a child inherits both, Java cannot decide which method to call.

**In Java (Not Allowed):**

```java
class A {}
class B {}
class C extends A, B {} // ❌ Compile-time error
```

---

## **5. How Java Solves This**

* **With Classes:** Only **single inheritance** is allowed.
* **With Interfaces:** Multiple inheritance is allowed because methods in interfaces are **abstract** (no ambiguity until implemented).

**Example with Interfaces:**

```java
interface A { void show(); }
interface B { void show(); }

class C implements A, B {
    public void show() { System.out.println("C's show"); }
}

public class Test {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
    }
}
```

---

✅ **Key Points Recap**

* **Single Inheritance:** 1 parent → 1 child
* **Multilevel Inheritance:** Chain of inheritance
* **Method Overriding:** Redefining parent method in child class
* **Multiple Inheritance with Classes:** ❌ Not supported to avoid ambiguity
* **Multiple Inheritance with Interfaces:** ✅ Supported

---

If you want, I can **add diagrams** showing single, multilevel, and multiple inheritance along with **method overriding in action** so it’s more visual. Would you like me to prepare that?
