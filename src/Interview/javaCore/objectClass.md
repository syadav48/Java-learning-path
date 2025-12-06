Below is a **clean, beginner-friendly + interview-ready explanation** of the **Object class**, all its important methods, and **why we override them** — WITH examples.

---

# 🚀 **1. What is Object class in Java?**

* It is the **root** (topmost) class of Java.
* Every class in Java extends **Object** (directly or indirectly).
* This means **every Java object inherits** methods like `toString()`, `equals()`, `hashCode()`, `clone()`, `getClass()`.

Example:

```java
class A {}                // implicitly extends Object
class B extends A {}      // indirectly extends Object
```

Even if you don’t write `extends Object`, Java adds it automatically.

---

# 🟦 **2. Important Object Class Methods (With Example)**

Let’s use a simple model:

```java
class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

Now let’s see how Object methods work.

---

# ⭐ **2.1 toString()**

**Default behavior** → prints class name + memory reference
Example:

```java
Student s = new Student(1, "Ram");
System.out.println(s);
```

Output (not useful):

```
Student@7ad041f3
```

### ✔ Why override?

To print meaningful details.

```java
@Override
public String toString() {
    return "Student{id=" + id + ", name='" + name + "'}";
}
```

Now:

```java
System.out.println(s);
```

Output:

```
Student{id=1, name='Ram'}
```

---

# ⭐ **2.2 equals()**

Default behavior → compares **references**, NOT values.

Example:

```java
Student s1 = new Student(1, "Ram");
Student s2 = new Student(1, "Ram");

System.out.println(s1.equals(s2)); // false
```

Even though content is same, JVM checks:

```
Are s1 and s2 same object? → No → false
```

### ✔ Why override equals()?

To compare objects by value.

```java
@Override
public boolean equals(Object obj) {
    Student s = (Student) obj;
    return this.id == s.id && this.name.equals(s.name);
}
```

Now:

```
s1.equals(s2) → true
```

---

# ⭐ **2.3 hashCode()**

Default → returns memory-based hash value.
Used in **HashMap**, **HashSet**, **HashTable**.

### ❗ If you override equals(), YOU MUST override hashCode()

Why?

Because equal objects must go to the **same bucket** in HashMap/HashSet.

Example of correct override:

```java
@Override
public int hashCode() {
    return Objects.hash(id, name);
}
```

---

# ⭐ **2.4 getClass()**

Returns runtime class:

```java
Student s = new Student(1, "Ram");
System.out.println(s.getClass());
```

Output:

```
class Student
```

Used in frameworks (Spring, Hibernate, reflection, logging).

---

# ⭐ **2.5 clone()**

Used for copying objects.

Default → shallow copy.
To use clone, class must:

```java
class Student implements Cloneable
```

Example:

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    return super.clone();
}
```

---

# 🚨 **3. Why override equals() + hashCode() together? (Important)**

Let’s say you have:

```java
Student s1 = new Student(1, "Ram");
Student s2 = new Student(1, "Ram");
```

Now insert into a HashSet:

```java
Set<Student> set = new HashSet<>();
set.add(s1);
set.add(s2);

System.out.println(set.size());
```

### ❌ If equals() is overridden but hashCode() is NOT:

* equals() → says s1 and s2 are SAME
* hashCode() → different (default memory-based)
* HashSet puts them in **different buckets**

Output:

```
2
```

This breaks the rule of HashSet.

---

# ✔ Correct Solution: Override BOTH

```java
@Override
public boolean equals(Object obj) {
    Student s = (Student) obj;
    return this.id == s.id && this.name.equals(s.name);
}

@Override
public int hashCode() {
    return Objects.hash(id, name);
}
```

Now:

```
set.size() = 1   // Works correctly
```

---

# 🎯 **INTERVIEW SUMMARY ANSWER**

### ✔ **Why override toString()?**

To print meaningful object details instead of memory address.

### ✔ **Why override equals()?**

To compare objects based on content, not references.

### ✔ **Why override hashCode()?**

To ensure objects that are equal (via equals) go into the **same hash bucket**.

### ✔ **Why must equals() and hashCode() be overridden together?**

Because Java contract requires:

> If two objects are equal, they must have the same hashCode.

Otherwise, HashMap & HashSet behave inconsistently.

---

# 🎁 If you want, I can also give:

✔ A diagram of equals/hashCode working inside HashMap
✔ A full Student model with all overrides implemented
✔ Common mistakes developers make with equals/hashCode

Just tell me!
