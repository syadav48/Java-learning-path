Alright — here’s a **complete, well-organized note** on **Constructors in Java**, covering your example plus all related concepts.

---

# **Constructors in Java – Complete Notes**

## **1. What is a Constructor?**

* A **constructor** is a **special method** in Java used to **initialize objects**.
* **Name**: Must be **same as the class name**.
* **No return type** (not even `void`).
* Called **automatically** when an object is created.

---

## **2. Key Features**

* Executes **only once** per object creation.
* Can be **overloaded** (different parameter lists).
* Can use `this()` to call another constructor.
* Can use **access modifiers** (`public`, `private`, etc.).

---

## **3. Types of Constructors**

### **(a) Default Constructor**

* Provided automatically if no constructor is defined.
* Initializes variables with default values:

  * `int` → 0
  * `double` → 0.0
  * `boolean` → false
  * Objects → null

```java
class Test {
    int x;
}
public class Main {
    public static void main(String[] args) {
        Test t = new Test(); // Default constructor runs
        System.out.println(t.x); // 0
    }
}
```

---

### **(b) No-Argument Constructor**

* You define it explicitly.

```java
class Human {
    int age;
    String name;

    public Human() {
        age = 12;
        name = "Surya";
    }
}
```

---

### **(c) Parameterized Constructor**

* Takes arguments to initialize object with specific values.

```java
class Human {
    int age;
    String name;

    public Human(String name) {
        this.age = 12;
        this.name = name;
    }
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
```

---

## **4. Constructor Overloading**

* Multiple constructors with different parameter lists.
* Decided at **compile-time** (method overloading rules apply).

**Example from your code:**

```java
class Human {
    private int age;
    private String name;

    public Human() {
        System.out.println("in the const");
        age = 12;
        name = "Surya";
    }
    public Human(String name) {
        this.age = 12;
        this.name = name;
    }
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
```

Here:

* `Human()` → no-arg constructor
* `Human(String name)` → 1 parameter
* `Human(int age, String name)` → 2 parameters

---

## **5. Using `this()` in Constructors (Constructor Chaining)**

* **Purpose**: Avoid code duplication.
* Must be **first statement** in the constructor.

**Example:**

```java
class Human {
    int age;
    String name;

    public Human() {
        this(12, "Surya"); // calls parameterized constructor
        System.out.println("Default constructor");
    }
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
```

---

## **6. Your Example in Action**

```java
public class Const {
    public static void main(String[] args) {
        Human obj1 = new Human(); // calls Human()
        Human obj2 = new Human(); // calls Human()
        System.out.println(obj1.getName() + obj2.getAge());
    }
}
```

**Flow:**

1. **obj1** creation:

   * Class `Human` is loaded (once).
   * `Human()` runs → prints `"in the const"`, sets `age=12`, `name="Surya"`.
2. **obj2** creation:

   * Another call to `Human()` → prints `"in the const"` again.
3. Output prints:

```
in the const
in the const
Surya12
```

---

## **7. Important Points**

1. If you **define any constructor**, Java won’t provide a default constructor automatically.
2. Constructor can **call another constructor** using `this()`.
3. Constructors **cannot**:

   * Have a return type.
   * Be `static`, `final`, or `abstract`.
4. You can **overload** constructors but **cannot override** them.
5. Objects are always **created in heap memory**, constructors initialize them.

---

## **8. Constructor vs Method**

| Feature     | Constructor                      | Method                |
| ----------- | -------------------------------- | --------------------- |
| Name        | Same as class name               | Any valid identifier  |
| Return type | No return type (not even void)   | Must have return type |
| When called | Automatically at object creation | Called explicitly     |
| Purpose     | Initialize object                | Perform operations    |

---

If you want, I can also make a **memory diagram** showing how `obj1` and `obj2` get separate memory in heap but constructors initialize their own fields — which makes the execution of your example crystal clear.
