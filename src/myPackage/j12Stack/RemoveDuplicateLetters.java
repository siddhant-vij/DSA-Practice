// Leetcode: 316. Remove Duplicate Letters
// Leetcode: 1081. Smallest Subsequence of Distinct Characters

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RemoveDuplicateLetters {

  static String removeDuplicateLetters(String str) {
    int[] count = new int[26];
    boolean[] visited = new boolean[26];
    int n = str.length();
    for (int i = 0; i < n; i++) {
      count[str.charAt(i) - 'a']++;
    }
    Deque<Character> stack = new ArrayDeque<>();
    int idx;
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      idx = ch - 'a';
      count[idx]--;
      if (visited[idx])
        continue;
      while (!stack.isEmpty() && ch < stack.peek() && count[stack.peek() - 'a'] != 0) {
        visited[stack.pop() - 'a'] = false;
      }
      stack.push(ch);
      visited[idx] = true;
    }

    StringBuilder strB = new StringBuilder();
    while (!stack.isEmpty()) {
      strB.append(stack.pop());
    }
    return strB.reverse().toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(removeDuplicateLetters(str));
    }
  }  
}
