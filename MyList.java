/**
 * Nick Tinsley
 * Programming Assignment 4
 * March 25, 2017
 */
package assignmentfour;

/** 
 * @author Nick Tinsley
 */
public interface MyList<E> {
    /**
     * Add a new element at the end of this list
     *
     * @param e
     */
    public void add(E e);

    /**
     * Add a new element at the specified index in this list
     *
     * @param index
     * @param e
     */
    public void add(int index, E e);

    /**
     * Clear the list
     */
    public void clear();

    /**
     * Return true if this list contains the element
     *
     * @param e
     * @return
     */
    public boolean contains(E e);

    /**
     * Return the element from this list at the specified index
     *
     * @param index
     * @return
     */
    public E get(int index);

    /**
     * Return the index of the first matching element in this list. Return -1 if
     * no match.
     *
     * @param e
     * @return
     */
    public int indexOf(E e);

    /**
     * Return true if this list contains no elements
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Return the index of the last matching element in this list Return -1 if
     * no match.
     *
     * @param e
     * @return
     */
    public int lastIndexOf(E e);

    /**
     * Remove the first occurrence of the element o from this list. Shift any
     * subsequent elements to the left. Return true if the element is removed.
     *
     * @param e
     * @return
     */
    public boolean remove(E e);

    /**
     * Remove the element at the specified position in this list Shift any
     * subsequent elements to the left. Return the element that was removed from
     * the list.
     *
     * @param index
     * @return
     */
    public E remove(int index);

    /**
     * Replace the element at the specified position in this list with the
     * specified element and returns the new set.
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e);

    /**
     * Return the number of elements in this list
     *
     * @return
     */
    public int size();
}