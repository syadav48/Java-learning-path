Good—`Optional` is one of those APIs people *use*, but don’t really understand deeply. Let’s go beyond basics and cover **all commonly used methods + when to actually use them (and when NOT to)**.

---

# 🧠 1) What is `Optional`?

`Optional<T>` is a container that may or may not contain a value.

👉 Instead of:

```java
String name = null;
```

👉 You use:

```java
Optional<String> name = Optional.empty();
```

---

# 🔹 2) Creating Optional

## ✅ `of()`

```java
Optional<String> opt = Optional.of("Ravi");
```

⚠️ Throws `NullPointerException` if null

---

## ✅ `ofNullable()`

```java
Optional<String> opt = Optional.ofNullable(null);
```

👉 Safe version

---

## ✅ `empty()`

```java
Optional<String> opt = Optional.empty();
```

---

# 🔍 3) Checking Value

## ✅ `isPresent()`

```java
if (opt.isPresent()) {
    System.out.println(opt.get());
}
```

⚠️ Old style, not recommended much now

---

## ✅ `isEmpty()` (Java 11+)

```java
if (opt.isEmpty()) {
    System.out.println("No value");
}
```

---

# ⚠️ 4) Getting Value (Danger Zone)

## ❌ `get()`

```java
opt.get();
```

👉 Throws `NoSuchElementException` if empty
👉 Avoid in production

---

# ✅ 5) Safe Retrieval

## `orElse()`

```java
String name = opt.orElse("Default");
```

⚠️ Always evaluates default value

---

## `orElseGet()`

```java
String name = opt.orElseGet(() -> getDefault());
```

👉 Lazy execution (better)

---

## `orElseThrow()`

```java
String name = opt.orElseThrow(() -> new RuntimeException("Not found"));
```

---

# 🔄 6) Transformations

## `map()`

```java
Optional<String> name = Optional.of("ravi");

Optional<String> upper = name.map(String::toUpperCase);
```

👉 Runs only if value present

---

## `flatMap()` (important)

```java
Optional<User> user = getUser();

Optional<String> email =
    user.flatMap(User::getEmailOptional);
```

👉 Avoids nested Optional:

```text
Optional<Optional<String>> ❌
```

---

## `filter()`

```java
Optional<Integer> num = Optional.of(10);

Optional<Integer> result =
    num.filter(n -> n > 5);
```

👉 Keeps value only if condition passes

---

# ⚡ 7) Action-based Methods

## `ifPresent()`

```java
opt.ifPresent(val -> System.out.println(val));
```

---

## `ifPresentOrElse()` (Java 9+)

```java
opt.ifPresentOrElse(
    val -> System.out.println(val),
    () -> System.out.println("Empty")
);
```

---

# 🔗 8) Chaining (Real Power)

```java
String email = Optional.ofNullable(user)
    .map(User::getProfile)
    .map(Profile::getEmail)
    .orElse("default@mail.com");
```

👉 Replaces multiple null checks

---

# 🔥 9) Practical Use Cases

## 🧾 1. Avoid Null Checks

```java
if (user != null && user.getEmail() != null)
```

👉 becomes:

```java
Optional.ofNullable(user)
    .map(User::getEmail)
```

---

## 🏦 2. Repository Layer (Very common)

```java
Optional<User> user = userRepository.findById(id);
```

👉 Forces caller to handle absence

---

## 🌐 3. API Response Handling

```java
return Optional.ofNullable(response.getData());
```

---

## ⚙️ 4. Configuration values

```java
Optional<String> config = getConfig("timeout");
```

---

## 🧩 5. Stream + Optional

```java
Optional<Integer> max =
    list.stream().max(Integer::compare);
```

---

# ⚠️ 10) When NOT to use Optional

This is where most people mess up.

---

## ❌ As field in class

```java
class User {
    Optional<String> name; ❌
}
```

👉 Bad practice

---

## ❌ Method parameter

```java
void process(Optional<String> name) ❌
```

👉 Just pass value or null

---

## ❌ Serialization (DTOs)

Optional is not meant for:

* Entities
* DTOs

---

# 🧠 11) Subtle Difference (Interview Trap)

## `orElse()` vs `orElseGet()`

```java
opt.orElse(expensiveCall());   // always runs ❌
opt.orElseGet(() -> expensiveCall()); // lazy ✅
```

---

# 🔥 12) Real-world Example

```java
public String getUserEmail(Long id) {
    return userRepository.findById(id)
        .map(User::getEmail)
        .filter(email -> email.contains("@"))
        .orElseThrow(() -> new RuntimeException("Invalid user"));
}
```

---

# 🧠 Final Summary

| Method         | Purpose                |
| -------------- | ---------------------- |
| `of()`         | Create (non-null only) |
| `ofNullable()` | Safe creation          |
| `isPresent()`  | Check value            |
| `get()`        | Unsafe access          |
| `orElse()`     | Default value          |
| `orElseGet()`  | Lazy default           |
| `map()`        | Transform              |
| `flatMap()`    | Avoid nested Optional  |
| `filter()`     | Condition check        |
| `ifPresent()`  | Execute if present     |

---

# 🚀 Interview One-Liner

> "`Optional` helps avoid null checks by forcing explicit handling of absent values, and supports functional-style transformations like map, flatMap, and filter."

---

# ⚡ If you want next level

I can:

* Give **tricky Optional interview questions (nested, streams, pitfalls)**
* Or combine **Optional + Streams + Collectors (very common in client rounds)**
