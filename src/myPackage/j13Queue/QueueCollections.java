package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {

  static void queueLinkedList() {
    Queue<Integer> q = new LinkedList<>();

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

  static void queueArrayDeque() {
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

  public static void main(String[] args) {
    queueLinkedList();
    queueArrayDeque();
  }

}
