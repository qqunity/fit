package org.mephi;

import java.util.Arrays;
import java.util.List;

public class Sorter {
    // Метод сортировки, который нужно тестировать
    public static List<Integer> sort(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.sort(array);
        return Arrays.asList(array);
    }
}