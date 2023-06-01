// Leetcode: 1678. Goal Parser Interpretation

package myPackage.j10Strings;

import java.util.Scanner;

public class GoalParserInterpretation {

  static String interpret(String command) {
    int n = command.length();
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < n;) {
      if (command.charAt(i) == 'G') {
        strB.append('G');
        i++;
      } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
        strB.append('o');
        i += 2;
      } else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a' && command.charAt(i + 2) == 'l'
          && command.charAt(i + 3) == ')') {
        strB.append("al");
        i += 4;
      }
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(interpret(str));
    }
  }  
}
