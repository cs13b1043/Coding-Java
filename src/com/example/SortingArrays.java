package com.example;

import java.util.*;

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

class SortingArrays {
    private int N;
    private Random random;
    private String salt;

    SortingArrays() {
        N = 30;
        random = new Random();
        salt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    private <T> void displayArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private String randomString() {
        StringBuilder s = new StringBuilder();
        int strLen = random.nextInt(N);
        for(int j=0; j<strLen; j++) {
            s.append(salt.charAt(random.nextInt(salt.length())));
        }
        return s.toString();
    }

    private Employee randomObject() {
        int age = random.nextInt(100);
        String name = randomString();
        return new Employee(age, name);
    }

    private Integer[] randomIntArray() {
        Integer[] randArr = new Integer[N];
        for(int i=0; i<N; i++) {
            randArr[i] = random.nextInt(100);
        }
        return randArr;
    }

    private String[] randomStringArray() {
        String[] randArr = new String[N];
        for(int i=0; i<N; i++) {
            randArr[i] = randomString();
        }
        return randArr;
    }

    private Employee[] randomEmployeeArray() {
        Employee[] randArr = new Employee[N];
        for(int i=0; i<N; i++) {
            randArr[i] = randomObject();
        }
        return randArr;
    }

    void execute() {
        // sort integer array
        Integer[] toSortInt = randomIntArray();
        Arrays.sort(toSortInt);
        displayArray(toSortInt);

        // sort integer array within a range
        Integer[] toSortIntRange = randomIntArray();
        Arrays.sort(toSortIntRange, 10, 20);
        displayArray(toSortIntRange);

        // sort string array using comparator based on length
        String[] toSortString = randomStringArray();
        Arrays.sort(toSortString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        displayArray(toSortString);

        // sort string array lexicographic - using lambda instead of comparator
        String[] toSortString2 = randomStringArray();
        Arrays.sort(toSortString2, (s1,s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));
        displayArray(toSortString2);

        // sort array of objects
        Employee[] toSortEmployee = randomEmployeeArray();
        Arrays.sort(toSortEmployee, Comparator.comparing(Employee::getAge)
                .thenComparing(e -> e.getName().toLowerCase()));
        displayArray(toSortEmployee);
    }
}
