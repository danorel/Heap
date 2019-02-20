import heap.Heap;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap();
        Integer []ints = {5, 13, -3, 2, 1, 0, 47};
        heap.asHeap(ints);
        heap.showHeap(heap.getRoot());
        System.out.println();
        heap.substituteKEY(heap.getRoot(), -3, 7);
        heap.showHeap(heap.getRoot());
        System.out.println();
        System.out.println(heap.extractMAX(heap.getRoot()));
    }
}
