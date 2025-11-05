package com.example;

import java.io.*;
import java.util.*;

/**
 * Comprehensive Java OOPs Concepts and Tricky Questions
 * 
 * This class demonstrates:
 * 1. Core OOPs Principles (Encapsulation, Inheritance, Polymorphism, Abstraction)
 * 2. Exception Handling (try-catch-finally)
 * 3. Tricky Interview Questions
 * 4. Advanced Java Concepts
 * 5. Common Pitfalls and Best Practices
 */
public class Oops {
    
    // Static variable - shared among all instances
    private static int staticCounter = 0;
    
    // Instance variable
    private int instanceCounter = 0;
    
    public static void main(String[] args) {
        System.out.println("🎯 Java OOPs Concepts and Tricky Questions Demo");
        System.out.println("=" .repeat(50));
        
        Oops demo = new Oops();
        
        // Run all demonstrations
        demo.demonstrateEncapsulation();
        demo.demonstrateInheritance();
        demo.demonstratePolymorphism();
        demo.demonstrateAbstraction();
        demo.demonstrateExceptionHandling();
        demo.demonstrateTrickyQuestions();
        demo.demonstrateStaticConcepts();
        demo.demonstrateStringTricks();
        demo.demonstrateCollectionTricks();
        
        System.out.println("\n🎉 Demo completed! Review the concepts above.");
    }
    
    // ========================================
    // 1. ENCAPSULATION DEMO
    // ========================================
    
    public void demonstrateEncapsulation() {
        System.out.println("\n🔒 ENCAPSULATION DEMO");
        System.out.println("-".repeat(30));
        
        BankAccount account = new BankAccount("John Doe", 1000.0);
        
        // Accessing through getter methods (encapsulation)
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: $" + account.getBalance());
        
        // Modifying through setter methods with validation
        account.deposit(500.0);
        System.out.println("After deposit of $500: $" + account.getBalance());
        
        account.withdraw(200.0);
        System.out.println("After withdrawal of $200: $" + account.getBalance());
        
        // Try invalid operation
        account.withdraw(2000.0); // Should fail due to insufficient funds
    }
    
    // ========================================
    // 2. INHERITANCE DEMO
    // ========================================
    
    public void demonstrateInheritance() {
        System.out.println("\n🌳 INHERITANCE DEMO");
        System.out.println("-".repeat(30));
        
        // Parent class reference
        Animal animal = new Animal("Generic Animal");
        animal.makeSound(); // Calls parent method
        
        // Child class objects
        Dog dog = new Dog("Buddy", "Golden Retriever");
        Cat cat = new Cat("Whiskers", "Persian");
        
        dog.makeSound(); // Overridden method
        dog.wagTail(); // Child-specific method
        
        cat.makeSound(); // Overridden method
        cat.purr(); // Child-specific method
        
        // Polymorphism in action - parent reference, child object
        Animal polymorphicDog = new Dog("Max", "Labrador");
        polymorphicDog.makeSound(); // Calls Dog's overridden method
        
        // Tricky Question: What happens here?
        System.out.println("\n❓ Tricky: Parent reference to child object");
        // polymorphicDog.wagTail(); // This would cause compile error!
        // Need to cast: ((Dog) polymorphicDog).wagTail();
    }
    
    // ========================================
    // 3. POLYMORPHISM DEMO
    // ========================================
    
    public void demonstratePolymorphism() {
        System.out.println("\n🎭 POLYMORPHISM DEMO");
        System.out.println("-".repeat(30));
        
        // Method Overloading (Compile-time polymorphism)
        Calculator calc = new Calculator();
        System.out.println("Method Overloading:");
        System.out.println("add(5, 3) = " + calc.add(5, 3));
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));
        
        // Method Overriding (Runtime polymorphism)
        System.out.println("\nMethod Overriding:");
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0)
        };
        
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + 
                             " Area: " + shape.calculateArea());
        }
    }
    
    // ========================================
    // 4. ABSTRACTION DEMO
    // ========================================
    
    public void demonstrateAbstraction() {
        System.out.println("\n🎨 ABSTRACTION DEMO");
        System.out.println("-".repeat(30));
        
        // Abstract class implementation
        Vehicle car = new Car("Toyota", "Camry");
        Vehicle bike = new Bike("Honda", "CBR");
        
        car.startEngine();
        car.stopEngine();
        car.displayInfo();
        
        bike.startEngine();
        bike.stopEngine();
        bike.displayInfo();
        
        // Interface implementation
        Drawable circle = new DrawableCircle();
        Drawable square = new DrawableSquare();
        
        circle.draw();
        square.draw();
    }
    
    // ========================================
    // 5. EXCEPTION HANDLING DEMO (TRY-CATCH-FINALLY)
    // ========================================
    
    public void demonstrateExceptionHandling() {
        System.out.println("\n⚠️  EXCEPTION HANDLING DEMO");
        System.out.println("-".repeat(30));
        
        // Basic try-catch-finally
        demonstrateBasicException();
        
        // Multiple catch blocks
        demonstrateMultipleCatch();
        
        // Finally block execution
        demonstrateFinallyBlock();
        
        // Try-with-resources
        demonstrateTryWithResources();
        
        // Custom exceptions
        demonstrateCustomException();
        
        // Tricky exception scenarios
        demonstrateExceptionTricks();
    }
    
    private void demonstrateBasicException() {
        System.out.println("\n1️⃣ Basic Try-Catch-Finally:");
        
        try {
            int result = 10 / 0; // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("✅ Finally block always executes");
        }
    }
    
    private void demonstrateMultipleCatch() {
        System.out.println("\n2️⃣ Multiple Catch Blocks:");
        
        try {
            int[] arr = {1, 2, 3};
            System.out.println("Array element: " + arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Array index out of bounds: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ General exception: " + e.getMessage());
        } finally {
            System.out.println("✅ Cleanup completed");
        }
    }
    
    private void demonstrateFinallyBlock() {
        System.out.println("\n3️⃣ Finally Block Execution:");
        
        // Case 1: Exception thrown and caught
        try {
            String str = null;
            @SuppressWarnings("null")
            int length = str.length(); // Intentional NullPointerException
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("❌ Null pointer exception caught");
            return; // Even with return, finally executes!
        } finally {
            System.out.println("✅ Finally executes even with return!");
        }
    }
    
    private void demonstrateTryWithResources() {
        System.out.println("\n4️⃣ Try-with-Resources:");
        
        // Automatic resource management
        try (BufferedReader reader = new BufferedReader(
                new StringReader("Hello\nWorld\nJava"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        } catch (IOException e) {
            System.out.println("❌ IO Exception: " + e.getMessage());
        }
        // BufferedReader automatically closed
        System.out.println("✅ Resources auto-closed");
    }
    
    private void demonstrateCustomException() {
        System.out.println("\n5️⃣ Custom Exception:");
        
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("❌ Custom Exception: " + e.getMessage());
        }
    }
    
    private void demonstrateExceptionTricks() {
        System.out.println("\n6️⃣ Tricky Exception Scenarios:");
        
        // Tricky Question 1: Finally vs Return
        System.out.println("finallyVsReturn() result: " + finallyVsReturn());
        
        // Tricky Question 2: Exception in finally
        System.out.println("exceptionInFinally() result: " + exceptionInFinally());
        
        // Tricky Question 3: Multiple exceptions
        demonstrateMultipleExceptions();
    }
    
    // ========================================
    // 6. TRICKY QUESTIONS DEMO
    // ========================================
    
    public void demonstrateTrickyQuestions() {
        System.out.println("\n🧩 TRICKY INTERVIEW QUESTIONS");
        System.out.println("-".repeat(30));
        
        // Question 1: String immutability
        demonstrateStringImmutability();
        
        // Question 2: Static vs Instance
        demonstrateStaticVsInstance();
        
        // Question 3: Method hiding vs overriding
        demonstrateMethodHiding();
        
        // Question 4: Constructor chaining
        demonstrateConstructorChaining();
        
        // Question 5: Autoboxing/Unboxing
        demonstrateAutoboxing();
    }
    
    private void demonstrateStringImmutability() {
        System.out.println("\n❓ String Immutability Trick:");
        
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        
        System.out.println("str1 == str2: " + (str1 == str2)); // true (string pool)
        System.out.println("str1 == str3: " + (str1 == str3)); // false (different objects)
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true (content)
        
        // Immutability demonstration
        String original = "Java";
        String modified = original.concat(" Programming");
        System.out.println("Original: " + original); // Still "Java"
        System.out.println("Modified: " + modified); // "Java Programming"
    }
    
    private void demonstrateStaticVsInstance() {
        System.out.println("\n❓ Static vs Instance Variables:");
        
        Oops obj1 = new Oops();
        Oops obj2 = new Oops();
        
        obj1.incrementCounters();
        obj2.incrementCounters();
        
        System.out.println("obj1 - Static: " + staticCounter + ", Instance: " + obj1.instanceCounter);
        System.out.println("obj2 - Static: " + staticCounter + ", Instance: " + obj2.instanceCounter);
    }
    
    private void demonstrateMethodHiding() {
        System.out.println("\n❓ Method Hiding vs Overriding:");
        
        Parent parent = new Child();
        
        parent.instanceMethod(); // Overriding - Child's method called
        Parent.staticMethod(); // Hiding - Parent's method called (proper static access)
        
        @SuppressWarnings("unused")
        Child child = new Child();
        Child.staticMethod(); // Child's static method (proper static access)
    }
    
    private void demonstrateConstructorChaining() {
        System.out.println("\n❓ Constructor Chaining:");
        
        @SuppressWarnings("unused")
        ChildClass child = new ChildClass("Test", 25);
        // Observe the constructor call sequence
    }
    
    private void demonstrateAutoboxing() {
        System.out.println("\n❓ Autoboxing/Unboxing Tricks:");
        
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        
        System.out.println("a == b (127): " + (a == b)); // true (cache)
        System.out.println("c == d (128): " + (c == d)); // false (no cache)
        
        @SuppressWarnings("deprecation")
        Integer x = new Integer(127); // Intentionally using deprecated constructor for demo
        @SuppressWarnings("deprecation")
        Integer y = new Integer(127); // Intentionally using deprecated constructor for demo
        System.out.println("new Integer(127) == new Integer(127): " + (x == y)); // false
    }
    
    // ========================================
    // 7. STATIC CONCEPTS DEMO
    // ========================================
    
    public void demonstrateStaticConcepts() {
        System.out.println("\n🔧 STATIC CONCEPTS");
        System.out.println("-".repeat(30));
        
        // Static block execution
        StaticDemo.displayMessage();
        
        // Static method access
        int result = MathUtils.add(10, 20);
        System.out.println("Static method result: " + result);
        
        // Static vs non-static context
        // staticMethod(); // Can call from non-static context
        // But non-static method cannot be called from static context without object
    }
    
    // ========================================
    // 8. STRING MANIPULATION TRICKS
    // ========================================
    
    public void demonstrateStringTricks() {
        System.out.println("\n📝 STRING MANIPULATION TRICKS");
        System.out.println("-".repeat(30));
        
        // String vs StringBuilder vs StringBuffer
        demonstrateStringPerformance();
        
        // String formatting tricks
        demonstrateStringFormatting();
    }
    
    private void demonstrateStringPerformance() {
        System.out.println("String Performance Comparison:");
        
        long start, end;
        
        // String concatenation (slow)
        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < 1000; i++) {
            str += i;
        }
        end = System.nanoTime();
        System.out.println("String concatenation time: " + (end - start) / 1000000 + "ms");
        
        // StringBuilder (fast)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        String result = sb.toString();
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) / 1000000 + "ms");
    }
    
    private void demonstrateStringFormatting() {
        System.out.println("\nString Formatting:");
        
        String name = "John";
        int age = 25;
        double salary = 50000.75;
        
        // Different formatting methods
        System.out.println(String.format("Name: %s, Age: %d, Salary: %.2f", name, age, salary));
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
        System.out.printf("Formatted: %s is %d years old and earns $%.2f%n", name, age, salary);
    }
    
    // ========================================
    // 9. COLLECTION FRAMEWORK TRICKS
    // ========================================
    
    public void demonstrateCollectionTricks() {
        System.out.println("\n📚 COLLECTION FRAMEWORK TRICKS");
        System.out.println("-".repeat(30));
        
        // ArrayList vs LinkedList
        demonstrateListPerformance();
        
        // HashMap tricks
        demonstrateHashMapTricks();
        
        // Set operations
        demonstrateSetOperations();
    }
    
    private void demonstrateListPerformance() {
        System.out.println("List Performance Comparison:");
        
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        // Add elements
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - start;
        
        System.out.println("ArrayList add time: " + arrayListTime / 1000000 + "ms");
        System.out.println("LinkedList add time: " + linkedListTime / 1000000 + "ms");
        
        // Access elements (ArrayList is faster for random access)
        start = System.nanoTime();
        int sum1 = 0;
        for (int i = 0; i < 1000; i++) {
            sum1 += arrayList.get(i);
        }
        long arrayAccessTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        int sum2 = 0;
        for (int i = 0; i < 1000; i++) {
            sum2 += linkedList.get(i);
        }
        long linkedAccessTime = System.nanoTime() - start;
        
        System.out.println("ArrayList access time: " + arrayAccessTime / 1000000 + "ms");
        System.out.println("LinkedList access time: " + linkedAccessTime / 1000000 + "ms");
    }
    
    private void demonstrateHashMapTricks() {
        System.out.println("\nHashMap Tricks:");
        
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 8);
        
        // Iteration methods
        System.out.println("Key-Value pairs:");
        map.forEach((key, value) -> System.out.println(key + " = " + value));
        
        // Null key and value
        map.put(null, 10); // HashMap allows one null key
        map.put("grape", null); // Multiple null values allowed
        
        System.out.println("Map with nulls: " + map);
    }
    
    private void demonstrateSetOperations() {
        System.out.println("\nSet Operations:");
        
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference: " + difference);
    }
    
    // ========================================
    // UTILITY METHODS FOR TRICKY SCENARIOS
    // ========================================
    
    private void incrementCounters() {
        staticCounter++;
        instanceCounter++;
    }
    
    private int finallyVsReturn() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3; // This overrides the return in try block!
        }
    }
    
    private String exceptionInFinally() {
        try {
            throw new RuntimeException("Exception in try");
        } finally {
            return "Finally executed"; // Suppresses the exception!
        }
    }
    
    private void demonstrateMultipleExceptions() {
        System.out.println("demonstrateMultipleExceptions() - First exception suppressed by second");
        try {
            try {
                throw new RuntimeException("First exception");
            } finally {
                throw new RuntimeException("Second exception"); // First exception is lost!
            }
        } catch (RuntimeException e) {
            System.out.println("❌ Caught: " + e.getMessage());
            System.out.println("⚠️  Note: First exception was suppressed by the second!");
        }
    }
    
    private void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative: " + age);
        }
    }
}

// ========================================
// SUPPORTING CLASSES FOR DEMONSTRATIONS
// ========================================

// Encapsulation Example
class BankAccount {
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: $" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn: $" + amount);
        } else {
            System.out.println("❌ Invalid withdrawal: insufficient funds or invalid amount");
        }
    }
}

// Inheritance Examples
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        System.out.println(name + " makes a generic animal sound");
    }
}

class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name); // Call parent constructor
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " the " + breed + " barks: Woof!");
    }
    
    public void wagTail() {
        System.out.println(name + " wags tail happily!");
    }
}

class Cat extends Animal {
    private String breed;
    
    public Cat(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " the " + breed + " meows: Meow!");
    }
    
    public void purr() {
        System.out.println(name + " purrs contentedly");
    }
}

// Polymorphism Examples
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base, height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Abstraction Examples
abstract class Vehicle {
    protected String brand, model;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    public abstract void startEngine();
    public abstract void stopEngine();
    
    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + model);
    }
}

class Car extends Vehicle {
    public Car(String brand, String model) {
        super(brand, model);
    }
    
    @Override
    public void startEngine() {
        System.out.println("Car engine started with key ignition");
    }
    
    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped");
    }
}

class Bike extends Vehicle {
    public Bike(String brand, String model) {
        super(brand, model);
    }
    
    @Override
    public void startEngine() {
        System.out.println("Bike engine started with kick/button");
    }
    
    @Override
    public void stopEngine() {
        System.out.println("Bike engine stopped");
    }
}

// Interface Example
interface Drawable {
    void draw();
}

class DrawableCircle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class DrawableSquare implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Static concepts
class StaticDemo {
    static {
        System.out.println("Static block executed");
    }
    
    public static void displayMessage() {
        System.out.println("Static method called");
    }
}

class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}

// Method hiding vs overriding
class Parent {
    public void instanceMethod() {
        System.out.println("Parent instance method");
    }
    
    public static void staticMethod() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    @Override
    public void instanceMethod() {
        System.out.println("Child instance method (overridden)");
    }
    
    public static void staticMethod() {
        System.out.println("Child static method (hidden)");
    }
}

// Constructor chaining
class ParentClass {
    public ParentClass() {
        System.out.println("Parent default constructor");
    }
    
    public ParentClass(String name) {
        System.out.println("Parent constructor with name: " + name);
    }
}

class ChildClass extends ParentClass {
    public ChildClass() {
        super(); // Calls parent default constructor
        System.out.println("Child default constructor");
    }
    
    public ChildClass(String name, int age) {
        super(name); // Calls parent constructor with parameter
        System.out.println("Child constructor with age: " + age);
    }
}
