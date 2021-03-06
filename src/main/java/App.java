import heap.Heap;
import heap.sort.HeapSort;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap();
        Integer []ints = {5, 13, -3, 2, 1, 0, 47};
        heap.asHeap(ints);
        heap.showHeap(heap.getRoot());
        System.out.println();
        heap.substituteKEY(heap.getRoot(), -3, 7);
        heap.showHeap(heap.getRoot());
        System.out.println("MAX:" + heap.findMAX(heap.getRoot()));
        System.out.println("SIZE:" + heap.size(heap.getRoot()));
        Integer []arr = heap.asArray(heap.getRoot());
        Arrays.asList(arr).forEach(element -> {
            System.out.print(element + " ");
        });
        System.out.println("\n");
        heap.insertKEY(heap.getRoot(), 19).insertKEY(heap.getRoot(), 56).insertKEY(heap.getRoot(), -51).showHeap(heap.getRoot());

        System.out.println();
        Heap minHeapifiedHeap = new Heap();
        minHeapifiedHeap.asMINHeapify(ints);
        final Integer[] minArray = minHeapifiedHeap.asArray(minHeapifiedHeap.getRoot());
        Arrays.asList(minArray).forEach(element -> {
            System.out.print(element + " ");
        });

        System.out.println();
        Heap maxHeapifiedHeap = new Heap();
        maxHeapifiedHeap.asMAXHeapify(ints);
        final Integer[] maxArray = maxHeapifiedHeap.asArray(maxHeapifiedHeap.getRoot());
        Arrays.asList(maxArray).forEach(element -> {
            System.out.print(element + " ");
        });
        HeapSort.sortDESC(maxArray);
        System.out.println();
        Arrays.asList(maxArray).forEach(element -> {
            System.out.print(element + " ");
        });
    }
}
