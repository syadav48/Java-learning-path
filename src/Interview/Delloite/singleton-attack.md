

## 🔥 Interview Insight

They may ask:

> "Why are you passing parameters to Singleton?"

Correct answer:
👉 Singleton should **not depend on external parameters during creation**, or you must design it differently (e.g., init method).

---

## ✅ Better Design

### Option 1: Initialize once

```java
public static Singleton getInstance(int num, String name){
    if(instance == null){
        instance = new Singleton(num, name);
    }
    return instance;
}
```

👉 And clearly document: *first call decides state*

---

### Option 2 (Cleaner): No params

```java
private Singleton() {}

public static Singleton getInstance(){
    if(instance == null){
        instance = new Singleton();
    }
    return instance;
}
```

---

# 💥 Now the REAL Interview Question:

## "How to break Singleton?"

---

## ❌ 1. Reflection Attack

```java
Constructor<Singleton> constructor =
        Singleton.class.getDeclaredConstructor(int.class, String.class);

constructor.setAccessible(true);

Singleton s1 = Singleton.getInstance(1, "A");
Singleton s2 = constructor.newInstance(2, "B");

System.out.println(s1 == s2); // ❌ false
```

👉 You just created **two instances**

---

## ✅ Fix for Reflection

```java
private Singleton(int num, String name){
    if(instance != null){
        throw new RuntimeException("Use getInstance()");
    }
    this.num = num;
    this.name = name;
}
```

---

## ❌ 2. Serialization Attack

```java
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file"));
out.writeObject(instance);

ObjectInputStream in = new ObjectInputStream(new FileInputStream("file"));
Singleton newInstance = (Singleton) in.readObject();

System.out.println(instance == newInstance); // ❌ false
```

---

## ✅ Fix for Serialization

```java
protected Object readResolve() {
    return instance;
}
```

---

## ❌ 3. Cloning Attack

If class implements `Cloneable`:

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    return super.clone(); // ❌ breaks singleton
}
```

---

## ✅ Fix

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
}
```

---

# 🏆 Ultimate Safe Solution (Best Answer)

```java
public enum Singleton {
    INSTANCE;

    private int num;
    private String name;
}
```

👉 Handles:

* Reflection ✅
* Serialization ✅
* Thread safety ✅

---

# 🔚 Final Review of Your Code

### ✅ Good:

* Private constructor ✔️
* Static instance ✔️

### ⚠️ Needs improvement:

* Not thread-safe ❌
* Parameter misuse ❌
* No protection against reflection/serialization ❌

---

# 🚀 What You Should Say in Interview

> "Singleton can be broken via reflection, serialization, and cloning. To prevent that, we either guard constructor, implement readResolve, block cloning, or use enum-based singleton which is safest."

---

If you want, I can give you a **Deloitte-style follow-up question** where they combine:
👉 Singleton + Multithreading + Memory Model (volatile)

That’s where most candidates get stuck.
