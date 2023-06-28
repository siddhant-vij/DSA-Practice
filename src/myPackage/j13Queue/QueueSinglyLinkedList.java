package myPackage.j13Queue;

import java.util.Scanner;

class QueueSLL {

  private Node front;
  private Node rear;
  private int size;

  class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
      size++;
    }
  }

  QueueSLL() {
    size = 0;
    this.front = this.rear = null;
  }

  boolean isEmpty() {
    return this.front == null;
  }

  void enqueue(int item) {
    Node newNode = new Node(item);
    if (this.isEmpty()) {
      this.front = newNode;
      this.rear = newNode;
    }
    this.rear.next = newNode;
    this.rear = newNode;
  }

  int dequeue() {
    if (this.isEmpty())
      return Integer.MIN_VALUE;
    int val = this.front.val;
    this.front = this.front.next;
    if (this.front == null)
      this.rear = null;
    return val;
  }

  int getFront() {
    if (this.isEmpty())
      return Integer.MIN_VALUE;
    return this.front.val;
  }

  int getRear() {
    if (this.isEmpty())
      return Integer.MIN_VALUE;
    return this.rear.val;
  }

  int getSize() {
    return this.size;
  }

  void printQueue() {
    if (this.isEmpty()) {
      System.out.println("Empty Queue");
      return;
    }
    Node cur = this.front;
    while (cur != null) {
      System.out.print(cur.val + " ");
      cur = cur.next;
    }
    System.out.println();
  }
}

public class QueueSinglyLinkedList {

  static void printMenu() {
    System.out.println("1: Inserting element to queue(enqueue)");
    System.out.println("2: Deleting element from queue(dequeue)");
    System.out.println("3: Display front element of queue");
    System.out.println("4: Display rear element of queue");
    System.out.println("5: Display all the elements of queue");
    System.out.println("9: Exit");
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      QueueSLL queue = new QueueSLL();
      int ch;
      do {
        printMenu();
        System.out.println("Enter your choice : ");
        ch = sc.nextInt();
        switch (ch) {
          case 1: {
            System.out.println("enter element to be inserted:");
            int item = sc.nextInt();
            queue.enqueue(item);
            break;
          }
          case 2:
            int val = queue.dequeue();
            if (val != Integer.MIN_VALUE)
              System.out.println(val + " removed from the queue");
            else
              System.out.println("Pls. check - the queue is empty");
            break;
          case 3:
            if (queue.getFront() != Integer.MIN_VALUE)
              System.out.println("Front Element: " + queue.getFront());
            else
              System.out.println("Empty Queue");
            break;
          case 4:
            if (queue.getRear() != Integer.MIN_VALUE)
              System.out.println("Front Element: " + queue.getRear());
            else
              System.out.println("Empty Queue");
            break;
          case 5:
            queue.printQueue();
            break;
          case 9:
            System.out.println("Exit");
            break;
          default:
            System.out.println("Invalid choice");
        }
      } while (ch != 9);
    }
  }

}
