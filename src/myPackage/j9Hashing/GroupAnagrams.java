// Leetcode: 49. Group Anagrams

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GroupAnagrams {

  static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<Integer>> map = new HashMap<>();
    int n = strs.length;
    for (int i = 0; i < n; i++) {
      Map<Character, Integer> inner = new TreeMap<>();
      for (int j = 0; j < strs[i].length(); j++)
        inner.put(strs[i].charAt(j), inner.getOrDefault(strs[i].charAt(j), 0) + 1);
      StringBuilder strB = new StringBuilder();
      for (Map.Entry<Character, Integer> entry : inner.entrySet())
        strB.append(entry.getKey()).append(entry.getValue());
      map.putIfAbsent(strB.toString(), new ArrayList<>());
      map.get(strB.toString()).add(i);
    }
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
      List<Integer> indexes = entry.getValue();
      n = indexes.size();
      List<String> list = new ArrayList<>();
      for (int i = 0; i < n; i++)
        list.add(strs[indexes.get(i)]);
      result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      String[] arr = new String[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.next();
      }
      System.out.println(groupAnagrams(arr));
    }
  }  
}
