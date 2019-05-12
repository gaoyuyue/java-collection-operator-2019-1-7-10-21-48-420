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
        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
