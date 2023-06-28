package myPackage.j13Queue;

import java.util.Scanner;

class QueueClassArray {
  private int front, rear;
  private int capacity;
  private int queue[];

  QueueClassArray(int capacity) {
    this.capacity = capacity;
    this.front = -1;
    this.rear = -1;
    queue = new int[this.capacity];
  }

  boolean isFull() {
    return this.rear == this.capacity - 1;
  }

  boolean isEmpty() {
    return this.front == -1 || this.front > this.rear;
  }

  void enqueue(int item) {
    if (this.isFull()) {
      System.out.println("Pls. check - the queue is full");
      return;
    }
    if (this.front == -1 && this.rear == -1) {
      this.front = 0;
      this.rear = 0;
    } else {
      this.rear++;
    }
    this.queue[this.rear] = item;
  }

  int dequeue() {
    if (this.isEmpty())
      return Integer.MIN_VALUE;
    int item = this.queue[this.front];
    if (front == rear) {
      this.front = -1;
      this.rear = -1;
    } else {
      this.front++;
    }
    return item;
  }

  int getFront() {
    if (this.isEmpty())
      return Integer.MIN_VALUE;
    return this.queue[this.front];
  }

  int getRear() {
    if (this.isEmpty())
      return Integer.MIN_VALUE;
    return this.queue[this.rear];
  }

  void printQueue() {
    if (this.isEmpty()) {
      System.out.println("Queue is empty");
      return;
    } else {
      System.out.println("Elements are : ");
      for (int i = this.front; i <= this.rear; i++)
        System.out.print(this.queue[i] + " ");
      System.out.println();
    }
  }
}

public class SimpleQueueArrays {

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
      System.out.println("Enter max. capacity of the Queue");
      int n = sc.nextInt();
      QueueClassArray queue = new QueueClassArray(n);
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
            System.out.println("Front Element: " + queue.getFront());
            break;
          case 4:
            System.out.println("Rear Element: " + queue.getRear());
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
