// Leetcode: 1624. Largest Substring Between Two Equal Characters

package myPackage.j10Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LargestSubstringEquality {

  static int maxLengthBetweenEqualCharacters(String s) {
    Map<Character, List<Integer>> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        List<Integer> list = map.get(ch);
        list.add(i);
        map.put(ch, list);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(ch, list);
      }
    }
    int maxLength = Integer.MIN_VALUE;
    for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
      List<Integer> list = entry.getValue();
      if (list.size() >= 2) {
        maxLength = Math.max(maxLength, list.get(list.size() - 1) - list.get(0) - 1);
      }
    }
    return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(maxLengthBetweenEqualCharacters(str));
    }
  }  
}
