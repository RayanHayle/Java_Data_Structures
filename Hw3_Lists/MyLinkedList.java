import java.util.Iterator;
import java.util.Objects;

/**
 * Linked list implementation of the MyList interface.
 * @author Rayan Hayle  (UNI : Rah2236)
 * @version 1.0 September 27, 2022
 */
public class MyLinkedList<E> implements MyList<E> {
    private Node head, tail;
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of the element to return
     * @param element element to be stored at the specified position
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range
     *                                   (index < 0 || index >= size())
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", list size: " + size);
        }
        Node p = head;
        for (int i = 0; i < index; i++, p = p.next) ;
        E oldElement = p.element;
        p.element = element;
        return oldElement;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range
     *                                   (index < 0 || index >= size())
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", list size: " + size);
        }
        Node p = head;
        for (int i = 0; i < index; i++, p = p.next) ;
        return p.element;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    public boolean add(E element) {
        Node n = new Node(element);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
        return true;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     *
     ******************************************************************************************************************/
    public Iterator<E> iterator() {
        return new ListItr();
    }

    /**
     * NUM1
     */
    @Override
    public String toString() { // COMPLETE! (D)


        Node w = head;
        String s = "["; // this is what it'll began with
        //String b = "] "; //
        //String c = ", ";
        //  += for strings adding eveything to the end
        if (size >= 1){
        for (int i = 0; i < size -1; i++, w = w.next) {
            s += w.element + ", "; // element at the node

        }
        s+= w.element;
        }
        s+= "]";
        return s;
    }


    /**
     * NUM2
     */
    //@Override

    public void add(int index, E element) { //NUM2 NOT WORKING (D)

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", list size: " + size);
        }

        Node n = new Node(element), p = head, x = null;

        for (int i = 0; i<index; i++, x=p, p=p.next);



     if(index ==0) {
        n.next = head;
        head = n;
        size++;
    }
     else if(index == size) {
        tail.next = n;
        tail = n;
        size++;
    }
     else {
         x.next = n;
         n.next = p;
         size++;

     }
}

    /*** NUM3*/
    //@Override
    public E remove(int index) { //NUM3 COMPLETE!
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        Node t = head;
        Node r = head; // current node
        Node p = head;
        // link before and after which are t and p

        if(index == 0){
            head = r.next;
        }

       for (int i = 0; i < index; i++, r = r.next);
       for (int i = 0; i < index -1; i++, t= t.next);
       for (int i = 0; i < index + 1; i++, p= p.next);


       // link one before and one after
        t.next = p;
        size--;

        return r.element;
    }


    /*** NUM4 */
   // @Override
    public int indexOf(E element) {  //NUM4 DONE


        Node indexof = head; // remove, wont get  a pointer


        for (int i = 0; i < size; i++, indexof= indexof.next){

            //comparing the r.elment is at each element and they key element

            if (Objects.equals(indexof.element, element)){ //Objects.equals(o, get(i)),
                return i;
            }
        }
       // return indexOf(element);
        return -1; // this list does not contain the element,@return the index of the first occurrence of the specified element in

    }


    /*** NUM5*/
    //@Override
    public int[] indexesOf(E element) { //NUM5

        Node  rear = head;
        int d = 0; // a counter
        int y = 0;

        //int[] Index_of = new int[count];

        for (int i = 0; i < size; i++,rear= rear.next) {

                if ( rear.element == (E) element){
                    d++;
                }
        }
        Node q = head;
        int[] Index_of = new int[d];

        for (int i = 0; i < size; i++,q= q.next){
            if ( q.element == (E) element){
                Index_of[y++] = i;
            }
        }
        return Index_of;

    }


    /*** NUM6 */
   // @Override
    public void reverse() { //NUM6
       Node p=null;
       Node y=null;
       // the pointers set up
        // 2 pointers need to -----> two letter and set them to null
        // 1 pointer ---> first
        Node n = head; // I always set to head,
        //  06, 08, 09 test cases aren't working. maybe i need a tail
        tail = n;
        // the usal for method
        for (int i = 0; i<size-1; i++) { // since it's reverse minus 1 like i did in hw2

            //  set the nodes up
            //Node x should be before the new node, then set the n.next to a new node

            y = n.next;
            n.next = p;

            // set them up
            p = n;
            n = y;
        }
            head = n;

    }

    /** ******************************************************************************************************************/

    private class ListItr implements Iterator<E> {
        private Node current;

        ListItr() {current = head;}

        @Override
        public boolean hasNext() {return current != null;}

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }

        @Override
        public void remove() {throw new UnsupportedOperationException();}
    }

    private class Node {
        Node next;
        E element;

        public Node(E element) {
            this.element = element;
        }
    }
}

