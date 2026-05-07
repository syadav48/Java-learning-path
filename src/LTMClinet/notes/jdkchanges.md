You’ve picked the exact features interviewers use to judge whether you’re writing **modern Java or still stuck in Java 8 thinking**. I’ll walk through each one with **before vs after**, real use cases, and where people misuse them.

---

# 🚀 Java 21 — Records

## 🧠 What problem it solves

Before records, simple data classes were **bloated**.

### ❌ Old way

```java
class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) { /* long code */ }

    @Override
    public int hashCode() { /* long code */ }

    @Override
    public String toString() { /* long code */ }
}
```

---

## ✅ With Record

```java
record User(int id, String name) {}
```

👉 Automatically gives:

* constructor
* getters (`id()`, `name()`)
* `equals()`, `hashCode()`, `toString()`

---

## 💡 Real Use Cases

* DTOs (API request/response)
* Kafka messages
* Database projections

---

## ⚠️ When NOT to use

* Mutable objects ❌
* Entities with lifecycle (JPA entities)

---

---

# 🔥 Java 21 — Pattern Matching in `switch`

## 🧠 Problem

Too much casting + instanceof checks

---

### ❌ Old way

```java
Object obj = "Hello";

if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}
```

---

### ✅ New way

```java
Object obj = "Hello";

switch (obj) {
    case String s -> System.out.println(s.toUpperCase());
    case Integer i -> System.out.println(i * 2);
    default -> System.out.println("Unknown");
}
```

---

## 💡 Real Use Case

Event processing:

```java
switch (event) {
    case OrderCreated o -> processOrder(o);
    case PaymentDone p -> processPayment(p);
}
```

👉 Cleaner than `if-else instanceof` chains

---

---

# 🧩 Java 17 — Sealed Classes

## 🧠 Problem

You want **controlled inheritance**

---

### ✅ Example

```java
sealed class Payment permits CreditCard, UPI {}

final class CreditCard extends Payment {}
final class UPI extends Payment {}
```

👉 Only these classes can extend `Payment`

---

## 💡 Real Use Case

* Domain modeling (finite types)
* API contracts
* Event hierarchies

---

## 🔥 Combined with switch (powerful)

```java
static void process(Payment p) {
    switch (p) {
        case CreditCard c -> System.out.println("Card");
        case UPI u -> System.out.println("UPI");
    }
}
```

👉 Compiler ensures **all cases handled**

---

---

# ⚡ Java 11 — `var` (local type inference)

## 🧠 What it does

Removes redundant type declarations

---

### ❌ Old

```java
List<String> list = new ArrayList<>();
```

---

### ✅ New

```java
var list = new ArrayList<String>();
```

---

## ⚠️ Important Rules

* Only for **local variables**
* Type is still **statically determined**

---

## 💡 In Lambda (Java 11 feature)

```java
var list = List.of("a", "b");

list.forEach((var s) -> System.out.println(s));
```

👉 Useful when:

* Adding annotations
* Improving readability

---

## ❌ Bad usage

```java
var x = 10;
var y = "hello";
```

👉 Hurts readability

---

---

# 🔤 Java 11 — String Enhancements

---

## ✅ `isBlank()`

```java
"   ".isBlank(); // true
```

---

## ✅ `strip()`, `stripLeading()`, `stripTrailing()`

```java
"  hi  ".strip(); // "hi"
```

👉 Better than `trim()` (Unicode aware)

---

## ✅ `lines()`

```java
"Hello\nWorld".lines().forEach(System.out::println);
```

---

## ✅ `repeat()`

```java
"Hi ".repeat(3); // "Hi Hi Hi "
```

---

## 💡 Real Use Cases

* Input validation
* Text processing
* File parsing

---

---

# 🌐 Java 11 — New HTTP Client API

Replaces old `HttpURLConnection`

---

## ❌ Old way (ugly)

```java
URL url = new URL("https://api.com");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
```

---

## ✅ New way

```java
HttpClient client = HttpClient.newHttpClient();

HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.com"))
        .GET()
        .build();

HttpResponse<String> response =
        client.send(request, HttpResponse.BodyHandlers.ofString());

System.out.println(response.body());
```

---

## ⚡ Async version (very important)

```java
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenAccept(System.out::println);
```

---

## 💡 Real Use Cases

* Calling REST APIs
* Microservices communication
* Replacing RestTemplate (in many cases)

---

---

# 🧠 Impact on Coding Style

## Before (Java 8 mindset)

* Verbose classes
* instanceof + casting
* limited async support
* boilerplate everywhere

---

## After (Java 11–21 mindset)

* Records → less boilerplate
* Pattern matching → cleaner logic
* Sealed classes → safer design
* HTTP client → modern async calls
* Optional + streams + var → concise code

---

# 🔥 Combined Real Example (Modern Java)

```java
record User(String name, int age) {}

sealed interface Event permits LoginEvent, LogoutEvent {}

record LoginEvent(User user) implements Event {}
record LogoutEvent(User user) implements Event {}

static void handle(Event event) {
    switch (event) {
        case LoginEvent(var user) -> System.out.println(user.name() + " logged in");
        case LogoutEvent(var user) -> System.out.println(user.name() + " logged out");
    }
}
```

👉 This is **clean, type-safe, and future-proof**

---

# ⚠️ Where candidates go wrong

* Using `var` everywhere ❌
* Using records for mutable objects ❌
* Not understanding sealed class restrictions ❌
* Still writing `instanceof + cast` ❌

---

# 🚀 Interview One-Liner

> “Modern Java reduces boilerplate (records), improves type safety (sealed classes), simplifies control flow (pattern matching), and enhances async programming (HTTP client and CompletableFuture).”

---

# ⚡ If you want next

I can:

* Give **tricky Java 17/21 interview questions**
* Or convert your Spring Boot project into **modern Java style**
* Or give **before/after refactoring exercises (very useful for interviews)**
