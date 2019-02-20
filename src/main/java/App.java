import heap.Heap;

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
    }
}
