import heap.Heap;

public class App {
    public static void main(String[] args) {
        Heap heap = new Heap();
        Integer []ints = {5, 13, -3, 2, 1, 0};
        heap.asHeap(ints);
        heap.showHeap(heap.getRoot());
    }
}
