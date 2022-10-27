package com.obito.systemclass.class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author obito
 */
public class Code02_HeapGreater<T> {

    private final ArrayList<T> heap;
    private int heapSize;
    private final HashMap<T,Integer> indexMap;
    private final Comparator<? super T> comparator;

    public Code02_HeapGreater(Comparator<? super T> comparator) {
        heap = new ArrayList<T>();
        heapSize = 0;
        indexMap = new HashMap<T, Integer>();
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean isContainsKey(T key) {
        return indexMap.containsKey(key);
    }

    public void remove(T value) {
        T replace = heap.get(heapSize - 1);
        Integer index = indexMap.get(value);
        indexMap.remove(value);
        heap.remove(--heapSize);
        if (value != replace) {
            heap.set(index,replace);
            indexMap.put(replace,index);
            resign(replace);
        }
    }

    public void push(T value) {
        heap.add(heapSize,value);
        indexMap.put(value,heapSize);
        heapInsert(heapSize++);
    }

    public T peek() {
        return heap.get(0);
    }

    public T poll() {
        T ans = heap.get(0);
        swap(0,--heapSize);
        heap.remove(heapSize);
        indexMap.remove(ans);
        heapIfy(0);
        return ans;
    }

    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapIfy(indexMap.get(obj));
    }

    public void heapInsert(int index) {
        while (comparator.compare(heap.get(index),heap.get((index - 1) / 2)) < 0) {
            swap(index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapIfy(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int minIndex = left + 1 < heapSize && comparator.compare(heap.get(left + 1),heap.get(left)) < 0 ? left + 1 : left;
            minIndex = comparator.compare(heap.get(minIndex),heap.get(index)) < 0 ? minIndex : index;
            if (index == minIndex) {
                break;
            }
            swap(index,minIndex);
            index = minIndex;
            left = index * 2 + 1;
        }
    }

    public void swap(int i,int j) {
        T a = heap.get(i);
        T b = heap.get(j);
        heap.set(i,b);
        heap.set(j,a);
        indexMap.put(a,j);
        indexMap.put(b,i);
    }

}
