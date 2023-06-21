// Leetcode: 856. Score of Parentheses

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ScoreOfParenthesis {

  static int scoreOfParentheses(String s) {
    Deque<Integer> st = new ArrayDeque<>();
    int score = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        st.push(score);
        score = 0;
      } else {
        score = st.pop() + Math.max(2 * score, 1);
      }
    }
    return score;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(scoreOfParentheses(str));
    }
  }
}
