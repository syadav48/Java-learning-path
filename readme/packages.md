Here’s a **complete yet concise** note on **Packages in Java** that covers folder structure, imports, naming conventions, reusability, and interview points.

---

# **Packages in Java – Notes**

## **Definition**

A **package** in Java is a **namespace** that groups related **classes, interfaces, and sub-packages** together.
It’s like a **folder** in your file system that stores related Java files.

**Purpose:**

* Avoid **naming conflicts**.
* Achieve **modularity** and **organization**.
* **Code reusability**.
* Easier **maintenance**.

---

## **Types of Packages**

1. **Built-in Packages** – Provided by Java (e.g., `java.util`, `java.io`, `java.sql`).
2. **User-defined Packages** – Created by the programmer.

---

## **Folder Structure**

Example:

```
Project/
 └── src/
      └── com/
           └── mycompany/
                └── app/
                     ├── Main.java
                     └── utils/
                          └── Helper.java
```

---

## **Creating a Package**

```java
// File: Helper.java
package com.mycompany.app.utils;

public class Helper {
    public static void sayHello() {
        System.out.println("Hello from Helper!");
    }
}
```

---

## **Using / Importing Packages**

### 1. **Import a Specific Class**

```java
import com.mycompany.app.utils.Helper;
Helper.sayHello();
```

### 2. **Import All Classes in a Package**

```java
import com.mycompany.app.utils.*;
```

### 3. **Fully Qualified Name (No Import)**

```java
com.mycompany.app.utils.Helper.sayHello();
```

---

## **Access Modifiers & Packages**

* `public` → Accessible everywhere.
* `protected` → Accessible in subclasses (even in different packages).
* Default (no modifier) → Accessible only in same package.
* `private` → Accessible only in same class.

---

## **Naming Conventions for Packages**

* Always lowercase.
* Reverse domain name of organization for uniqueness.
* Example:

  * **Correct:** `com.example.projectname`
  * **Avoid:** `MyPackage`, `Test1`

---

## **Advantages / Reusability**

* **Code reusability:** Once a package is created, you can reuse it in multiple projects by importing.
* **Encapsulation:** Control access to classes using access modifiers.
* **Maintainability:** Related classes grouped together.
* **Avoid naming conflicts:** Fully qualified names keep uniqueness.

---

## **Static Import**

Allows direct access to **static members** without class reference.

```java
import static java.lang.Math.*;
System.out.println(sqrt(16)); // No Math.sqrt
```

---

## **Interview Key Points**

1. **Default Package:** If no package is declared, class is in the default package (not recommended for large projects).
2. **Can a class be in multiple packages?** → No, one class belongs to exactly one package.
3. **Folder name = Package name** (case-sensitive).
4. **`package` statement** must be **first non-comment line** in the source file.
5. **Package-private** is the default access level.
6. **Sub-packages** are independent packages — importing parent does not import sub-packages.

---

## **Quick Recap Table**

| Feature               | Description                                    |
| --------------------- | ---------------------------------------------- |
| Built-in packages     | `java.util`, `java.io`, etc.                   |
| User-defined packages | Created by devs using `package` keyword        |
| Folder structure      | Matches package name hierarchy                 |
| Naming conventions    | Lowercase, reverse domain name                 |
| Import types          | Specific class, wildcard, fully qualified name |
| Static import         | Import static members directly                 |

---

If you want, I can also give you a **visual diagram** showing **package hierarchy + import rules** so you can glance and remember everything quickly for exams or interviews.
Do you want me to make that?
