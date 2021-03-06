package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Border border = new Border(leftBorder, rightBorder).invoke();
        return IntStream.rangeClosed(border.getLeftBorder(), border.getRightBorder()).filter(Numbers::isEven).sum();
}

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Border border = new Border(leftBorder, rightBorder).invoke();
        return IntStream.rangeClosed(border.getLeftBorder(), border.getRightBorder()).filter(this::isOdd).sum();
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(item -> item * 3 + 2).reduce(0, Integer::sum);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(item -> isOdd(item) ? item * 3 + 2 : item).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(this::isOdd).map(item -> item * 3 + 5).reduce(0, Integer::sum);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> result = arrayList.stream().filter(Numbers::isEven).collect(Collectors.toList());
        int count = result.size();
        int mid = count >> 1;
        if (Numbers.isEven(count)) {
            return (result.get(mid -1) + result.get(mid)) >> 1;
        }
        return result.get(mid);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(Numbers::isEven).mapToInt(Integer::intValue).average().orElseGet(() -> 0);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(Numbers::isEven).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(Numbers::isEven).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> first = arrayList.stream().filter(Numbers::isEven).sorted().collect(Collectors.toList());
        List<Integer> second = arrayList.stream().filter(this::isOdd).sorted((f, s) -> s - f).collect(Collectors.toList());
        first.addAll(second);
        return first;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i++) {
            int item = (arrayList.get(i - 1) + arrayList.get(i)) * 3;
            result.add(item);
        }
        return result;
    }

    private class Border {
        private int leftBorder;
        private int rightBorder;

        public Border(int leftBorder, int rightBorder) {
            this.leftBorder = leftBorder;
            this.rightBorder = rightBorder;
        }

        public int getLeftBorder() {
            return leftBorder;
        }

        public int getRightBorder() {
            return rightBorder;
        }

        public Border invoke() {
            if (leftBorder > rightBorder) {
                int temp = leftBorder;
                leftBorder = rightBorder;
                rightBorder = temp;
            }
            return this;
        }
    }
}
