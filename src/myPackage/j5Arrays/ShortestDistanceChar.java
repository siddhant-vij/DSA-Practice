// Leetcode 821

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestDistanceChar {

  static int[] shortestToCharFast(String s, char c) {
    int[] result = new int[s.length()];
    int p = s.indexOf(c);
    int n = s.indexOf(c);
    int cur = 0;
    while (cur < s.length()) {
      int diff = Integer.MAX_VALUE;
      if (p == n)
        if (cur > n)
          n = s.indexOf(c, n + 1);

      if (p != n)
        if (cur > n && n != -1) {
          p = n;
          n = s.indexOf(c, n + 1);
        }

      if (Math.abs(cur - n) < Math.abs(cur - p))
        diff = Math.abs(cur - n);
      if (Math.abs(cur - p) < Math.abs(cur - n))
        diff = Math.abs(cur - p);
      if (Math.abs(cur - n) == Math.abs(cur - p))
        diff = Math.abs(cur - n);

      result[cur++] = diff;
    }
    return result;
  }

  static int[] shortestToCharSlow(String s, char c) {
    ArrayList<Integer> index = new ArrayList<>();
    int curIndex = 0;
    int pos = 0;
    if (s.charAt(0) == c)
      index.add(pos++, curIndex);
    while (curIndex != -1) {
      curIndex = s.indexOf(c, curIndex + 1);
      if (curIndex != -1)
        index.add(pos++, curIndex);
    }

    int[] result = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      int diff = Integer.MAX_VALUE;
      for (int j = 0; j < index.size(); j++) {
        if (Math.abs(i - index.get(j)) < diff)
          diff = Math.abs(i - index.get(j));
      }
      result[i] = diff;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      char ch = sc.next().charAt(0);
      System.out.println(Arrays.toString(shortestToCharSlow(str, ch)));
      System.out.println(Arrays.toString(shortestToCharFast(str, ch)));
    }
  }
}
