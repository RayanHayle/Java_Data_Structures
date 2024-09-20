/**
 * Class that implements a binary search tree which implements the MyMap
 * interface.
 * @author Rayan Hayle (UNI: Rahh2336)
 * @version 1.0 October 19, 2022
 */
public class BSTMap<K extends Comparable<K>, V> implements MyMap<K, V> {
    public static final int PREORDER = 1, INORDER = 2, POSTORDER = 3;
    protected Node<K, V> root;
    protected int size;

    /**
     * Creates an empty binary search tree map.
     */
    public BSTMap() { }

    /**
     * Creates a binary search tree map of the given key-value pairs.
     * @param elements an array of key-value pairs
     */
    public BSTMap(Pair<K, V>[] elements) {
        insertElements(elements);
    }

    /**
     * Creates a binary search tree map of the given key-value pairs. If
     * sorted is true, a balanced tree will be created. If sorted is false,
     * the pairs will be inserted in the order they are received.
     * @param elements an array of key-value pairs
     */
    public BSTMap(Pair<K, V>[] elements, boolean sorted) {
        if (!sorted) {
            insertElements(elements);
        } else{
        root = createBST(elements, 0, elements.length - 1);}
    }

    /**
     * Recursively constructs a balanced binary search tree by inserting the
     * elements via a divide-snd-conquer approach. The middle element in the
     * array becomes the root. The middle of the left half becomes the root's
     * left child. The middle element of the right half becomes the root's right
     * child. This process continues until low > high, at which point the
     * method returns a null Node.
     * @param pairs an array of <K, V> pairs sorted by key
     * @param low   the low index of the array of elements
     * @param high  the high index of the array of elements
     * @return      the root of the balanced tree of pairs
     */
    protected Node<K, V> createBST(Pair<K, V>[] pairs, int low, int high) {
        // TODO 1

       if ( low >  high ){
        return null;
       }

    int mid = low + (high - low)/2;

     Node <K, V> root = new Node <K, V>(pairs[mid].key,(pairs[mid].value));

    root.left = createBST(pairs, low, mid-1);
    root.right = createBST(pairs, mid+1, high);

    if ( root.left != null){
        root.left.parent = root;}

    if (root.right != null){
     root.right.parent = root;}
    size++;
    return root;
    }

    /**
     * Inserts the pairs into the tree in the order they appear in the given
     * array.
     * @param pairs the array of <K, V> pairs to insert
     */
    protected void insertElements(Pair<K, V>[] pairs) {
        for (Pair<K, V> pair : pairs) {
            put(pair);}
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return the number of key-value mappings in this map
     */
    public int size() {
        // TODO 2
        return size;}

    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        // TODO 3
       // return size == 0; not boolean
        if ( size()== 0){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Returns a String of the key-value pairs visited with a preorder
     * traversal. Uses a StringBuilder for efficiency.
     * @return a String of the key-value pairs visited with a preorder
     *         traversal
     */
    public String preorder() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        preorder(root, builder, 0);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Visits the Nodes of the tree in a preorder traversal. Each Node's
     * toString() return value should be appended to the StringBuilder. A ", "
     * must appear between each Node's data in the final String.
     * @param n            the current Node
     * @param builder      the StringBuilder used to build up the output
     * @param nodesVisited the number of nodes visited so far. Useful for
     *                     determining when to append ", ".
     * @return the number of nodes visited after each recursive call
     */
    private int preorder(Node<K, V> n, StringBuilder builder, int nodesVisited) {
        // TODO 4 WORKS!
        if (n == null){  //base case
            return nodesVisited;
        }

        else{
            // this is to fix the spacing and comma issue:
            if (nodesVisited == 0){
                builder.append(n.toString());
            }
            else if (nodesVisited != 0) {
                builder.append(", " + n.toString());
            }

            nodesVisited++;
            nodesVisited=preorder(n.left, builder,nodesVisited);
            nodesVisited=preorder(n.right, builder,nodesVisited);
        }
        return nodesVisited;
    }

    /**
     * Returns a String of the key-value pairs visited with an inorder
     * traversal. Uses a StringBuilder for efficiency.
     * @return a String of the key-value pairs visited with an inorder
     *         traversal
     */
    public String inorder() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        inorder(root, builder, 0);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Visits the Nodes of the tree in an inorder traversal. Each Node's
     * toString() return value should be appended to the StringBuilder. A ", "
     * must appear between each Node's data in the final String.
     * @param n            the current Node
     * @param builder      the StringBuilder used to build up the output
     * @param nodesVisited the number of nodes visited so far. Useful for
     *                     determining when to append ", ".
     * @return the number of nodes visited after each recursive call
     */
    private int inorder(Node<K, V> n, StringBuilder builder, int nodesVisited) {
        //L R M
        // TODO 5 WORKS!
       if (n == null){
           return nodesVisited;
       }
      else{
           nodesVisited= inorder(n.left, builder, nodesVisited);

           if(nodesVisited == 0){
               //then append the string
               builder.append(n.toString());
           }
           else if (nodesVisited != 0){
               builder.append(", " + n.toString());
           }
           nodesVisited++;
           nodesVisited = inorder(n.right, builder, nodesVisited);

       }
       return nodesVisited;
    }

    /**
     * Returns a String of the key-value pairs visited with a postorder
     * traversal. Uses a StringBuilder for efficiency.
     * @return a String of the key-value pairs visited with a postorder
     *         traversal
     */
    public String postorder() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        postorder(root, builder, 0);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Visits the Nodes of the tree in a postorder traversal. Each Node's
     * toString() return value should be appended to the StringBuilder. A ", "
     * must appear between each Node's data in the final String.
     * @param n            the current Node
     * @param builder      the StringBuilder used to build up the output
     * @param nodesVisited the number of nodes visited so far. Useful for
     *                     determining when to append ", ".
     * @return the number of nodes visited after each recursive call
     */
    private int postorder(Node<K, V> n, StringBuilder builder, int nodesVisited) {
        // TODO 6 WORKS!
        // L R M(root)
        if (n == null){
            return nodesVisited;
        }
        nodesVisited=postorder(n.left, builder, nodesVisited);
        nodesVisited=postorder(n.right, builder, nodesVisited);


        if(nodesVisited == 0){ // root
            builder.append(n.toString());
        }
            else if (nodesVisited != 0){
                builder.append( ", " + n.toString());
            }
            nodesVisited++;

        return nodesVisited;

    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     * @param  key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this
     *         map contains no mapping for the key
     */
    public V get(K key) {
        Node<K, V> x = iterativeSearch(key);
        return x != null ? x.value : null;
    }

    /**
     * Determines if the supplied key is found in the tree. If so, it returns a
     * reference to the Node containing the key. Otherwise, null is returned.
     * @param key key whose mapping is to be removed from the map
     * @return a reference to the Node containing the specified key
     */
    private Node<K, V> iterativeSearch(K key) {
        // TODO 7 WORKS!
        Node<K,V> x = root; // the node pointer moves

       if (root == null){
           return null;
       }

        while (x != null){

            if (x.key.compareTo(key) < 0){ // k < less than  x.key
                x= x.right;
            }

            else if (x.key.compareTo(key)> 0) { // k > greater than x.key
                x = x.left;
            }

            else if (x.key.compareTo(key)== 0) {
                return x;
            }
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is replaced
     * by the specified value.
     * @param pair  the key-value mapping to insert into the tree
     * @return the previous value associated with key, or null if there was no
     *         mapping for key
     */
    public V put(Pair<K, V> pair) {
        return put(pair.key, pair.value);
    }

    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is replaced
     * by the specified value.
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no
     *         mapping for key
     */
    public V put(K key, V value) {
        // TODO 8 WORKS!

        // parent pointers like root.right.parent = root;
        //else if > 0, go right, else, go left

        Node<K, V> z = new Node<K, V>(key,value);//new node
        Node<K, V> x = root, y = null; //temp value is x

        while (x != null) { // not changing
            //y = x; // tail
            if (key.compareTo((K)x.key) < 0) { // k < less than  x.key
                y=x;
                x = x.left;
            }

            else if (key.compareTo((K)x.key) > 0) { // k > greater than x.key
                y =x;
                x = x.right;
            }

            else if (key.compareTo((K)x.key) == 0) { // k = x.key
                // old --> new
                y = x;
                V Myvalue = x.value;
                x.value = value; // stores the old value
                return Myvalue;
            }
        }
        z.parent = y;
        size++;
        if (y == null){ // root
          root = z;
          return null;
        }
        if (key.compareTo((K) y.key) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }

       // z.parent = y;
       // return (V) z.value;
        return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no
     *         mapping for key
     */
    public V remove(K key) {
        // TODO 9 last! DOES NOT WORK :( -20 points maybe
        // if methods to check mutiple things child:both left and right and amount of children

        Node <K, V> node = iterativeSearch(key);
        V before = iterativeSearch(key).value;

        if(iterativeSearch(key) != null){ //page 120 textbook

            if (node.right == null && node.left == null){
                if(node.parent == null){
                    root = null;
                }

                // when on parent is the node
                   else  if (node.parent.left == node){
                        // set to null
                        node.parent.left = null;
                    }
                    else {
                        node.parent.right = null;
                    }

                node = null;
                size--;
            } // first if loop


            else if( node.left == null ) {
                if (node.parent.key.compareTo(key) > 0) {
                    node.parent.left = node.right;
                    node.right.parent = node.right;
                    node = null;

                }

                else if (node.parent.key.compareTo(key) < 0){ //greater so right
                    node.parent.right = node.right;
                    node.right.parent = node.right;
                    node = null;
                }
                size--;
            }

        } // the first while loop



        return before;

    }

    /**
     * Returns a reference to the Node whose key value is the minimum key in the
     * tree.
     * @param x the Node at which to start the traversal
     * @return a reference to the Node whose key value is the minimum key in the
     *         tree
     */
    protected Node<K, V> treeMinimum(Node<K, V> x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * Returns a String representation of the tree, where the Nodes are visited
     * with an inorder traversal.
     * @return a String representation of the tree
     */
    public String toString() {
        return inorder();
    }

    /**
     * Returns an ASCII drawing of the tree.
     * @return an ASCII drawing of the tree
     */
    public String toAsciiDrawing() {
        BinarySearchTreePrinter<K, V> printer =
                new BinarySearchTreePrinter<K, V>();
        printer.createAsciiTree(root);
        return printer.toString();
    }

    public void printTraversal(int type) {
        switch (type) {
            case PREORDER:
                System.out.print("Preorder traversal:       ");
                System.out.println(preorder());
                break;
            case INORDER:
                System.out.print("Inorder traversal:        ");
                System.out.println(inorder());
                break;
            case POSTORDER:
                System.out.print("Postorder traversal:      ");
                System.out.println(postorder());
                break;
            default:
                return;
        }
    }

    /**
     * Returns the height of the tree. If the tree is null, the height is -1.
     * @return the height of the tree
     */
    public int height() {
        return height(root) ;
    }

    protected int height(Node<K, V> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Returns the number of null references in the tree. Uses a recursive
     * helper method to count the null references.
     * @return the number of null references in the tree
     */
    public int nullCount() {
        return nullCount(root);
    }

    private int nullCount(Node<K, V> node) {
        if (node == null) {
            return 1;
        }
        return nullCount(node.left) + nullCount(node.right);
    }

    /**
     * Returns the sum of the levels of each non-null node in the tree starting
     * at the root.
     * For example, the tree
     *   5 <- level 0
     *  / \
     * 2   8 <- level 1
     *      \
     *       10 <- level 2
     * has sum 0 + 2(1) + 2 = 4.
     * @return the sum of the levels of each non-null node in the tree starting
     *         at the root
     */
    public int sumLevels() { //
        return sumLevels(root, 0);
    }

    private int sumLevels(Node<K, V> node, int level) { // non-null node
        // TODO 10 WORKS!

        /*int total =0;
        // check left and right now, imcrimate level each time
        //base case:
        if (node.left == null || node.right==null){
            return 0;
        }
        if (node.left != null){
            total = total + sumLevels(node.left, level+1);
        }
        if (node.right != null){
            total = total + sumLevels(node.right, level +1);
        }*/

        if (node == null){ //base case
            return 0;
        }

     return sumLevels(node.left, level +1) + sumLevels(node.right, level +1) + level;

    }

    /**
     * Returns the sum of the levels of each null node in the tree starting at
     * the root.
     * For example, the tree
     *    5 <- level 0
     *   / \
     *  2   8 <- level 1
     * / \ / \
     * * * * * 10 <- level 2
     *        / \
     *        * * <- level 3
     * has sum 3(2) + 2(3) = 12.
     * @return the sum of the levels of each null node in the tree starting at
     *         the root
     */
    public int sumNullLevels() {
        return sumNullLevels(root, 0);
    }

    private int sumNullLevels(Node<K, V> node, int level) {
        // TODO 11 WORKS!
        if (node == null){
            return level;
        }

        return sumNullLevels(node.left, level +1) + sumNullLevels(node.right, level +1) ;

    }

    public double successfulSearchCost() {
        return size == 0 ? 0 : 1 + (double)sumLevels() / size;
    }

    public double unsuccessfulSearchCost() {
        return (double)sumNullLevels() / nullCount();
    }

    /**
     * Main method to facilitate testing your code.
     * Either a map of <Integer, Integer> or <String, String> will be created.
     * If the first command line argument parses to an int, the map will be of
     * type <Integer, Integer>.
     * @param args the values to insert into the tree
     */
    public static void main(String[] args) {
        boolean usingInts = true;
        if (args.length > 0) {
            try {
                Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                usingInts = false;
            }
        }

        @SuppressWarnings("rawtypes")
        BSTMap bst;
        if (usingInts) {
            Pair<Integer, Integer>[] pairs = new Pair[args.length];
            for (int i = 0; i < args.length; i++) {
                try {
                    int val = Integer.parseInt(args[i]);
                    pairs[i] = new Pair<>(val, val);
                } catch (NumberFormatException nfe) {
                    System.err.println("Error: Invalid integer '" + args[i]
                            + "' found at index " + i + ".");
                    System.exit(1);
                }
            }
            bst = new BSTMap<Integer, Integer>(pairs);
        } else {
            Pair<String, String>[] pairs = new Pair[args.length];
            for (int i = 0; i < args.length; i++) {
                pairs[i] = new Pair<>(args[i], args[i]);
            }
            bst = new BSTMap<String, String>(pairs);
        }

        System.out.println(bst.toAsciiDrawing());
        System.out.println();
        System.out.println("Height:                   " + bst.height());
        System.out.println("Total nodes:              " + bst.size());
        System.out.printf("Successful search cost:   %.3f\n",
                          bst.successfulSearchCost());
        System.out.printf("Unsuccessful search cost: %.3f\n",
                          bst.unsuccessfulSearchCost());
        bst.printTraversal(PREORDER);
        bst.printTraversal(INORDER);
        bst.printTraversal(POSTORDER);
    }
}

