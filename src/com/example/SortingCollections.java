package com.example;

import com.example.model.Employee;
import com.example.utils.CommonUtils;

import java.util.*;

class SortingCollections {
    private int N;
    private Random random;

    SortingCollections() {
        N = 30;
        random = new Random();
    }

    private List<Integer> randomIntegerList() {
        List<Integer> randList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            randList.add(random.nextInt(100));
        }
        return randList;
    }

    private List<String> randomStringList() {
        List<String> randList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            randList.add(CommonUtils.randomString(N));
        }
        return randList;
    }

    private LinkedHashMap<Integer, String> randomMap() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(random.nextInt(100), CommonUtils.randomString(N));
        }
        return map;
    }

    private List<Employee> randomEmployeeList() {
        List<Employee> randList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            randList.add(CommonUtils.randomObject());
        }
        return randList;
    }

    void execute() {
        // sort integer list
        List<Integer> toSortInt = randomIntegerList();
        Collections.sort(toSortInt);
        CommonUtils.displayList(toSortInt);

        // sort string list using comparator based on length
        List<String> toSortString = randomStringList();
        Collections.sort(toSortString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        CommonUtils.displayList(toSortString);

        // sort hashmap by key
        LinkedHashMap<Integer, String> toSortMap = randomMap();
        List<Map.Entry<Integer, String>> entries = new ArrayList<>(toSortMap.entrySet());

        Collections.sort(entries, Comparator.comparing(Map.Entry::getKey));

        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        CommonUtils.displayMap(sortedMap);

        // sort list of objects
        List<Employee> toSortEmployee = randomEmployeeList();
        Collections.sort(toSortEmployee, Comparator.comparing(Employee::getAge)
                .thenComparing(e -> e.getName().toLowerCase()));
        CommonUtils.displayList(toSortEmployee);
    }
}
