/**
 * Name: Anh Bach
 * Email: tbach@ucsd.edu
 * Sources used: Oracle, Lecture Slides
 * 
 * This file contains all the custom tests to test 
 * MyDeque, MyStack and MyQueue
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains custom test cases for MyDeque, MyStack, and MyQueue
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    private static String EXCEPTION = "Exception is thrown!";
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initial capacity < 0
     */
    @Test
    public void testMyDequeConstructor() {
         try {
            MyDeque<Integer> deque = new MyDeque<>(-1);
            fail();
         }
         catch (IllegalArgumentException e) {
            System.out.println(EXCEPTION);
         }
    }

    /**
     * Test the expandCapacity method when capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(0);

        deque.expandCapacity();
        assertEquals("Capacity should be 10", 10, deque.data.length);
        assertEquals("Size should not have changed", 0, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 0, deque.rear);
    }

    /**
     * Test the addFirst method when the deque only have 1 element
     * at index 0
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals("Capacity should be 5", 5, deque.data.length);
        assertEquals("Size should not have changed", 0, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 0, deque.rear);
        deque.addLast(0);

        deque.addFirst(10);
        Integer[] data = {0,null,null,null,10};
        assertArrayEquals(data, deque.data);
        assertEquals("Capacity should be 5", 5, deque.data.length);
        assertEquals("Size should be 2", 2, deque.size);
        assertEquals("Front should be 4", 4, deque.front);
        assertEquals("Rear should be 0", 0, deque.rear);


    }

    /**
     * Test the addLast method when the deque doesn't have any element
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        assertEquals("Capacity should be 5", 5, deque.data.length);
        assertEquals("Size should not have changed", 0, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 0, deque.rear);

        deque.addLast(0);
        Integer[] data = {0,null,null,null,null};
        assertArrayEquals(data, deque.data);
        assertEquals("Capacity should be 5", 5, deque.data.length);
        assertEquals("Size should be 1", 1, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 0, deque.rear);


    }

    /**
     * Test the removeFirst method when elements are at the 
     * beggining of the deque
     */
    @Test
    public void testRemoveFirst() {
        // Initial deque
        MyDeque<Integer> deque = new MyDeque<>(10);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        Integer[] data = {1,2,3,4,5,null,null,null,null,null};
        assertArrayEquals(data, deque.data);
        assertEquals("Capacity should be 10", 10, deque.data.length);
        assertEquals("Size should be 5", 5, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 4", 4, deque.rear);

        // Test remove first
        deque.removeFirst();
        Integer[] data2 = {null,2,3,4,5,null,null,null,null,null};
        assertArrayEquals(data2, deque.data);
        assertEquals("Capacity should be 10", 10, deque.data.length);
        assertEquals("Size should be 4", 4, deque.size);
        assertEquals("Front should be 1", 1, deque.front);
        assertEquals("Rear should be 4", 4, deque.rear);


    }

    /**
     * Test the removeLast method when there are element in the
     * begginning and the end of the deque
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        deque.addLast(0);
        deque.addFirst(10);

        // Test remove last
        deque.removeLast();
        Integer[] data = {null,null,null,null,10};
        assertArrayEquals(data, deque.data);
        assertEquals("Capacity should be 5", 5, deque.data.length);
        assertEquals("Size should be 1", 1, deque.size);
        assertEquals("Front should be 4", 4, deque.front);
        assertEquals("Rear should be 4", 4, deque.rear);

        deque.removeLast();
        Integer[] data2 = {null,null,null,null,null};
        assertArrayEquals(data2, deque.data);
        assertEquals("Capacity should be 5", 5, deque.data.length);
        assertEquals("Size should be 0", 0, deque.size);
        assertEquals("Front should not be changed", 4, deque.front);
        assertEquals("Rear should not be changed", 4, deque.rear);
    }

    /**
     * Test the peekFirst method when there are element in the
     * begginning and the end of the deque
     */
    @Test
    public void testPeekFirst(){
        // Initial deque
        MyDeque<Integer> deque = new MyDeque<>(10);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        Integer[] data = {1,2,3,4,5,null,null,null,null,null};
        assertArrayEquals(data, deque.data);
        assertEquals("Capacity should be 10", 10, deque.data.length);
        assertEquals("Size should be 5", 5, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 4", 4, deque.rear);

        // Test peek first
        assertEquals("Peek should be 1", 1, (int)deque.peekFirst());
    }

    /**
     * Test the peekLast method when there are element in the
     * begginning and the end of the deque
     */
    @Test
    public void testPeekLast(){
        // Initial deque
        MyDeque<Integer> deque = new MyDeque<>(10);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        Integer[] data = {1,2,3,4,5,null,null,null,null,null};
        assertArrayEquals(data, deque.data);
        assertEquals("Capacity should be 10", 10, deque.data.length);
        assertEquals("Size should be 5", 5, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 4", 4, deque.rear);

        // Test peek last
        assertEquals("Peek should be 5", 5, (int)deque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack with combination of methods with
     * descriptions in comment 
     */
    @Test
    public void testMyStack(){
        // Create an empty stack
        MyStack<Integer> stack = new MyStack<>(5);

        // Capacity
        assertEquals("Capacity should be 5", 5, stack.theStack.data.length);
        // Test is empty
        assertTrue("Stack is empty", stack.empty());
        // Size
        assertEquals("Size should be 0", 0, stack.size());
        // Test push multiple integers into empty stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Size
        assertEquals("Size should be 3", 3, stack.size());
        Integer[] data = {1,null,null,3,2};
        assertArrayEquals(data, stack.theStack.data);
        // Test peek
        assertEquals("Should be 3", 3, stack.theStack.front);
        // Pop the last element (LIFO)
        assertEquals(3, (int)stack.pop());

        MyStack<Integer> stack1 = new MyStack<>(5);
        // Test pop on an empty stack
        assertNull(stack1.pop());
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when combination of methods with
     * descriptions in comment 
     */
    @Test
    public void testMyQueue(){
        // Create an empty stack
        MyQueue<Integer> queue = new MyQueue<>(5);
        // Capacity
        assertEquals("Capacity should be 5", 5, queue.theQueue.data.length);
        // Test is empty
        assertTrue("Queue is empty", queue.empty());
        // Size
        assertEquals("Size should be 0", 0, queue.size());
        // Peek empty queue
        assertNull(queue.peek());
        // Test enqueue multiple integers into empty queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        // Size
        assertEquals("Size should be 3", 3, queue.size());
        Integer[] data = {1,2,3,null,null};
        assertArrayEquals(data, queue.theQueue.data);
        // Test is empty
        assertFalse("Queue is not empty", queue.empty());
        // Dequeue the first element (FIFO)
        assertEquals(1, (int)queue.dequeue());
    }
}
