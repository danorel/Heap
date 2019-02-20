package heap.sort;

import heap.Heap;

public class HeapSort {
    public static void sortASC(Integer []Array){
        Heap heap = new Heap();
        heap.asMAXHeapify(Array);
        int size = heap.size(heap.getRoot());
        while(size != 0){
            swap(Array, 0, Array.length - 1);
            heap.setSize(size--);
            heap.asMAXHeapify(Array);
        }
    }

    public static void sortDESC(Integer []Array){
        Heap heap = new Heap();
        heap.asMINHeapify(Array);
        int size = heap.size(heap.getRoot());
        while(size != 0){
            swap(Array, 0, Array.length - 1);
            heap.setSize(size--);
            heap.asMINHeapify(Array);
        }
    }

    private static void swap(Integer []Array, int fPos, int sPos){
        Integer temp = Array[fPos];
        Array[fPos] = Array[sPos];
        Array[sPos] = temp;
    }
}
