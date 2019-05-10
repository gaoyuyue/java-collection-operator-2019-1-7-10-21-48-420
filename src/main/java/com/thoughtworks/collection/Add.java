package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Border border = new Border(leftBorder, rightBorder).invoke();
        return IntStream.rangeClosed(border.getLeftBorder(), border.getRightBorder()).filter(i -> i % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Border border = new Border(leftBorder, rightBorder).invoke();
        return IntStream.rangeClosed(border.getLeftBorder(), border.getRightBorder()).filter(i -> i % 2 == 1).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
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
