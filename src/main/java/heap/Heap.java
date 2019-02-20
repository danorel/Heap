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
        if(2 * index - 1 < Array.length){
            leaf.leftLeaf = new Leaf(Array[(2 * index - 1) ]);
            buildHeap(Array, 2 * index , leaf.leftLeaf);
        }
        if(2 * index < Array.length) {
            leaf.rightLeaf = new Leaf(Array[2 * index]);
            buildHeap(Array, 2 * index + 1, leaf.rightLeaf);
        }
    }

    public Heap insertKEY(Leaf root, Integer key){

        return this;
    }

    public int extractMAX(Leaf root){
        return extractMAX(root, root.key);
    }

    private int extractMAX(Leaf leaf, Integer MAX){
        if(leaf != null){
            if(leaf.key >= MAX) MAX = leaf.key;
            if(leaf.leftLeaf != null){
                return extractMAX(leaf.leftLeaf, MAX);
            }
            if(leaf.rightLeaf != null){
                return extractMAX(leaf.rightLeaf, MAX);
            }
        }
        return MAX;
    }

    public Heap substituteKEY(Leaf root, Integer key, Integer value){
        substitute(root, key, value);
        return this;
    }

    private void substitute(Leaf leaf, Integer key, Integer value){
        if(leaf != null){
            if(leaf.key.equals(key)){
                leaf.key = value;
            }
            if(leaf.leftLeaf != null){
                substitute(leaf.leftLeaf, key, value);
            }
            if(leaf.rightLeaf != null){
                substitute(leaf.rightLeaf, key, value);
            }
        }
    }

    public void showHeap(Leaf leaf){
        showHeap(leaf, 1);
    }

    private void showHeap(Leaf leaf, int layer){
        if(leaf != null){
            for(int times = 0; times < layer; times++){
                System.out.print("-");
            }
            System.out.println("(" + leaf.key + ")");
            if(leaf.rightLeaf != null || leaf.leftLeaf != null){
                if(leaf.leftLeaf != null){
                    showHeap(leaf.leftLeaf, layer + 1);
                }
                if(leaf.rightLeaf != null){
                    showHeap(leaf.rightLeaf, layer + 1);
                }
            }
        }
    }

    public Leaf getRoot() {
        return root;
    }

    private class Leaf {
        private Integer key;
        public Leaf rightLeaf = null;
        public Leaf leftLeaf = null;

        public Leaf(Integer key){
            this.key = key;
        }
    }
}
