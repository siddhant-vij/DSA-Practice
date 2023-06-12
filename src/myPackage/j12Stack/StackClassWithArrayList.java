// Stack Implementataion: ArrayList

package myPackage.j12Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class StackClassWithArrayList {

  ArrayList<Integer> list;

  StackClassWithArrayList() {
    list = new ArrayList<>();
  }

  void push(int val) {
    list.add(val);
  }

  int pop() {
    if (isEmpty()) {
      System.out.println("Stack Empty");
      return Integer.MAX_VALUE;
    }
    int val = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    return val;
  }

  int size() {
    return list.size();
  }

  int peek() {
    if (isEmpty()) {
      System.out.println("Stack Empty");
      return Integer.MAX_VALUE;
    }
    return list.get(list.size() - 1);
  }

  boolean isEmpty() {
    return list.isEmpty();
  }

  void print() {
    if (isEmpty()) {
      System.out.println("Stack Empty");
      return;
    }
    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      StackClassWithArrayList st = new StackClassWithArrayList();
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
      st.push(5);
      System.out.println(st.size());
      st.print();
    }
  }
}
