Great! Your `Calculator` class is a **perfect example of Method Overloading** in Java. Let's break it down clearly and simply:

---

## 🧠 What is **Method Overloading**?

**Method Overloading** means:

> **Defining multiple methods with the same name** in the same class, but with **different parameters** (type, number, or order).

🔸 It's a **compile-time polymorphism** (Java decides which method to call at compile time).

---

## ✅ Rules for Method Overloading

To overload a method, you must change **at least one** of the following:

* Number of parameters
* Data types of parameters
* Order of parameters (if different types)

But method **name must be the same**, and return type **can** be different, but **it’s not enough alone** to overload a method.

---

## 🔍 Let’s Analyze Your `Calculator` Class

```java
class Calculator {
    int n1 = 5;

    public int add(int num1, int num2) {
        System.out.println("Adding the two values");
        return num1 + num2;
    }

    public int add(int num1, int num2, int num3) {
        System.out.println("Adding the three values");
        return num1 + num2 + num3;
    }

    public double add(double num1, int num2) {
        return num1 + num2;
    }
}
```

### 👇 You overloaded the `add()` method 3 times:

| Method               | Parameters                        | Why it's Overloaded            |
| -------------------- | --------------------------------- | ------------------------------ |
| `add(int, int)`      | 2 integers                        | Original                       |
| `add(int, int, int)` | 3 integers                        | Different **number** of params |
| `add(double, int)`   | 2 params with different **types** | Different **data types**       |

---

## ⚙️ How Java Chooses Which `add()` to Call?

Let’s say you do:

```java
Calculator calc = new Calculator();

System.out.println(calc.add(2, 3));           // calls add(int, int)
System.out.println(calc.add(2, 3, 4));        // calls add(int, int, int)
System.out.println(calc.add(2.5, 3));         // calls add(double, int)
```

🔸 Java matches the arguments at **compile time** with the best-matching overloaded method signature.

---

## ⚠️ Can Return Type Alone Overload a Method?

**No.** Example:

```java
public int add(int a, int b) { ... }
public double add(int a, int b) { ... } ❌ INVALID
```

* Same method signature → Compilation error
* Only return type is different → Not allowed

---

## 📌 Benefits of Method Overloading

* Improves **code readability**
* Allows **flexible interfaces** for method callers
* Reduces method names – better naming consistency

---

## 📝 Summary

| Feature     | Method Overloading                     |
| ----------- | -------------------------------------- |
| Type        | Compile-time Polymorphism              |
| Signature   | Same name, different parameters        |
| Return Type | Can be different, but not enough alone |
| Purpose     | Code flexibility and reusability       |

---

Let me know if you want a few **practice questions** on this or want to compare this with **method overriding** (used in inheritance).
