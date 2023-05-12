// Leetcode: 884. Uncommon Words from Two Sentences

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UncommonWords {

  static String[] uncommonFromSentences(String s1, String s2) {
    String[] str1 = s1.split(" ");
    String[] str2 = s2.split(" ");
    Map<String, Integer> s1map = new HashMap<>();
    Map<String, Integer> s2map = new HashMap<>();
    int n1 = str1.length;
    int n2 = str2.length;
    for (int i = 0; i < n1; i++)
      s1map.put(str1[i], s1map.getOrDefault(str1[i], 0) + 1);
    for (int i = 0; i < n2; i++)
      s2map.put(str2[i], s2map.getOrDefault(str2[i], 0) + 1);

    List<String> resL = new ArrayList<>();
    for (int i = 0; i < n1; i++) {
      if (!s2map.containsKey(str1[i]) && s1map.get(str1[i]) == 1)
        resL.add(str1[i]);
    }
    for (int i = 0; i < n2; i++) {
      if (!s1map.containsKey(str2[i]) && s2map.get(str2[i]) == 1)
        resL.add(str2[i]);
    }
    int n = resL.size();
    String[] result = new String[n];
    for (int i = 0; i < n; i++)
      result[i] = resL.get(i);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s1 = sc.nextLine();
      String s2 = sc.nextLine();
      System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }
  }  
}
