# Sorting Arrays in Java

In Java, we have different data types like Integer, Double, String. We can also have user-defined classes. 
In this article, we will go through different possibilities to sort an array of different types using `Array.sort()` method

In the below examples, I'm going to generate random set of data and apply `Arrays.sort()` method

## 1. Array of Integers

### Generating Integer array

```java
import java.util.Random;

int N = 30;
private Integer[] randomIntArray() {
    Integer[] randArr = new Integer[N];
    for (int i = 0; i < N; i++) {
        randArr[i] = random.nextInt(100);
    }
    return randArr;
}
```
### Displaying the array of any type
```java
private <T> void displayArray(T[] arr) {
    for (T t : arr) {
        System.out.print(t + " ");
    }
    System.out.println();
}
```
### Sorting the array
    
```java
// sort integer array

Integer[] toSortInt = randomIntArray();
Arrays.sort(toSortInt);
displayArray(toSortInt);


// sort integer array within a range

Integer[] toSortIntRange = randomIntArray();
Arrays.sort(toSortIntRange, 10, 20); // 10: fromIndex, 20: toIndex
displayArray(toSortIntRange);
```

## 2. Array of Strings
Let's sort an array of strings based on number of characters.

```java
Arrays.sort(T[] a, Comparator<? super T> c)
```
Here the 2nd parameter is a `Comparator` which is an interface.
We have to implement `compare` method. 
It says how you want to compare two elements in an array while sorting. 
For integer, it generally compares the value of the integer. 
For string, it is alphabetical order by default.

Since we want to sort based on number of characters in the string, we will override the `compare` the method such that it sorts based on the length of the string. 
`compare` method returns negative, 0 or positive. If it is negative or 0 the two elements are sorted, else the two elements are not sorted. 

### Generating String array
```java
private String randomString() {
    int strLen = random.nextInt(N);
    
    String salt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    StringBuilder s = new StringBuilder();
    for (int j = 0; j < strLen; j++) {
        s.append(salt.charAt(random.nextInt(salt.length())))
    }
    return s.toString();
}
    
private String[] randomStringArray() {
    String[] randArr = new String[N];
    for (int i = 0; i < N; i++) {
        randArr[i] = randomString();
    }
    return randArr;
}
```
### Sorting the array

```java
// sort string array using comparator based on length

String[] toSortString = randomStringArray();
Arrays.sort(toSortString, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
});
displayArray(toSortString);
```

We can replace `Comparator` functional interface with lambda expression from java 8

```java    
// sort string array in alphabetical order - using lambda instead of comparator
String[] toSortString2 = randomStringArray();
Arrays.sort(toSortString2, (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));
displayArray(toSortString2);
```
        
## 3. Array of Objects

Here we will use **Java 8** feature of `comparing` and `thenComparing`.

Let's say we have an Employee class as below
```java
class Employee {
    int age;
    String name;
    
    Employee(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

We have an array of Employee objects. 
```java
private Employee randomObject() {
    int age = random.nextInt(100);
    String name = randomString();
    return new Employee(age, name);
}

private Employee[] randomEmployeeArray() {
    Employee[] randArr = new Employee[N];
    for (int i = 0; i < N; i++) {
        randArr[i] = randomObject();
    }
    return randArr;
}
```

We want to sort based on age. If any two employees have equal age, sort based on alphabetical order.
We can chain the above conditions using `comparing` and `thenComparing` which take lambda function or method reference as a parameter which says what value to compare.

### Sorting the array

```java
Employee[] toSortEmployee = randomEmployeeArray();
Arrays.sort(toSortEmployee, Comparator.comparing(Employee::getAge).thenComparing(e -> e.getName().toLowerCase()));
displayArray(toSortEmployee);
```

## Summary

```java
Arrays.sort(toSortInt);
Arrays.sort(toSortIntRange, 10, 20);

// using comparator
Arrays.sort(toSortString, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
});

// using lambda expression
Arrays.sort(toSortString2, (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));

// using comparing and thenComparing to chain multiple conditions
Arrays.sort(toSortEmployee, Comparator.comparing(Employee::getAge)
        .thenComparing(e -> e.getName().toLowerCase()));
```
