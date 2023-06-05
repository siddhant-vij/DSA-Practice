// Leetcode: 830. Positions of Large Groups

package myPackage.j10Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionLargeGroups {

  static List<List<Integer>> largeGroupPositions(String str) {
    List<List<Integer>> result = new ArrayList<>();
    int n = str.length();
    int s = 0;
    int e = 0;
    int count = 0;
    while (e < n) {
      if (str.charAt(s) == str.charAt(e)) {
        e++;
        count++;
      } else {
        if (count >= 3) {
          List<Integer> list = new ArrayList<>();
          list.add(s);
          list.add(e - 1);
          result.add(list);
        }
        count = 0;
        s++;
        while (s < n && str.charAt(s) == str.charAt(s - 1))
          s++;
      }
    }
    if (count >= 3) {
      List<Integer> list = new ArrayList<>();
      list.add(s);
      list.add(e - 1);
      result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(largeGroupPositions(str));
    }
  }  
}
