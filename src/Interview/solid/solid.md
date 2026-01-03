Great topic 👍
I’ll explain **SOLID principles** the way they are expected in **LLD / system design interviews**, with **clear Java examples**, **problem → solution**, and **why the principle exists**.

---

# SOLID Principles (with Java Examples)

---

## 1️⃣ **Single Responsibility Principle (SRP)**

### Definition

> **A class should have only one reason to change.**

Meaning:
👉 **One class = one responsibility**

---

### ❌ Violation Example

```java
class UserService {
    void registerUser(String name) {
        System.out.println("Registering user: " + name);
    }

    void sendEmail(String email) {
        System.out.println("Sending email to: " + email);
    }
}
```

🔴 Problems:

* User registration logic
* Email logic
  Both in **same class**

If email logic changes → UserService changes → **tight coupling**

---

### ✅ Correct (SRP Followed)

```java
class UserService {
    void registerUser(String name) {
        System.out.println("Registering user: " + name);
    }
}

class EmailService {
    void sendEmail(String email) {
        System.out.println("Sending email to: " + email);
    }
}
```

✔ Each class has **one job**

---

### Real-world analogy

👨‍⚕️ Doctor treats patients
📋 Receptionist handles paperwork
One person doing both = messy

---

---

## 2️⃣ **Open / Closed Principle (OCP)**

### Definition

> **Open for extension, closed for modification**

Meaning:
👉 Add new behavior **without changing existing code**

---

### ❌ Violation Example

```java
class DiscountCalculator {
    double calculate(String type, double amount) {
        if (type.equals("FESTIVAL")) {
            return amount * 0.8;
        } else if (type.equals("SEASONAL")) {
            return amount * 0.9;
        }
        return amount;
    }
}
```

🔴 Every new discount → modify this class

---

### ✅ Correct (Using Polymorphism)

```java
interface Discount {
    double apply(double amount);
}

class FestivalDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.8;
    }
}

class SeasonalDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.9;
    }
}
```

```java
class DiscountCalculator {
    double calculate(Discount discount, double amount) {
        return discount.apply(amount);
    }
}
```

✔ New discount = **new class**, no modification

---

### Interview keyword

👉 **Strategy Pattern**

---

---

## 3️⃣ **Liskov Substitution Principle (LSP)**

### Definition

> **Subclasses must be substitutable for their base classes**

Meaning:
👉 Child class should **not break parent behavior**

---

### ❌ Violation Example

```java
class Bird {
    void fly() {
        System.out.println("Bird flying");
    }
}

class Penguin extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```

🔴 Penguin **breaks expectations**

---

### ❌ Problem in usage

```java
Bird bird = new Penguin();
bird.fly(); // 💥 Runtime error
```

---

### ✅ Correct Design

```java
interface Bird { }

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Penguin implements Bird {
    // No fly()
}
```

✔ No broken behavior

---

### Interview line

> “Child should strengthen behavior, not weaken it.”

---

---

## 4️⃣ **Interface Segregation Principle (ISP)**

### Definition

> **Clients should not be forced to implement unused methods**

Meaning:
👉 Many **small interfaces** are better than one big interface

---

### ❌ Violation Example

```java
interface Worker {
    void work();
    void eat();
}
```

```java
class Robot implements Worker {
    public void work() {
        System.out.println("Robot working");
    }

    public void eat() {
        // ❌ Robot doesn't eat
    }
}
```

---

### ✅ Correct (Split Interfaces)

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}
```

```java
class Human implements Workable, Eatable {
    public void work() {}
    public void eat() {}
}

class Robot implements Workable {
    public void work() {}
}
```

✔ No forced implementation

---

### Real-world analogy

📺 TV remote with **100 buttons** vs **simple remote**

---

---

## 5️⃣ **Dependency Inversion Principle (DIP)**

### Definition

> **Depend on abstractions, not concrete implementations**

Meaning:
👉 High-level modules should not depend on low-level modules

---

### ❌ Violation Example

```java
class MySQLDatabase {
    void connect() {
        System.out.println("Connecting MySQL");
    }
}

class UserService {
    MySQLDatabase db = new MySQLDatabase();

    void save() {
        db.connect();
    }
}
```

🔴 Tight coupling to MySQL

---

### ✅ Correct (Using Abstraction)

```java
interface Database {
    void connect();
}
```

```java
class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connecting MySQL");
    }
}

class MongoDatabase implements Database {
    public void connect() {
        System.out.println("Connecting MongoDB");
    }
}
```

```java
class UserService {
    private Database database;

    UserService(Database database) {
        this.database = database;
    }

    void save() {
        database.connect();
    }
}
```

✔ Easy to switch DB
✔ Testable
✔ Loosely coupled

---

### Spring Boot Connection 💡

```java
@Autowired
Database database;
```

Spring injects implementation → **DIP in action**

---

---

## 🧠 SOLID in One Shot (Interview Ready)

| Principle | One Line                           |
| --------- | ---------------------------------- |
| SRP       | One class, one responsibility      |
| OCP       | Add features without changing code |
| LSP       | Child must not break parent        |
| ISP       | Small interfaces are better        |
| DIP       | Code to interfaces                 |

---

If you want next:

* SOLID **violations in real Spring Boot projects**
* Convert **bad legacy code → SOLID**
* SOLID **mapping with design patterns**
* Interview **LLD questions using SOLID**

Just tell me 👍
