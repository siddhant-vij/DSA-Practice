package myPackage.j14Deque;

import java.util.Scanner;

class DequeCircularArray {
  private int arr[];
  private int front;
  private int rear;
  private int size;
  private int capacity;

  public DequeCircularArray(int capacity) {
    this.size = 0;
    this.front = -1;
    this.rear = -1;
    this.capacity = capacity;
    this.arr = new int[this.capacity];
  }

  public void insertFront(int val) {
    if (this.isFull()) {
      System.out.println("Queue is full");
      return;
    }
    this.size++;
    if (isEmpty()) {
      this.front = 0;
      this.rear = 0;
    } else {
      if (this.front == 0) {
        this.front = this.capacity - 1;
      } else {
        this.front--;
      }
    }
    arr[this.front] = val;
  }

  public void insertEnd(int val) {
    if (this.isFull()) {
      System.out.println("Queue is full");
      return;
    }
    this.size++;
    if (isEmpty()) {
      this.front = 0;
      this.rear = 0;
    } else {
      if (this.rear == this.capacity - 1) {
        this.rear = 0;
      } else {
        this.rear++;
      }
    }
    arr[this.rear] = val;
  }

  public int deleteFront() {
    if (this.isEmpty()) {
      return Integer.MIN_VALUE;
    }
    int item = this.arr[this.front];
    this.size--;
    if (this.front == this.rear) {
      this.front = -1;
      this.rear = -1;
    } else {
      if (this.front == this.capacity - 1) {
        this.front = 0;
      } else {
        this.front++;
      }
    }
    return item;
  }

  public int delelteEnd() {
    if (this.isEmpty()) {
      return Integer.MIN_VALUE;
    }
    int item = this.arr[this.rear];
    this.size--;
    if (this.front == this.rear) {
      this.front = -1;
      this.rear = -1;
    } else {
      if (this.rear == 0) {
        this.rear = this.capacity - 1;
      } else {
        this.rear--;
      }
    }
    return item;
  }

  public boolean isFull() {
    return (this.rear + 1) % this.capacity == this.front;
  }

  public boolean isEmpty() {
    return this.front == -1;
  }

  public int getSize() {
    return this.size;
  }

  public int getFront() {
    return this.isEmpty() ? Integer.MIN_VALUE : this.arr[this.front];
  }

  public int getRear() {
    return this.isEmpty() ? Integer.MIN_VALUE : this.arr[this.rear];
  }

  void printQueue() {
    if (this.isEmpty()) {
      System.out.println("Queue is empty");
      return;
    } else {
      System.out.println("Elements are : ");
      int i = this.front;
      if (this.front < this.rear) {
        while (i <= this.rear) {
          System.out.print(this.arr[i] + " ");
          i = i + 1;
        }
      } else {
        while (i != this.rear) {
          System.out.print(this.arr[i] + " ");
          i = (i + 1) % this.capacity;
        }
        System.out.print(this.arr[i] + " ");
      }
      System.out.println();
    }
  }
}

public class DequeUsingCircularArray {
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
      System.out.println("Enter the max capacity of Queue:");
      int n = sc.nextInt();
      DequeCircularArray queue = new DequeCircularArray(n);
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
