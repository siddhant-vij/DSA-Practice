// Practice: Generate Increasing Numbers From Set 

package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

public class PrintFirstKNumsDigitsInSet {

  static void printFirstKNums(int k, HashSet<String> set) {
    Queue<String> queue = new ArrayDeque<>();
    for (String element : set) {
      queue.add(element);
    }
    for (int i = 0; i < k; i++) {
      String cur = queue.remove();
      System.out.print(cur + " ");
      for (String element : set) {
        queue.add(cur + element);
      }
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int k = sc.nextInt();
      int n = sc.nextInt();
      HashSet<String> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        set.add(sc.next());
      }
      printFirstKNums(k, set);
    }
  }
}
