// Leetcode: 599. Minimum Index Sum of Two Lists

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MinIndexSum {

  static String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    for (int j = 0; j < list2.length; j++)
      map.put(list2[j], j);
    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i < list1.length; i++) {
      if (map.containsKey(list1[i]))
        minSum = Math.min(minSum, i + map.get(list1[i]));
    }
    List<String> list = new ArrayList<>();
    for (int i = 0; i < list1.length; i++) {
      if (map.containsKey(list1[i]) && i == minSum - map.get(list1[i]))
        list.add(list1[i]);
    }
    String[] str = new String[list.size()];
    for (int i = 0; i < list.size(); i++)
      str[i] = list.get(i);
    return str;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      String[] str1 = new String[n];
      String[] str2 = new String[m];
      for (int i = 0; i < str1.length; i++) {
        str1[i] = sc.nextLine();
      }
      for (int i = 0; i < str2.length; i++) {
        str2[i] = sc.nextLine();
      }
      System.out.println(Arrays.toString(findRestaurant(str1, str2)));
    }
  }
}
