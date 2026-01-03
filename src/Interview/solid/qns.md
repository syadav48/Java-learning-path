Got it 👍
Below are **5 build-oriented questions**, **strictly using Core Java only**
(**class, interface, abstract class, collections, streams, generics**).
No Spring, no frameworks, no annotations.

Each question is crafted so that **if you design it correctly, the SOLID principle becomes obvious**.

---

# SOLID – Core Java–Only Design Questions

---

## 1️⃣ **Single Responsibility Principle (SRP)**

### 🛠️ Question:

**Design a Student Result Processing System**

### Requirements:

* Read student marks from a `List<Integer>`
* Calculate total & average
* Decide pass/fail
* Print result to console
* Save result in a `Map<StudentId, Result>`

### Constraints:

* Use only:

    * `class`
    * `List`, `Map`
    * No frameworks

### Design Goal:

👉 Ensure **each class has exactly one responsibility**.

### Hint:

* One class for calculation
* One class for result decision
* One class for printing
* One class for storage

📌 If **printing logic changes**, calculation code **must not change**.

---

## 2️⃣ **Open / Closed Principle (OCP)**

### 🛠️ Question:

**Design a Shape Area Calculator**

### Requirements:

* Calculate area of:

    * Circle
    * Rectangle
    * Triangle
* Later add:

    * Square
    * Ellipse

### Constraints:

* ❌ No `if-else`
* ❌ No `switch`
* Use:

    * `interface`
    * `abstract method`
    * `List<Shape>`

### Design Goal:

👉 Add new shapes **without modifying** area calculation logic.

### Hint:

* `Shape` interface with `calculateArea()`
* Loop over `List<Shape>`

📌 If a new shape comes, **no existing class should change**.

---

## 3️⃣ **Liskov Substitution Principle (LSP)**

### 🛠️ Question:

**Design a Banking Account System**

### Requirements:

* Account types:

    * `SavingsAccount`
    * `CurrentAccount`
    * `FixedDepositAccount`
* Operations:

    * `deposit()`
    * `withdraw()`

### Tricky Case:

* Fixed Deposit **cannot withdraw before maturity**

### Constraints:

* Use:

    * `abstract class`
    * Method overriding
* Client code should work with:

  ```java
  Account account;
  ```

### Design Goal:

👉 Any subclass should be usable **without breaking behavior**.

### Hint:

* Think carefully where `withdraw()` belongs
* Avoid throwing exceptions in child classes

📌 If `withdraw()` breaks for FD → **LSP violation**.

---

## 4️⃣ **Interface Segregation Principle (ISP)**

### 🛠️ Question:

**Design a Media Player System**

### Requirements:

* AudioPlayer → play audio
* VideoPlayer → play video
* LiveStreamPlayer → stream live
* AdvancedPlayer → all features

### Constraints:

* Use:

    * Multiple interfaces
    * `implements`
* ❌ No class should implement unused methods

### Design Goal:

👉 Classes implement **only what they need**.

### Hint:

* Split interfaces based on behavior
* Compose functionality using multiple interfaces

📌 If a class has empty methods → **ISP violation**.

---

## 5️⃣ **Dependency Inversion Principle (DIP)**

### 🛠️ Question:

**Design a Report Generator**

### Requirements:

* Generate report from a `List<Employee>`
* Output formats:

    * Console
    * File
    * In-memory String (for testing)

### Constraints:

* Use:

    * `interface`
    * `constructor injection`
* ❌ No `new ConsoleReport()` inside main logic

### Design Goal:

👉 High-level report logic **must not depend on concrete output classes**.

### Hint:

* `ReportWriter` interface
* Inject implementation into constructor

📌 Changing output type should **not change** report generator.

---

# 🧠 How to Practice (Very Important)

For **each question**:

1. First write **bad code**
2. Notice where:

    * `if-else` grows
    * Exceptions appear in child classes
    * Classes do too many things
3. Refactor using **only core Java**
4. Explain:

   > “If X changes, Y class changes — others don’t”

---

# 🎯 Interview Confidence Booster

If you can:

* Solve **any 2 of these cleanly**
* Explain **why your design is safe**

You’re already at **mid–senior LLD level**.

---

If you want next:

* I can **solve one fully with code**
* Or **review your solution**
* Or convert these into **LLD interview answers**

Tell me **which principle you want to start coding first** 👌
