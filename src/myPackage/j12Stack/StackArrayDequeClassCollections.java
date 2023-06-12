// Stack Implementation: Collections - ArrayDeque

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class StackArrayDequeClassCollections {

  public static void main(String[] args) {
    // Creating and initializing deque
    // Declaring object of integer type
    Deque<Integer> de_que = new ArrayDeque<Integer>(10);

    // Operations 1
    // add() method
    de_que.add(10);
    de_que.add(20);
    de_que.add(30);
    de_que.add(40);
    de_que.add(50);

    // Iterating using for each loop
    for (Integer element : de_que) {
      System.out.println("Element : " + element);
    }

    // Operation 2
    // clear() method
    System.out.println("Using clear() ");
    de_que.clear();

    // Display message
    System.out.println("Above elements are removed now");

    // Operations 3
    // addFirst() method
    de_que.addFirst(564);
    de_que.addFirst(291);

    // Operation 4
    // addLast() method
    de_que.addLast(24);
    de_que.addLast(14);

    // Iterators
    // Display message
    System.out.println("Elements of deque using Iterator :");

    for (Iterator<Integer> itr = de_que.iterator(); itr.hasNext();) {
      System.out.println(itr.next());
    }

    // descendingIterator()
    // To reverse the deque order
    System.out.println("Elements of deque in reverse order :");

    for (Iterator<Integer> dItr = de_que.descendingIterator(); dItr.hasNext();) {
      System.out.println(dItr.next());
    }

    // Operation 5
    // element() method : to get Head element
    System.out.println("\nHead Element using element(): " + de_que.element());

    // Operation 6
    // getFirst() method : to get Head element
    System.out.println("Head Element using getFirst(): " + de_que.getFirst());

    // Operation 7
    // getLast() method : to get last element
    System.out.println("Last Element using getLast(): " + de_que.getLast());

    // Operation 8
    // toArray() method :
    Object[] arr = de_que.toArray();
    System.out.println("\nArray Size : " + arr.length);

    System.out.print("Array elements : ");

    for (int i = 0; i < arr.length; i++)
      System.out.print(" " + arr[i]);

    // Operation 9
    // peek() method : to get head
    System.out.println("\nHead element : " + de_que.peek());

    // Operation 10
    // poll() method : to get head
    System.out.println("Head element poll : " + de_que.poll());

    // Operation 11
    // push() method
    de_que.push(265);
    de_que.push(984);
    de_que.push(2365);

    // Operation 12
    // remove() method : to get head
    System.out.println("Head element remove : " + de_que.remove());

    System.out.println("The final array is: " + de_que);
  }
}
