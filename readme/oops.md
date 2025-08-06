# Java OOPs (Object-Oriented Programming) - Notes

## 1. **What is Object-Oriented Programming (OOP)?**

Object-Oriented Programming is a paradigm in Java where software is designed by using objects.
Each object is an instance of a class and contains:

* **Properties (Data/Attributes)**
* **Methods (Functions/Behaviors)**

### Examples:

```java
class Calculator {
    int n1 = 5; // Property (attribute or field)

    public int add(int num1, int num2) { // Method (behavior)
        System.out.println("Adding the two values");
        return num1 + num2;
    }   
}
```

---

## 2. **Class and Object**

* A **class** is a blueprint or template.
* An **object** is an instance of a class.

### Example:

```java
class Dog {
    String breed;
    void bark() {
        System.out.println("Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // Object creation
        myDog.bark();          // Calling method
    }
}
```

---

## 3. **Key Components of a Class Declaration**

### `public`

* Access modifier.
* `public` means the method or class is accessible from anywhere.

### `class`

* Keyword used to declare a class.

### `void`

* Return type of the method.
* `void` means this method doesn't return anything.

### `static`

* It means the method belongs to the class rather than an instance of the class.
* `main` method must be static so the JVM can call it without creating an object.

### `main(String[] args)`

* Entry point of the program.
* `String[] args` is used to receive command line arguments.

---

## 4. **Fundamentals of Java in OOP**

### 1. **Encapsulation**

* Wrapping data and methods together in a single unit (class).
* You can make fields private and access them via getters/setters.

### 2. **Inheritance**

* Acquiring properties and behaviors from another class.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

### 3. **Polymorphism**

* One interface, many implementations.
* Method overloading and overriding are examples.

### 4. **Abstraction**

* Hiding internal details and showing only the functionality.
* Achieved using abstract classes or interfaces.

---

## 5. **Example with Explanation**

```java
class Calculator {
    int n1 = 5; // Field or Property

    public int add(int num1, int num2) { // Method
        System.out.println("Adding the two values");
        return num1 + num2;
    }
}

public class Orient {
    public static void main(String[] args) {
        int num1 = 9;
        int num2 = 11;

        Calculator calc = new Calculator(); // Creating object
        int result = calc.add(num1, num2);  // Calling method
        System.out.println(result);         // Output: 20
    }
}
```

### Explanation:

* `Calculator` is a class.
* `calc` is an object created using the `new` keyword.
* `add()` is a method inside `Calculator` class.
* `public static void main(String[] args)` is the entry point of the program.

---

## 6. **Benefits of OOP**

* Modular code
* Reusability via inheritance
* Scalability
* Easier troubleshooting
* Real-world modeling

---

Let me know if you'd like separate notes on each pillar (Encapsulation, Inheritance, Polymorphism, Abstraction) or access modifiers in detail!
