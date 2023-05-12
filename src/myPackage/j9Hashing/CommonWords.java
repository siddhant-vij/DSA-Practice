// Leetcode: 2085. Count Common Words With One Occurrence

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommonWords {

  static int countWords(String s1, String s2) {
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

    int count = 0;
    for (int i = 0; i < n1; i++) {
      if (s2map.containsKey(str1[i]) && s2map.get(str1[i]) == 1 && s1map.get(str1[i]) == 1)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s1 = sc.nextLine();
      String s2 = sc.nextLine();
      System.out.println(countWords(s1, s2));
    }
  }  
}
