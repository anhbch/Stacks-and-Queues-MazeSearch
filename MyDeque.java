
/**
 * Name: Anh Bach
 * Email: tbach@ucsd.edu
 * Sources used: Oracle, Lecture Slides
 * 
 * This file contains a MyDeque class, which is an implementation 
 * for the DequeInterface. Elements can be added/removed 
 * and peek from the queue
 */

 /**
  * This class implements DequeInterface. It contains
  * methods to add/remove and peek element
  * @param size - number of elements 
  * @param rear - index of last element
  * @param front - index of first element
  * @param DEFAUL_CAPACITY - default capacity
  */
public class MyDeque<E> implements DequeInterface<E> {
    
    Object[] data;
    int size; // number of valid elements
    int rear; 
    int front;

    // Constant Variable
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Initialize variables of MyDeque
     * @param initialCapacity - capacity of the Deque
     * @param size - number of elements 
     * @param rear - index of last element
     * @param front - index of first element
     */
    public MyDeque(int initialCapacity) {
        // Exception
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        // Constructor
        this.data = new Object[initialCapacity];
        this.size = 0;
        this.rear = 0;
        this.front = 0;
    }

    /**
     * Number of elements in the deque
     * @return number of elements that exist in the deque
     */
    public int size() {
        return this.size;
    }

    /**
     * Doubles the current capacity
     * If the capacity is 0, 
     * set the capacity to a default value of 10
     * */
    public void expandCapacity() {
        // New capacity of Deque
        int newCapacity = 0;
        // Capacity is 0
        if (data == null || data.length == 0) {
            newCapacity = DEFAULT_CAPACITY;
            // Update front and rear
            front = 0;
            rear = 0;
        }
        else {
            // Doubles the current capacity
            newCapacity = 2 * data.length;
            // Update front and rear
            front = 0;
            rear = size - 1;
        }

        // New array with new capacity 
        Object[] temp = new Object[newCapacity];
        // Copy elements from data to temp array
        for (int i = 0; i < this.size; i++) {
            temp[i] = data[(front + i) % data.length];
        }
        // Copy datas from temp array to data with new capacity
        this.data = temp;
    }

    /**
     * Add the specified element to the front of the deque
     * @param element - new element need to be added
     */
    public void addFirst(E element) {
        // Exception
        if (element == null) {
            throw new NullPointerException();
        }
 
        // Check if the deque is at capacity 
        if (this.size == data.length) {
            expandCapacity();
        }
        
        // Check location of front and update
        if (size != 0) {
            if (front == 0) {
                front = data.length - 1; // Wrap arround
            }
            else {
                front--;
            }
        }

        // Add an element to the front of the list
        data[front] = element;

        // Increase size
        this.size++;
    }

    /**
     * Add the specified element to the end of the deque
     * @param element - new element need to be added
     */
    public void addLast(E element) {
        // Exception
        if (element == null) {
            throw new NullPointerException();
        }

        // Check if the deque is at capacity 
        if (this.size == data.length) {
            expandCapacity();
        }

        // Check location of rear and update
        if (size != 0) {
            if (rear == data.length-1) {
                rear = 0; // Wrap arround
            }
            else {
                rear++;
            }
        }

        // Add element to the end
        data[rear] = element;

        // Increase size
        this.size++;
    }

    /**
     * Removes and returns the element 
     * at the front of the deque
     * @return the element at the front of the deque,
     * return null if there are no such elements
     */
    @SuppressWarnings("unchecked")
    public E removeFirst() {
        // No elements in the deque
        if (data == null || data.length == 0) {
            return null;
        }

        // Variable to hold removed element
        E firstElement = (E)data[front];
        // Remove element
        data[front] = null;
   
        // Decrease size
        this.size--;
        // Update front
        if (size != 0) {
            if (front == data.length-1) {
                front = 0;
            }
            else {
                front++;
            }
        }

        return firstElement;
    }

    /**
     * Removes and returns the element 
     * at the end of the deque
     * @return the element at the end of the deque,
     * return null if there are no such elements
     */
    @SuppressWarnings("unchecked")
    public E removeLast() {
         // No elements in the deque
         if (data == null || data.length == 0) {
            return null;
        }

        // Variable to hold removed element
        E lastElement = (E)data[rear];
        // Remove element
        data[rear] = null;

        // Decrease size
        this.size--;
        // Update rear
        if (size != 0) {
            if (rear == 0) {
                rear = data.length-1;
            }
            else {
               rear--;
            }
        } 

        return lastElement;
    }

    /**
     * Return the element at the front of the deque 
     * @return front element, null if there are no
     * elements in the deque
     */
    @SuppressWarnings("unchecked")
    public E peekFirst() {
        // No elements in the deque
        if (data == null || data.length == 0) {
            return null;
        }

        // Variable to hold removed element
        E firstElement = (E)data[front];

        return firstElement;
    }

    /**
     * Return the element at the end of the deque 
     * @return rear element, null if there are no
     * elements in the deque
     */
    @SuppressWarnings("unchecked")
    public E peekLast() {
        // No elements in the deque
        if (data == null || data.length == 0) {
            return null;
        }

        // Variable to hold removed element
        E lastElement = (E)data[rear];

        return lastElement;
    }
}
