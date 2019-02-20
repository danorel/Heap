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
            size = 0;
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

    public Heap insertKEY(Leaf root, Integer key){

        return this;
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

    public void extractMAX(Leaf root){
        extractMAX(root, findMAX(root));
    }

    private void extractMAX(Leaf root, Integer MAX){

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

    public int size(Leaf leaf){
        if(leaf != null){
            size++;
            if(leaf.leftLeaf != null){
                size(leaf.leftLeaf);
            }
            if(leaf.rightLeaf != null){
                size(leaf.rightLeaf);
            }
        }
        return size;
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
