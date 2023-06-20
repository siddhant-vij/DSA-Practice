// Leetcode: 1598. Crawler Log Folder

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CrawlerLogFolders {

  static int minOperations(String[] logs) {
    Deque<String> stack = new ArrayDeque<>();
    int n = logs.length;
    for (int i = 0; i < n; i++) {
      if (logs[i].equals("./") || (logs[i].equals("../") && stack.isEmpty())) {
        continue;
      } else if (logs[i].equals("../") && !stack.isEmpty()) {
        stack.pop();
      } else {
        stack.push(logs[i]);
      }
    }
    return stack.size();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] str = new String[n];
      for (int i = 0; i < n; i++) {
        str[i] = sc.next();
      }
      System.out.println(minOperations(str));
    }
  }  
}
