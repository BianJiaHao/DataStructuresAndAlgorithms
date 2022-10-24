package com.obito.systemclass.class06;

/**
 * @author obito
 */
public class Code02_Heap {

    public static class MyBigHeap {
        private final int[] heap;
        private final int limit;
        private int size;

        public MyBigHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isFull() {
            return size == limit;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("Heap is Full");
            }
            heap[size] = value;
            heapInsert(heap,size++);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("Heap is Empty");
            }
            int ans = heap[0];
            swap(heap,--size,0);
            heapIfy(heap,0,size);
            return ans;
        }

        public void heapInsert(int[] heap,int index) {
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap,index,(index - 1) >> 1);
                index = (index - 1) >> 1;
            }
        }

        public void heapIfy(int[] heap,int index,int heapSize) {
            int left = (index << 1) + 1;
            while (left < heapSize) {
                int maxIndex = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
                maxIndex = heap[maxIndex] > heap[index] ? maxIndex : index;
                if (maxIndex == index) {
                    break;
                }
                swap(heap,maxIndex,index);
                index = maxIndex;
                left = (index << 1) + 1;
            }
        }

        public void swap(int[] arr,int i,int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        MyBigHeap heap = new MyBigHeap(10);
        heap.push(5);
        heap.push(1);
        heap.push(4);
        heap.push(10);
        heap.push(8);

        while (!heap.isEmpty()) {
            System.out.println(heap.pop());
        }
    }
}
