// Creation
String str = "Hello";
String str2 = new String("World");

// Length
int len = str.length();

// Character access
char ch = str.charAt(1); // 'e'

// Substring
String sub = str.substring(1, 3); // "el"

// Concatenation
String combined = str.concat(" World"); // "Hello World"
String withPlus = str + " World"; // "Hello World"

// Case conversion
String upper = str.toUpperCase(); // "HELLO"
String lower = str.toLowerCase(); // "hello"

// Trimming
String trimmed = "  hello  ".trim(); // "hello"

// Replacement
String replaced = str.replace('l', 'p'); // "Heppo"
String regexReplaced = str.replaceAll("l", "p"); // "Heppo"

// Checking
boolean isEmpty = str.isEmpty(); // false
boolean equals = str.equals("Hello"); // true
boolean equalsIgnore = str.equalsIgnoreCase("HELLO"); // true

// Searching
int index = str.indexOf('l'); // 2
int lastIndex = str.lastIndexOf('l'); // 3
boolean contains = str.contains("ell"); // true
boolean starts = str.startsWith("He"); // true
boolean ends = str.endsWith("lo"); // true

// Splitting
String[] parts = "a,b,c".split(","); // ["a", "b", "c"]

// Joining (Java 8+)
String joined = String.join("-", "a", "b", "c"); // "a-b-c"

// Conversion
char[] chars = str.toCharArray(); // ['H','e','l','l','o']
String fromChars = new String(chars); // "Hello"
String valueOf = String.valueOf(123); // "123"

// Comparison
int compare = str.compareTo("Hello"); // 0 (equal)
int compareIgnore = str.compareToIgnoreCase("HELLO"); // 0

// Matching
boolean matches = str.matches("H.*o"); // true 

StringBuilder sb = new StringBuilder("Hello");

sb.append(" World"); // "Hello World"
sb.insert(5, ","); // "Hello, World"
sb.delete(5, 6); // "Hello World"
sb.deleteCharAt(5); // "Hell World"
sb.reverse(); // "dlroW olleH"
sb.replace(6, 11, "Java"); // "Hello Java"
int capacity = sb.capacity();
sb.setLength(5); // "Hello"

// Write a program to reverse a string without using StringBuilder reverse()

// Check if a string is a palindrome (reads same forwards and backwards)

// Count the number of vowels in a string

// Convert a string to title case (first letter of each word uppercase)

// Remove all whitespace from a string

// Find the most frequent character in a string

// Check if two strings are anagrams of each other

// Count occurrences of a specific character in a string

// Remove all duplicate characters from a string

// Convert a string to a comma-separated list of characters

    

