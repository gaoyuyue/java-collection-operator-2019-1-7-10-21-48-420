package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Comparator.comparingInt(o -> o)).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.comparingInt(o -> o)).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(i -> i).average().getAsDouble();
    }

    public double getOrderedMedian() {
        int count = arrayList.size();
        int mid = count >> 1;
        if (Numbers.isEven(count)) {
            return (arrayList.get(mid - 1) + arrayList.get(mid)) / 2.0;
        }
        return arrayList.get(mid);
    }

    public int getFirstEven() {
        for (Integer item : arrayList) {
            if (Numbers.isEven(item)) {
                return item;
            }
        }
        return Integer.MAX_VALUE;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            Integer item = arrayList.get(i);
            if (Numbers.isEven(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        int count = arrayList.size();
        int mid = count >> 1;
        if (Numbers.isEven(count)) {
            return ((Integer)singleLink.getNode(mid) + (Integer) singleLink.getNode(mid + 1)) / 2.0;
        }
        return ((Integer)singleLink.getNode(mid + 1)).doubleValue();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
