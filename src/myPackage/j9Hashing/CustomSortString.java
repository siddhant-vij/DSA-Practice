// Leetcode: 791 - Custom Sort String

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomSortString {

  static String customSortString(String order, String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++)
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < order.length(); i++) {
      char ch = order.charAt(i);
      if (map.containsKey(ch)) {
        int num = map.get(ch);
        while (num-- > 0)
          strB.append(ch);
        map.remove(ch);
      }
    }

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      int num = entry.getValue();
      while (num-- > 0)
        strB.append(entry.getKey());
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String order = sc.next();
      String str = sc.next();
      System.out.println(customSortString(order, str));
    }
  }
}
