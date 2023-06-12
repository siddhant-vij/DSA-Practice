// Stack Implementation: Singly Linked List

package myPackage.j12Stack;

import java.util.Scanner;

public class StackClassSinglyLinkedList {

  Node top;
  int size;

  class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
      size++;
    }
  }

  StackClassSinglyLinkedList() {
    size = 0;
  }

  void push(int val) {
    Node newNode = new Node(val);
    newNode.next = top;
    top = newNode;
  }

  int pop() {
    if (isEmpty()) {
      System.out.println("Empty Stack");
      return Integer.MAX_VALUE;
    }
    int val = top.val;
    top = top.next;
    size--;
    return val;
  }

  int size() {
    return size;
  }

  int peek() {
    if (isEmpty()) {
      System.out.println("Empty Stack");
      return Integer.MAX_VALUE;
    }
    return top.val;
  }

  boolean isEmpty() {
    return top == null;
  }

  void print() {
    if (isEmpty()) {
      System.out.println("Empty Stack");
      return;
    }
    Node cur = top;
    while (cur != null) {
      System.out.print(cur.val + " ");
      cur = cur.next;
    }
    System.out.println();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      StackClassSinglyLinkedList st = new StackClassSinglyLinkedList();
      // System.out.println(st.pop());
      st.push(1);
      st.push(2);
      st.push(3);
      st.push(4);
      System.out.println(st.size());
      st.print();
      System.out.println(st.pop());
      System.out.println(st.pop());
      st.print();
      System.out.println(st.size());
      st.push(5);
      st.print();
      System.out.println(st.size());
    }
  }

}
