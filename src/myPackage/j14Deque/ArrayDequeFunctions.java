// add(element): 	This method is used to add an element at the tail of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.

// addFirst(element):	This method is used to add an element at the head of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.

// addLast(element):	This method is used to add an element at the tail of the queue. If the Deque is capacity restricted and no space is left for insertion, it returns an IllegalStateException. The function returns true on successful insertion.

// contains():	This method is used to check whether the queue contains the given object or not.

// descendingIterator():	This method returns an iterator for the deque. The elements will be returned in order from last(tail) to first(head).

// element():	This method is used to retrieve, but not remove, the head of the queue represented by this deque.

// getFirst():	This method is used to retrieve, but not remove, the first element of this deque.

// getLast():	This method is used to retrieve, but not remove, the last element of this deque.

// iterator():	This method returns an iterator for the deque. The elements will be returned in order from first (head) to last (tail).

// offer(element):	This method is used to add an element at the tail of the queue. This method is preferable to add() method since this method does not throws an exception when the capacity of the container is full since it returns false.

// offerFirst(element):	This method is used to add an element at the head of the queue. This method is preferable to addFirst() method since this method does not throws an exception when the capacity of the container is full since it returns false.

// offerLast(element):	This method is used to add an element at the tail of the queue. This method is preferable to add() method since this method does not throws an exception when the capacity of the container is full since it returns false.

// peek():	This method is used to retrieve the element at the head of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.

// peekFirst():	This method is used to retrieve the element at the head of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.

// peekLast():	This method is used to retrieve the element at the tail of the deque but doesn’t remove the element from the deque. This method returns null if the deque is empty.

// poll():	This method is used to retrieve and remove the element at the head of the deque. This method returns null if the deque is empty.

// pollFirst():	This method is used to retrieve and remove the element at the head of the deque. This method returns null if the deque is empty.

// pollLast():	This method is used to retrieve and remove the element at the tail of the deque. This method returns null if the deque is empty.

// pop():	This method is used to remove an element from the head and return it.

// push(element):	This method is used to add an element at the head of the queue.

// removeFirst():	This method is used to remove an element from the head of the queue.

// removeLast():	This method is used to remove an element from the tail of the queue.

// size():	This method is used to find and return the size of the deque.

package myPackage.j14Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class ArrayDequeFunctions {

  static void ArrayDequeAsStack() {
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < 5; i++)
      stack.push(i);

    System.out.println("Elements of stack: " + stack);

    int removedele = stack.pop();
    System.out.println("removed element - " + removedele);

    System.out.println(stack);

    int head = stack.peek();
    System.out.println("top of stack - " + head);

    int size = stack.size();
    System.out.println("Size of stack - " + size);
  }

  static void ArrayDequeAsQueue() {
    Queue<Integer> q = new ArrayDeque<>();

    for (int i = 0; i < 5; i++)
      q.add(i); // q.offer(i)

    System.out.println("Elements of queue: " + q);

    int removedele = q.remove(); // q.poll()
    System.out.println("removed element - " + removedele);

    System.out.println(q);

    int head = q.element(); // q.peek()
    System.out.println("head of queue - " + head);

    int size = q.size();
    System.out.println("Size of queue - " + size);
  }

  static void ArrayDequeAsDeque() {
    Deque<Integer> de_que = new ArrayDeque<Integer>(10);
    de_que.add(10);
    de_que.add(20);
    de_que.add(30);
    de_que.add(40);
    de_que.add(50);
    System.out.println(de_que);
    System.out.println(de_que.remove());
    System.out.println(de_que.remove());
    System.out.println(de_que.remove());
    System.out.println(de_que);
    de_que.offer(15);
    de_que.offer(25);
    de_que.offer(35);
    de_que.offer(45);
    System.out.println(de_que);
    de_que.poll();
    de_que.poll();
    System.out.println(de_que);
    de_que.poll();
    de_que.poll();
    de_que.poll();
    System.out.println(de_que);
    System.out.println(de_que.peek());
    System.out.println(de_que.element());
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      ArrayDequeAsStack();
      ArrayDequeAsQueue();
      ArrayDequeAsDeque();
    }
  }
}
