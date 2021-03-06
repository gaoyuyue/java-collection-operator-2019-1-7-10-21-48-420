package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left < right) {
            return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
        }
        List<Integer> result = IntStream.rangeClosed(right, left).boxed().collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left < right) {
            return IntStream.rangeClosed(left, right).boxed().filter(Numbers::isEven).collect(Collectors.toList());
        }
        List<Integer> result = IntStream.rangeClosed(right, left).boxed().filter(Numbers::isEven).collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(Numbers::isEven).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .filter(i -> Arrays.stream(secondArray).boxed().collect(Collectors.toList()).contains(i))
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> first = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).filter(i -> !first.contains(i)).collect(Collectors.toList());
        first.addAll(second);
        return first;
    }
}
