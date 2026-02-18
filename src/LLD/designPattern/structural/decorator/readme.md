## 🎯 Decorator Pattern — Short, Practical Explanation

### 🧩 What Problem Does It Solve?

**Problem:**
You want to add behavior to an object **without modifying its code** and **without creating tons of subclasses**.

If you use inheritance:

```text
Coffee
 ├── MilkCoffee
 ├── SugarCoffee
 ├── MilkSugarCoffee
 ├── CaramelMilkCoffee
 ├── ...
```

This explodes very fast.

Decorator solves this by:

* Wrapping an object
* Adding behavior dynamically
* Keeping original class unchanged

👉 It follows **Open/Closed Principle**.

---

## 🧠 Core Idea

Instead of:

```java
class MilkCoffee extends Coffee
```

You do:

```java
class MilkDecorator implements Coffee
```

And it wraps a `Coffee`.

---

# ☕ Real Example — Coffee Customization

---

## Step 1: Component Interface

```java
public interface Coffee {
    String getDescription();
    double getCost();
}
```

---

## Step 2: Concrete Component

```java
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 50;
    }
}
```

---

## Step 3: Abstract Decorator

```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
```

This holds the wrapped object.

---

## Step 4: Concrete Decorators

### Milk Decorator

```java
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 20;
    }
}
```

---

### Sugar Decorator

```java
public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }
}
```

---

## Step 5: Usage

```java
Coffee coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee);
coffee = new SugarDecorator(coffee);

System.out.println(coffee.getDescription());
System.out.println(coffee.getCost());
```

### Output:

```
Simple Coffee, Milk, Sugar
80
```

---

# 🔥 What Just Happened?

You dynamically added:

* Milk
* Sugar

Without:

* Modifying `SimpleCoffee`
* Creating subclass combinations

That’s the power.

---

# 🏗️ Where It’s Used in Real Industry

### 1️⃣ Java IO

```java
BufferedReader br = new BufferedReader(
    new InputStreamReader(
        new FileInputStream("file.txt")
    )
);
```

Each wrapper adds behavior.

---

### 2️⃣ Spring Security Filters

Each filter decorates the request.

---

### 3️⃣ Middleware (Express / Node)

```js
app.use(authMiddleware)
app.use(loggingMiddleware)
```

Each wraps request handling.

---

# 🚨 When NOT to Use It

* If behavior won’t change dynamically.
* If composition becomes too deep and unreadable.
* If simple inheritance is enough.

---

# 🎯 In One Line

Decorator =
**Wrap an object to add new behavior at runtime without modifying its class.**

---

If you want, I can next:

* Compare Decorator vs Strategy (very common confusion)
* Show how Spring internally uses Decorator
* Or show a React example of Decorator concept

https://algomaster.io/learn/lld/decorator


