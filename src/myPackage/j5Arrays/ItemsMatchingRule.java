// Leetcode 1773

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemsMatchingRule {

  static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int col = 0;
    if (ruleKey.equals("type"))
      col = 0;
    else if (ruleKey.equals("color"))
      col = 1;
    else
      col = 2;

    int count = 0;
    for (int i = 0; i < items.size(); i++) {
      if (col == 0) {
        if (items.get(i).get(0).equals(ruleValue))
          count++;
      } else if (col == 1) {
        if (items.get(i).get(1).equals(ruleValue))
          count++;
      } else {
        if (items.get(i).get(2).equals(ruleValue))
          count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      List<List<String>> items = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        items.add(i, new ArrayList<>());
        for (int j = 0; j < 3; j++) {
          items.get(i).add(sc.next());
        }
      }
      String ruleKey = sc.next();
      String ruleValue = sc.next();
      System.out.println(countMatches(items, ruleKey, ruleValue));
    }
  }
}
