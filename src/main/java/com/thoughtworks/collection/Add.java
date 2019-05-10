package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Border border = new Border(leftBorder, rightBorder).invoke();
        return IntStream.rangeClosed(border.getLeftBorder(), border.getRightBorder()).filter(this::isEven).sum();
}

    private boolean isEven(int i) {
        return i % 2 == 0;
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
        List<Integer> result = arrayList.stream().filter(this::isEven).collect(Collectors.toList());
        int count = result.size();
        int mid = count >> 1;
        if (isEven(count)) {
            return (result.get(mid -1) + result.get(mid)) >> 1;
        }
        return result.get(mid);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
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
