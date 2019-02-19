package heap;

public class Heap {
    private Leaf root;

    public Heap(){
        root = new Leaf(0);
    }

    public Heap(Integer key){
        root = new Leaf(key);
    }

    public void asHeap(Integer []Array){
        if(Array.length > 0){
            root = new Leaf(Array[0]);
            buildHeap(Array, 1, root);
        } else {
            root = null;
        }
    }

    private void buildHeap(Integer []Array, int index, Leaf leaf){
        if(2 * index < Array.length){
            leaf.leftLeaf = new Leaf(Array[(2 * index + 1) - 1]);
            buildHeap(Array, 2 * index + 1, leaf.leftLeaf);
            leaf.rightLeaf = new Leaf(Array[(2 * index - 1) ]);
            buildHeap(Array, 2 * index , leaf.rightLeaf);
        }
    }


//    public Heap insertKEY(S, x){
//
//        return this;
//    }
//
//    public Heap extractMAX(S){
//
//        return this;
//    }
//
//    public Heap substituteKEY(S, x, s){
//
//        return this;
//    }

    public void showHeap(Leaf leaf){
        System.out.println("-" + leaf.key);
        while(leaf.leftLeaf != null || leaf.rightLeaf != null){
            if(leaf.leftLeaf != null){
                showHeap(leaf.leftLeaf);
            }
            if(leaf.rightLeaf != null){
                showHeap(leaf.rightLeaf);
            }
        }
    }

    public Leaf getRoot() {
        return root;
    }

    private class Leaf {
        private Integer key;
        public Leaf leftLeaf = null;
        public Leaf rightLeaf = null;

        public Leaf(Integer key){
            this.key = key;
        }
    }
}
