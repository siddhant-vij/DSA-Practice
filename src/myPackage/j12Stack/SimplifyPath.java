// Leetcode: 71. Simplify Path

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {

  static String simplifyPath(String path) {
    Stack<String> s = new Stack<>();
    StringBuilder res = new StringBuilder();
    String[] p = path.split("/");

    for (int i = 0; i < p.length; i++) {
      if (!s.isEmpty() && p[i].equals(".."))
        s.pop();
      else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
        s.push(p[i]);
    }

    if (s.isEmpty())
      return "/";
    while (!s.isEmpty()) {
      res.insert(0, s.pop()).insert(0, "/");
    }

    return res.toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(simplifyPath(str));
    }
  }  
}
