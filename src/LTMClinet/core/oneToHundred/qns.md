Great focus—this is exactly how you should prepare 👍  
Below are **100 Java Core interview questions** split across **scenario-based, output-based, and coding-based**, covering:

*   Constructors
*   `this`, `super`
*   OOP (Encapsulation, Inheritance, Polymorphism, Abstraction)
*   Method overloading/overriding
*   Access modifiers
*   Initialization blocks
*   Static / final / etc.

❌ No theory-only questions  
✅ All are **practical / thinking / output / coding**

***

# 🔥 PART 1: OUTPUT-BASED QUESTIONS (1–35)

### Constructors & Initialization

1.

```java
class A {
    A() {
        System.out.println("A");
    }
}
class B extends A {
    B() {
        System.out.println("B");
    }
}
public class Test {
    public static void main(String[] args) {
        new B();
    }
}
```

2.

```java
class Test {
    Test() {
        this(10);
        System.out.println("Default");
    }
    Test(int x) {
        System.out.println("Param");
    }
    public static void main(String[] args) {
        new Test();
    }
}
```

3.

```java
class Test {
    static {
        System.out.println("Static");
    }
    {
        System.out.println("Instance");
    }
    Test() {
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        new Test();
    }
}
```

4.

```java
class Test {
    int x = 10;
    Test() {
        System.out.println(x);
    }
    public static void main(String[] args) {
        new Test();
    }
}
```

5.

```java
class Test {
    int x = 10;
    {
        x = 20;
    }
    Test() {
        x = 30;
    }
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.x);
    }
}
```

***

### this & super

6.

```java
class A {
    int x = 10;
}
class B extends A {
    int x = 20;
    void print() {
        System.out.println(x);
        System.out.println(super.x);
    }
}
```

7.

```java
class Test {
    int x;
    Test(int x) {
        x = x;
    }
    public static void main(String[] args) {
        Test t = new Test(100);
        System.out.println(t.x);
    }
}
```

8.

```java
class Test {
    int x;
    Test(int x) {
        this.x = x;
    }
}
```

9.

```java
class A {
    A() {
        System.out.println("A");
    }
}
class B extends A {
    B() {
        super();
        System.out.println("B");
    }
}
```

***

### Method Overloading/Overriding

10.

```java
class Test {
    void method(int a) {
        System.out.println("int");
    }
    void method(Integer a) {
        System.out.println("Integer");
    }
    public static void main(String[] args) {
        new Test().method(10);
    }
}
```

11.

```java
class A {
    void show() {
        System.out.println("A");
    }
}
class B extends A {
    void show() {
        System.out.println("B");
    }
}
```

12.

```java
class A {
    void show(int a) {}
}
class B extends A {
    void show(double a) {}
}
```

***

### Polymorphism & Casting

13.

```java
class A {
    void show() { System.out.println("A"); }
}
class B extends A {
    void show() { System.out.println("B"); }
}
public class Test {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();
    }
}
```

14.

```java
A obj = new A();
B b = (B) obj;
```

15.

```java
A obj = new B();
B b = (B) obj;
```

***

### Static Behavior

16.

```java
class Test {
    static int x = 10;
    static {
        x = 20;
    }
    public static void main(String[] args) {
        System.out.println(x);
    }
}
```

17.

```java
class Test {
    static void show() {
        System.out.println("Static");
    }
    void show(int x) {
        System.out.println("Instance");
    }
}
```

***

### Final & Immutability

18.

```java
final class A {}
class B extends A {}
```

19.

```java
class Test {
    final int x;
    Test() {
        x = 10;
    }
}
```

***

### More Output Cases

(Keeping concise to fit 100)

20–35: Predict output for:

*   constructor chaining (`this()` & `super()`)
*   variable shadowing
*   static vs instance call
*   private constructor usage
*   calling overridden method from constructor
*   ordering: static → instance → constructor
*   abstract method calls from subclass object
*   field vs method resolution difference
*   null method invocation

***

# ⚡ PART 2: SCENARIO-BASED QUESTIONS (36–70)

36. You create a class with only parameterized constructor. What happens when you do `new Class()`?

37. You override a method and reduce visibility → what happens?

38. Parent constructor calls overridden method—what executes?

39. Can `this()` and `super()` be used together? Why?

40. You make method `static` in child that was non-static in parent. Result?

41. You overload method using `int` and `long` → call with `10`?

42. Same but `double`?

43. You use method overloading with same params but different return type → compile?

44. Class has private constructor → how to create object?

45. You mark class abstract but give all methods implemented—can you instantiate?

46. Runtime: parent reference child object → which method runs?

47. Overriding with checked exception broader than parent → allowed?

48. What happens if constructor throws exception?

49. Create object inside static block → when runs?

50. Calling static method using null reference—what happens?

51. Instance method using null reference?

52. Two classes have same method but no inheritance → polymorphic call?

53. Final variable not initialized → compile?

54. Final method overridden?

55. Method overloaded with varargs vs exact match—priority?

56. Abstract class with constructor → is it used?

57. Interface method implemented in subclass → runtime dispatch?

58. Calling super constructor explicitly vs implicitly?

59. Diamond problem in Java? (scenario)

60–70:

*   field hiding vs method overriding
*   using `this` in static context
*   recursive constructor chaining
*   implicit super() insertion
*   calling overridden method from constructor
*   multiple levels inheritance constructor order
*   edge cases of casting
*   runtime vs compile time binding scenarios

***

# 💻 PART 3: CODING QUESTIONS (71–100)

### Constructors & this/super

71. Write a class with constructor chaining using `this()`.

72. Create parent-child constructor chain printing order.

73. Demonstrate variable shadowing and fix using `this`.

74. Create class where constructor calls another method.

***

### OOP Coding

75. Implement encapsulation: private field + getter/setter with validation.

76. Create class hierarchy: Animal → Dog → Puppy, show overriding.

77. Implement runtime polymorphism using shape drawing.

78. Create abstract class Shape with area method.

79. Demonstrate method overloading for sum of numbers.

***

### Real Scenarios

80. Create immutable class.

81. Design class with private constructor + static factory method.

82. Implement Singleton (lazy initialization).

83. Implement Singleton (eager initialization).

***

### Edge Coding

84. Create class with static and instance blocks → print order.

85. Demonstrate method overriding vs field hiding.

86. Create example of constructor throwing exception.

***

### Practical Problems

87. Write class to validate age in setter.

88. Create Employee class with constructor overloading.

89. Implement copy constructor manually.

90. Demonstrate deep vs shallow copy.

***

### Advanced Thinking

91. Write program showing method resolution priority.

92. Create class where parent reference calls child method.

93. Demonstrate safe and unsafe casting.

94. Show calling static method with class and object.

95. Demonstrate use of `super.method()` in overridden method.

***

### Trick Questions

96. Write class where constructor calls overridden method → observe output.

97. Create class with private constructor and try extending.

98. Write code that compiles but fails at runtime (casting issue).

99. Show difference between `this` and `super` in variables.

100.    Create multi-level inheritance showing constructor order.

***

# ✅ How to Use This List (Important)

👉 Do NOT just read—**practice like this:**

1.  Predict output first
2.  Write down reasoning
3.  Run code
4.  Note mistakes

👉 In 2 days:

*   Day 1 → Output + scenarios
*   Day 2 → Coding questions

***

If you want next step 🔥  
I can:

*   ✅ Give **answers + explanations (top 50 most important)**
*   ✅ Take **mock interview**
*   ✅ Convert this into **PDF cheat sheet**
*   ✅ Give **top frequently asked patterns only**

Just tell me 👍
