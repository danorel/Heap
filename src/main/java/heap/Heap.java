package heap;

public class Heap {
    private Leaf root;
    private int size = 0;

    public Heap(){
        root = new Leaf(0);
    }

    public Heap(Integer key){
        root = new Leaf(key);
    }

    public Integer[] asArray(Leaf root){
        if(root != null){
            Integer []Array = new Integer[size(root)];
            Array[0] = root.key;
            return buildArray(root, 1, Array);
        }
        return null;
    }

    private Integer[] buildArray(Leaf root, int index, Integer[] Array){
        if(root != null) {
            if(root.leftLeaf != null){
                Array[index * 2 - 1] = root.leftLeaf.key;
                Array = buildArray(root.leftLeaf, index * 2 , Array);
            }
            if(root.rightLeaf != null){
                Array[index * 2] = root.rightLeaf.key;
                Array = buildArray(root.rightLeaf, index * 2 + 1, Array);
            }
        }
        return Array;
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

    public void asMAXHeapify(Integer []Array){
        if(Array.length > 0){
            root = new Leaf(Array[0]);
            for(int index = Array.length / 2; index >= 1; index--){
                Array = buildMAXHeapify(Array, index);
            }
            asHeap(Array);
        }
    }

    private Integer[] buildMAXHeapify(Integer []Array, int index){
        int lch = index * 2;
        int rch = index * 2 + 1;
        int largest = index;
        if(lch - 1 < Array.length && Array[index - 1] < Array[lch - 1]){
            largest = lch;
        }
        if(rch - 1 < Array.length && Array[index - 1] < Array[rch - 1]){
            largest = rch;
        }
        if(largest != index) {
            swap(Array, index - 1, largest - 1);
            buildMAXHeapify(Array, largest);
        }
        return Array;
    }

    public void asMINHeapify(Integer []Array){
        if(Array.length > 0){
            root = new Leaf(Array[0]);
            for(int index = Array.length / 2; index >= 1; index--){
                Array = buildMINHeapify(Array, index);
            }
            asHeap(Array);
        }
    }

    private Integer[] buildMINHeapify(Integer []Array, int index){
        int lch = index * 2;
        int rch = index * 2 + 1;
        int smallest = index;
        if(lch - 1 < Array.length && Array[index - 1] > Array[lch - 1]){
            smallest = lch;
        }
        if(rch - 1 < Array.length && Array[index - 1] > Array[rch - 1]){
            smallest = rch;
        }
        if(smallest != index) {
            swap(Array, index - 1, smallest - 1);
            buildMINHeapify(Array, smallest);
        }
        return Array;
    }

    private void swap(Integer []Array, int fPos, int sPos){
        Integer temp = Array[fPos];
        Array[fPos] = Array[sPos];
        Array[sPos] = temp;
    }

    public Heap insertKEY(Leaf root, Integer key){
        size = size(root);
        Integer []Array = new Integer[size + 1];
        copyElementsFrom(root, Array);
        Array[size] = key;
        asHeap(Array);
        return this;
    }

    private void copyElementsFrom(Leaf leaf, Integer[] into){
        Integer []Array = asArray(leaf);
        for(int index = 0; index < Array.length; index++) {
            into[index] = Array[index];
        }
    }


    public int findMAX(Leaf root){
        return findMAX(root, root.key);
    }

    private int findMAX(Leaf leaf, Integer MAX){
        if(leaf != null){
            if(leaf.key >= MAX) MAX = leaf.key;
            if(leaf.leftLeaf != null){
                MAX = findMAX(leaf.leftLeaf, MAX);
            }
            if(leaf.rightLeaf != null){
                MAX = findMAX(leaf.rightLeaf, MAX);
            }
        }
        return MAX;
    }

    /* Working on the extracting the max element in the heap
    public void extractMAX(Leaf root){
        extractMAX(root, findMAX(root));
    }

    private void extractMAX(Leaf leaf, Integer MAX){
        if(leaf != null){
            if(leaf.key.equals(MAX)) substituteKEY(leaf, leaf.key, 0);
            if(Objects.requireNonNull(leaf).leftLeaf != null){
                extractMAX(leaf.leftLeaf, MAX);
            }
            if(Objects.requireNonNull(leaf).rightLeaf != null){
                extractMAX(leaf.rightLeaf, MAX);
            }
        }
    }
    */

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

    /*  Working on the removing the key in the heap
    public Heap removeKEY(Leaf root, Integer key){
        remove(root, key);
        return this;
    }

    private void remove(Leaf leaf, Integer key){
        if(leaf != null){
            if(leaf.leftLeaf != null){
                if(leaf.leftLeaf.key.equals(key)) {
                    leaf.leftLeaf = null;
                } else {
                    remove(leaf.leftLeaf, key);
                }
                if(leaf.rightLeaf.key.equals(key)){
                    leaf.rightLeaf = null;
                } else {
                    remove(leaf.rightLeaf, key);
                }

            }
        }
    }
    */

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

    public int size(Leaf leaf){
        size = 0;
        size = getSize(leaf);
        return size;
    }

    private int getSize(Leaf leaf){
        if(leaf != null){
            size++;
            if(leaf.leftLeaf != null){
                getSize(leaf.leftLeaf);
            }
            if(leaf.rightLeaf != null){
                getSize(leaf.rightLeaf);
            }
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public Leaf getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return root.toString();
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
