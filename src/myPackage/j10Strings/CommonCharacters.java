// Leetcode: 1002 - Find Common Characters

package myPackage.j10Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommonCharacters {

  static List<String> commonChars(String[] words) {
    int n = words.length;
    int[][] charCount = new int[26][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        char ch = words[i].charAt(j);
        charCount[ch - 'a'][i]++;
      }
    }

    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < n; j++)
        min = Math.min(min, charCount[i][j]);
      map.put(String.valueOf((char) (i + 'a')), min);
    }

    List<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      int count = entry.getValue();
      while (count-- > 0)
        result.add(entry.getKey());
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
      System.out.println(commonChars(arr));
    }
  }
}
