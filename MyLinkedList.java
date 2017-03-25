/**
 * Nick Tinsley
 * Programming Assignment 4
 * March 25, 2017
 */
package assignmentfour;

/** 
 * @author Nick Tinsley
 */
public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;//instantiate head and tail

    /**
     * Create default list.
     */
    public MyLinkedList() {
    }//MyLinkedList

    /**
     * Create a list from an array of objects.
     */
    public MyLinkedList(E[] objects) {
        super(objects);
    }//MyLinkedList

    /**
     * Return the head element in the list.
     */
    public E getFirst() {
        if (size == 0) {
            return null;
        }//if 
        else {
            return head.element;
        }//else
    }//getFirst

    /**
     * Return the last element in the list.
     */
    public E getLast() {
        if (size == 0) {
            return null;
        }//if 
        else {
            return tail.element;
        }//else
    }//getLast

    /**
     * Add an element to the beginning of the list.
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size
        if (tail == null) { // the new node is the only node in list
            tail = head;
        }//if
    }//addFirst

    /**
     * Add an element to the end of the list.
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e
        if (tail == null) {
            head = tail = newNode; // The new node is the only node in list
        }//if
        else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }//else
        size++; // Increase size
    }//addLast

    /**
     * Add a new element at the specified index in this list.
     */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        }//if 
        else if (index >= size) {
            addLast(e);
        }//if 
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }//for
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }//else
    }//add

    /**
     * Remove the head node and return the object that is contained in the removed node.
     */
    public E removeFirst() {
        if (size == 0) {
            return null;
        }//if 
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }//if
            return temp.element;
        }//else
    }//remove

    /**
     * Remove the last node and return the object that is contained in the removed node. 
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        }//if 
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }//else if 
        else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }//else
    }//removeLast

    /**
     * Remove the element at the specified position in this list. Return the 
     * element that was removed from the list. 
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }//if 
        else if (index == 0) {
            return removeFirst();
        }//else if 
        else if (index == size - 1) {
            return removeLast();
        }//else if
        else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }//for
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }//else
    }//remove

    /**
     * Override toString() to return elements in the list.
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }//if
            else {
                result.append("]"); // Insert the closing ] in the string
            }//else
        }//for
        return result.toString();
    }//toString

    /**
     * Clear the list.
     */
    public void clear() {
        head = tail = null;
    }//clear

    /**
     * This method will search to see if the list contains a certain element. It will
     * return true if it does contain it and false if it does not contain it.
     * 
     * @param e : the element that is being searched for
     * @return : true or false for whether the element is in the list
     */
    public boolean contains(E e) {
        Node<E> temp = head;
        while(temp != null){
            if (e.equals(temp.element)) {
                return true;//true if in list
            }//if
            temp = temp.next;
        }//while
        return false;//false if not in list
    }//contains
    
    /**
     * Overloaded contains method that will allow us to count number of comparisons in
     * client. Sill returns true if word is contained in list and false if it is not.
     * 
     * @param e : the element that is being searched for
     * @param count : integer array for number of comparisons
     * @return : true or false for whether the element is in the list
     */
    public boolean contains(E e, int[] count){
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            count[0]++;
            if(e.equals(temp.element)){
                count[0]=i+1;
                return true;
            }//if
            temp = temp.next;
        }//for
        return false;
    }//contains

    /**
     * This method will get the element at a specific index of the list. 
     * 
     * @param index : position in the list that to be looked at
     * @return : the element at the position being looked at
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;//out of bounds
        }//if
        else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }//for
            return temp.element;//element at index
        }//else
    }//get

    /**
     * This method will get the index of a certain element in the list if it is 
     * contained in the list.
     * 
     * @param e : an element that is being searched for its index
     * @return : the index at which an element occurs
     */
    public int indexOf(E e) {
        int count = -1;
        Node<E> temp = head;
        while (temp != null) {
            if (temp.element.equals(e)) {
                return count+1;
            }//if
            count++;
            temp = temp.next;
        }//while
        return count;
    }//indexOf

    /**
     * This method will get the index of a certain element in the list at the last 
     * occurrence of the element if the element is contained in the list.
     * 
     * @param e : an element that is being searched for its index
     * @return : the index at which the element occurs last
     */
    public int lastIndexOf(E e) {
        int ans = -1;
        Node<E> temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.element.equals(e)) {
                ans = count;
            }//if
            count++;
            temp = temp.next;
        }//while
        return ans;
    }//lastIndexOf

    /**
     * This method will set the element at a specific index to a specific element.
     * It will replace the old element at this index with the new one.
     * 
     * @param index : position in the list that is being set to an element
     * @param e : the element that is going to be set in the index
     * @return : the corrected list with the set element at the specific index
     */
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }//if 
        else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }//for
            E old = temp.element;
            temp.element = e;
            return old;
        }//else
    }//set

    private class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }//Node
    }//class Node
}//class
