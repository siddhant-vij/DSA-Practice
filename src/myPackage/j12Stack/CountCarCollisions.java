// Leetcode: 2211. Count Collisions on a Road

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CountCarCollisions {
  
  static int countCollisions(String str) {
    int count = 0;
    int n = str.length();
    Deque<Character> stack = new ArrayDeque<>();
    stack.push(str.charAt(0));
    for (int i = 1; i < n; i++) {
      char ch = str.charAt(i);
      if ((stack.peek() == 'R' && ch == 'L')) {
        count += 2;
        stack.pop();
        ch = 'S';
      } else if ((stack.peek() == 'S' && ch == 'L')) {
        ch = 'S';
        count++;
      }
      while (!stack.isEmpty() && ((stack.peek() == 'R' && ch == 'S'))) {
        count++;
        stack.pop();
      }
      stack.push(ch);
    }
    return count;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(countCollisions(str));
    }
  }
}
