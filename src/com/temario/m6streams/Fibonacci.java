package com.temario.m6streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    // Con programación funcional
    public void secuenciaFibonacci() {
        Stream.iterate(new int[]{0, 1}, (n) -> new int[]{n[1], n[1] + n[0]})
                .limit(10)
                .collect(Collectors.toList())
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    // Con recurrencia de métodos
    public List<Integer> FibonacciSequence(List<Integer> nums, int limit) {

        try {
            if (nums.size() < limit) {
                nums.add(nums.get(nums.size() - 2) + nums.get(nums.size() - 1));
                FibonacciSequence(nums, limit);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La lista original tiene que tener "
                    + "un minimo de dos números");
        }
        return nums;
    }

    public List<Integer> FibonacciSequence(Integer n, int limit) {
        return FibonacciSequence(createList(n), limit);
    }

    public List<Integer> createList(int n) {
        List<Integer> list = new ArrayList<>();
        if (!(n > 0)) {
            n = 100;
        }
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }
}
