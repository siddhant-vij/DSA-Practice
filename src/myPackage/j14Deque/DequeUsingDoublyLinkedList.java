package myPackage.j14Deque;

import java.util.Scanner;

class DequeDLL {
  private Node front;
  private Node rear;
  private int size;

  class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
      this.val = val;
      size++;
    }
  }

  public DequeDLL() {
    this.size = 0;
    this.front = rear = null;
  }

  private void insertEmpty(int val) {
    Node newNode = new Node(val);
    this.front = newNode;
    this.rear = newNode;
  }

  public void insertFront(int val) {
    if (this.isEmpty()) {
      insertEmpty(val);
      return;
    }
    Node newNode = new Node(val);
    newNode.next = this.front;
    this.front.prev = newNode;
    this.front = newNode;
  }

  public void insertEnd(int val) {
    if (this.isEmpty()) {
      insertEmpty(val);
      return;
    }
    Node newNode = new Node(val);
    newNode.prev = this.rear;
    this.rear.next = newNode;
    this.rear = newNode;
  }

  private int removeBase() {
    return Integer.MIN_VALUE;
  }

  public int deleteFront() {
    if (this.isEmpty()) {
      return removeBase();
    }
    this.size--;
    if (this.front.next == null) {
      int val = this.front.val;
      this.front = null;
      this.rear = null;
      return val;
    }
    int val = this.front.val;
    this.front = this.front.next;
    this.front.prev = null;
    return val;
  }

  public int delelteEnd() {
    if (this.isEmpty()) {
      return removeBase();
    }
    this.size--;
    if (this.front.next == null) {
      int val = this.front.val;
      this.front = null;
      this.rear = null;
      return val;
    }
    int val = this.rear.val;
    this.rear = this.rear.prev;
    this.rear.next = null;
    return val;
  }

  public boolean isEmpty() {
    return this.front == null;
  }

  public int getSize() {
    return this.size;
  }

  public int getFront() {
    return this.isEmpty() ? Integer.MIN_VALUE : this.front.val;
  }

  public int getRear() {
    return this.isEmpty() ? Integer.MIN_VALUE : this.rear.val;
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

public class DequeUsingDoublyLinkedList {

  static void printMenu() {
    System.out.println("1: Inserting element to Deque(at First)");
    System.out.println("2: Inserting element to Deque(at End)");
    System.out.println("3: Deleting element from Deque(at First)");
    System.out.println("4: Deleting element from Deque(at End)");
    System.out.println("5: Display front element of queue");
    System.out.println("6: Display rear element of queue");
    System.out.println("7: Display all the elements of queue");
    System.out.println("9: Exit");
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      DequeDLL queue = new DequeDLL();
      int ch;
      do {
        printMenu();
        System.out.println("Enter your choice : ");
        ch = sc.nextInt();
        switch (ch) {
          case 1: {
            System.out.println("enter element to be inserted:");
            int item = sc.nextInt();
            queue.insertFront(item);
            break;
          }
          case 2: {
            System.out.println("enter element to be inserted:");
            int item = sc.nextInt();
            queue.insertEnd(item);
            break;
          }
          case 3: {
            int val = queue.deleteFront();
            if (val != Integer.MIN_VALUE)
              System.out.println(val + " removed from the queue");
            else
              System.out.println("Pls. check - the queue is empty");
            break;
          }
          case 4: {
            int val = queue.delelteEnd();
            if (val != Integer.MIN_VALUE)
              System.out.println(val + " removed from the queue");
            else
              System.out.println("Pls. check - the queue is empty");
            break;
          }
          case 5: {
            if (queue.getFront() != Integer.MIN_VALUE)
              System.out.println("Front Element: " + queue.getFront());
            else
              System.out.println("Empty Queue");
            break;
          }
          case 6: {
            if (queue.getRear() != Integer.MIN_VALUE)
              System.out.println("Front Element: " + queue.getRear());
            else
              System.out.println("Empty Queue");
            break;
          }
          case 7:
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
