🔥 Excellent question, bro — this is *exactly* how you level up your **LeetCode Math problems** game in Java.

When it comes to **Math-based LeetCode** (number theory, digits, primes, modular arithmetic, etc.), there are **core Java utilities, methods, and mental shortcuts** that save huge time.

Let’s break it down in a **structured + practical way** 👇

---

## 🧮 1. Java Classes You Must Know

| Class                            | Why It’s Useful                                           |
| -------------------------------- | --------------------------------------------------------- |
| `Math`                           | Core math operations (abs, pow, sqrt, floor, ceil, etc.)  |
| `BigInteger`                     | For very large numbers beyond `long`                      |
| `Random`                         | For generating random numbers (for probabilistic logic)   |
| `Arrays`                         | Sorting, binary search, min/max                           |
| `Collections`                    | For operations on lists (min, max, sort)                  |
| `StringBuilder` / `StringBuffer` | For manipulating number-to-string conversions             |
| `Character`                      | For digit/char conversions (`isDigit`, `getNumericValue`) |

---

## ⚙️ 2. 🔥 Common `Math` Methods You’ll Use Constantly

| Method                            | Description                    | Example                         |
| --------------------------------- | ------------------------------ | ------------------------------- |
| `Math.abs(x)`                     | Absolute value                 | `Math.abs(-5) → 5`              |
| `Math.max(a,b)` / `Math.min(a,b)` | Compare numbers                | `Math.max(10, 15) → 15`         |
| `Math.pow(a,b)`                   | Power function                 | `Math.pow(2, 3) → 8.0`          |
| `Math.sqrt(x)`                    | Square root                    | `Math.sqrt(9) → 3.0`            |
| `Math.cbrt(x)`                    | Cube root                      | `Math.cbrt(27) → 3.0`           |
| `Math.floor(x)`                   | Round down                     | `Math.floor(3.9) → 3.0`         |
| `Math.ceil(x)`                    | Round up                       | `Math.ceil(3.1) → 4.0`          |
| `Math.round(x)`                   | Normal rounding                | `Math.round(3.6) → 4`           |
| `Math.log(x)` / `Math.log10(x)`   | Logarithm (natural or base 10) | `Math.log10(100) → 2`           |
| `Math.exp(x)`                     | eˣ                             | `Math.exp(1) → 2.718...`        |
| `Math.random()`                   | Random 0.0–1.0                 | `Math.random()*10 → 0–10 range` |
| `Math.signum(x)`                  | Returns -1, 0, or 1            | `Math.signum(-45) → -1`         |

> 💡 Note: `Math.pow()` and `Math.sqrt()` return `double`,
> so sometimes cast back to `int`.

---

## 💪 3. Important Integer Operations

### ➤ Modulo arithmetic

```java
int mod = 1_000_000_007;
long ans = (a % mod * b % mod) % mod;
```

Used often in LeetCode for overflow-safe multiplication or sum.

---

### ➤ GCD and LCM

```java
int gcd = Integer.gcd(a, b);   // Java 18+
int lcm = a * b / gcd;
```

or manually:

```java
int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
```

---

### ➤ Digit manipulation

```java
int sumDigits(int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;  // get last digit
        n /= 10;        // remove last digit
    }
    return sum;
}
```

---

### ➤ Reverse a number

```java
int rev = 0;
while (n != 0) {
    rev = rev * 10 + n % 10;
    n /= 10;
}
```

---

### ➤ Count digits

```java
int count = (int) Math.log10(n) + 1;
```

or loop-based.

---

### ➤ Convert digit to char / char to digit

```java
char ch = (char) ('0' + digit);
int digit = ch - '0';
```

---

## 🚀 4. Big Numbers (`BigInteger`)

Use `BigInteger` when numbers exceed `long` (e.g. factorials, large sums).

```java
import java.math.BigInteger;

BigInteger a = new BigInteger("12345678901234567890");
BigInteger b = BigInteger.valueOf(5);
BigInteger sum = a.add(b);
BigInteger pow = a.pow(3);
BigInteger mod = a.mod(BigInteger.valueOf(1000));
```

| Method                                 | Description        |
| -------------------------------------- | ------------------ |
| `.add()`, `.subtract()`, `.multiply()` | Basic arithmetic   |
| `.divide()`, `.mod()`                  | Division/modulo    |
| `.pow(n)`                              | Power              |
| `.gcd()`                               | GCD                |
| `.compareTo()`                         | Compare like `int` |
| `.equals()`                            | Compare equality   |

---

## 🧠 5. Key Concepts / Tips to Remember

1. **Always check overflow**

    * `int` max: 2,147,483,647
    * `long` max: 9,223,372,036,854,775,807
      → Use `long` for multiplications or summations.

2. **Modular arithmetic rules:**

   ```
   (a + b) % m = ((a % m) + (b % m)) % m
   (a * b) % m = ((a % m) * (b % m)) % m
   ```

3. **Prefer integer division when you need floor**

    * `5 / 2 = 2` ✅
    * `5 / 2.0 = 2.5` ❌ (double)

4. **Use fast exponentiation (binary power)**
   Instead of `Math.pow(a,b)` in modular cases:

   ```java
   long power(long a, long b, long mod) {
       long res = 1;
       while (b > 0) {
           if ((b & 1) == 1) res = (res * a) % mod;
           a = (a * a) % mod;
           b >>= 1;
       }
       return res;
   }
   ```

5. **Use `Math.sqrt()` for perfect square checks**

   ```java
   int x = (int) Math.sqrt(num);
   if (x * x == num) System.out.println("Perfect Square");
   ```

6. **Bit tricks**

    * `n & 1` → check odd/even
    * `n >> 1` → divide by 2
    * `n << 1` → multiply by 2
    * `n & (n - 1)` → remove last set bit
    * `(n & (n - 1)) == 0` → power of two check

7. **For combinatorics / factorial**

   ```java
   BigInteger fact = BigInteger.ONE;
   for(int i = 1; i <= n; i++)
       fact = fact.multiply(BigInteger.valueOf(i));
   ```

---

## 📚 6. Bonus Utility Methods You Can Reuse

```java
boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

int sumOfDigits(int n) { ... }
int reverseNum(int n) { ... }
int gcd(int a, int b) { ... }
boolean isPalindrome(int n) { return n == reverseNum(n); }
```

---

## 🧩 7. String <-> Number Quick Ops

| Operation                 | Example   | Result        |
| ------------------------- | --------- | ------------- |
| `String.valueOf(123)`     | → `"123"` | int → String  |
| `Integer.parseInt("456")` | → `456`   | String → int  |
| `"123".charAt(0) - '0'`   | → `1`     | char to digit |
| `(char)(3 + '0')`         | → `'3'`   | digit to char |

---

If you want, I can make a **LeetCode Math “Cheat Sheet” PDF**
📘 with these methods, formulas, and snippets — clean layout, ready to refer while solving.
Would you like that?
