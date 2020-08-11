package com.example;

import com.example.model.Employee;
import com.example.utils.CommonUtils;

import java.util.*;

class SortingArrays {
    private int N;
    private Random random;

    SortingArrays() {
        N = 30;
        random = new Random();
    }

    private Integer[] randomIntArray() {
        Integer[] randArr = new Integer[N];
        for (int i = 0; i < N; i++) {
            randArr[i] = random.nextInt(100);
        }
        return randArr;
    }

    private String[] randomStringArray() {
        String[] randArr = new String[N];
        for (int i = 0; i < N; i++) {
            randArr[i] = CommonUtils.randomString(N);
        }
        return randArr;
    }

    private Employee[] randomEmployeeArray() {
        Employee[] randArr = new Employee[N];
        for (int i = 0; i < N; i++) {
            randArr[i] = CommonUtils.randomObject();
        }
        return randArr;
    }

    void execute() {
        // sort integer array
        Integer[] toSortInt = randomIntArray();
        Arrays.sort(toSortInt);
        CommonUtils.displayArray(toSortInt);

        // sort integer array within a range
        Integer[] toSortIntRange = randomIntArray();
        Arrays.sort(toSortIntRange, 10, 20);
        CommonUtils.displayArray(toSortIntRange);

        // sort string array using comparator based on length
        String[] toSortString = randomStringArray();
        Arrays.sort(toSortString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        CommonUtils.displayArray(toSortString);

        // sort string array lexicographic - using lambda instead of comparator
        String[] toSortString2 = randomStringArray();
        Arrays.sort(toSortString2, (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));
        CommonUtils.displayArray(toSortString2);

        // sort array of objects
        Employee[] toSortEmployee = randomEmployeeArray();
        Arrays.sort(toSortEmployee, Comparator.comparing(Employee::getAge)
                .thenComparing(e -> e.getName().toLowerCase()));
        CommonUtils.displayArray(toSortEmployee);
    }
}
