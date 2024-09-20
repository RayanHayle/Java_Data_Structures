import java.util.Iterator;
import java.util.Objects;


/**
 * Resizable-array implementation of the MyList interface.
 * @author Rayan Hayle  (UNI : Rah2236)
 * @version 1.0 September 27, 2022
 */
public class MyArrayList<E> implements MyList<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer.
     */
    Object[] elementData; // non-private to simplify nested class access

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
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
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    public boolean add(E element) {
        if (size + 1 > elementData.length) {
            Object[] newData = new Object[size * 2 + 1];
            for (int i = 0; i < size; i++) {
                newData[i] = elementData[i];
            }
            elementData = newData;
        }
        elementData[size++] = element;
        return true;
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
        return (E) elementData[index];
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
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Returns an iterator over the elements in this list (in proper
     * sequence).
     * <p>
     * The returned list iterator is fail-fast -- modification of the elements
     * is not permitted during iteration.
     */
    public Iterator<E> iterator() {return new ListItr();}
    //public Iterator<E> iterator() {return null;}


/** ********************************************************************************************************************/

    /** NUM1 */
    @Override
    public String toString() { //NUM1
        //return null;
        String r = "[";
       // String p = ""; // this is what it'll began with

        if (size >= 1) {
            for (int i = 0; i < size; i++) {
                //x = (String) elementData[i];
                if (i == size - 1) {
                    r += elementData[i];
                } else {
                    r += elementData[i] + ", ";
                }

            }
        }
      r += "]";
        return r;
    }



    /** NUM2*/
   // @Override

    public void add(int index, E element) { //NUM2 should wokrig
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }
        if (size + 1 > elementData.length) {
            Object[] newData = new Object[size * 2 + 1];
            for (int i = 0; i < size; i++) {
                newData[i] = elementData[i];
            }
            elementData = newData;
        }
        for (int i = size; i > index;i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index] = element;
        size ++; // imcriment the size before

    }


    /** NUM3*/
   // @Override
    public E remove(int index) { //NUM3
        if (index < 0 || index >=  size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", list size: " + size);
        }

        E count = (E) elementData[index];
        Object[] newData = new Object[size-1];

        if (index == 0) {
            for (int j = 1; j < size; j++) {
                newData[j-1] = elementData[j];
            }
        }
        if (index == size-1) {
            for (int j = 0; j < size- 1; j++) {
                newData[j] = elementData[j];
            }
        }

        if (index != size - 1 && index != 0) {
            for (int j = 0; j < size - 1; j++) {
                newData[j] = elementData[j];
            }


        for (int j= index +1; j < size; j++) {
            newData[j] = elementData[j];
        }
    }
        elementData =newData;
        size --;
        return count;
        }




    /*** NUM4 */
    //@Override
    public int indexOf(E element) {  //NUM4
        // since it's an arrat this would be easy
        for (int i = 0; i < size ; i++) {//basic for method
            if (elementData[i].equals(element)){
                return i; // this will return the index
            }
        }
        return -1;
    }

    /*** NUM5*/
   // @Override
    public int[] indexesOf(E element) { //NUM5
        //Returns an array of indexes
        int d = 0; // my counter
        int y = 0;
        //int[] array = new int[size];
        //int[] farr = new int[d];


        for (int i = 0; i < size; i++) {//basic for method

            if(Objects.equals(element,(get(i)))) { // from my index of method

                d++;
            }
        }

        int[] array = new int[d];
        for (int i = 0; i < size; i++) {//basic for method

            if (Objects.equals(element,(get(i)))) { // from my index of method
                array[y++] = i;
            }

    }
        return array;
        }

    /*** NUM6 */
   // @Override
    public void reverse() { //NUM6
        int k = size -1; //this is for reversing by adding it to the end
        for(int j=0;j<=k;j++){
            E count = (E) elementData[j];
            elementData[j] = elementData[k];
            elementData[k] = count;
            k--;

        }
    }
/** **************************************************************************************/
private class ListItr implements Iterator<E> {
    private int current;

    ListItr() {
        current = 0;
    }

    @Override
    public boolean hasNext() {
        return current < size;
    }

    @Override
    public E next() {
        return (E) elementData[current++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}

}


