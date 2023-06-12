// Stack Implementataion: Arrays

package myPackage.j12Stack;

import java.util.Scanner;

public class StackClassWithArrays {

  int[] arr;
  int top;

  StackClassWithArrays(int n) {
    arr = new int[n];
    top = -1;
  }

  void push(int val) {
    if (isFull()) {
      System.out.println("Stack Overflow");
      return;
    }
    top++;
    arr[top] = val;
  }

  int pop() {
    if (isEmpty()) {
      System.out.println("Stack Underflow");
      return Integer.MAX_VALUE;
    }
    int val = arr[top];
    top--;
    return val;
  }

  int size() {
    return (top + 1);
  }

  int peek() {
    if (isEmpty())
      return Integer.MAX_VALUE;
    return arr[top];
  }

  boolean isEmpty() {
    return top == -1;
  }

  boolean isFull() {
    return top == arr.length - 1;
  }

  void print() {
    if (isEmpty()) {
      System.out.println("Stack Empty");
      return;
    }
    for (int i = top; i >= 0; i--) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      StackClassWithArrays st = new StackClassWithArrays(3);
      // st.pop();
      st.push(1);
      st.push(2);
      st.push(3);
      // st.push(4);
      System.out.println(st.size());
      st.print();
      System.out.println(st.pop());
      System.out.println(st.pop());
      st.print();
      st.push(4);
      System.out.println(st.size());
      st.print();
    }
  }
}
