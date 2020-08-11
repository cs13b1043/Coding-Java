package com.example.utils;

import com.example.model.Employee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommonUtils {

    private static Random random = new Random();

    public static <T> void displayArray(T[] arr) {
        System.out.println("Showing Array: ");
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static <T> void displayList(List<T> list) {
        System.out.println("Showing List: ");
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static <E, T> void displayMap(LinkedHashMap<E,T> map) {
        System.out.println("Showing Map: ");
        for (Map.Entry<E, T> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println();
    }

    public static String randomString(int strLenBound) {
        int strLen = random.nextInt(strLenBound);
        String salt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder s = new StringBuilder();
        for (int j = 0; j < strLen; j++) {
            s.append(salt.charAt(random.nextInt(salt.length())));
        }
        return s.toString();
    }

    public static Employee randomObject() {
        int age = random.nextInt(100);
        String name = randomString(30);
        return new Employee(age, name);
    }
}
