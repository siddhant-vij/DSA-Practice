// Leetcode: 1170. Compare Strings by Frequency of the Smallest Character

package myPackage.j10Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompareFrequencyLexical {

  static int lastPosition(int[] arr, int target) {
    int result = -1;
    int s = 0;
    int e = arr.length - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] == target) {
        result = m;
        s = m + 1;
      } else if (arr[m] < target) {
        s = m + 1;
      } else {
        e = m - 1;
      }
    }
    if (result != -1)
      return result + 1;
    else
      return s;
  }

  static int countFreq(String str) {
    char[] ch = str.toCharArray();
    int n = ch.length;
    Map<Character, Integer> map = new HashMap<>();
    char smallest = 'z';
    for (int i = 0; i < n; i++) {
      map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
      if(ch[i] < smallest)
        smallest = ch[i];
    }
    return map.get(smallest);
  }

  static int[] numSmallerByFrequency(String[] queries, String[] words) {
    int n = words.length;
    int m = queries.length;
    Arrays.sort(words, (w1, w2) -> {
      return countFreq(w1) - countFreq(w2);
    });
    int[] freq = new int[n];
    for (int i = 0; i < n; i++)
      freq[i] = countFreq(words[i]);
    int[] queryFreq = new int[m];
    for (int i = 0; i < m; i++)
      queryFreq[i] = countFreq(queries[i]);
    int[] answer = new int[m];
    for (int i = 0; i < m; i++)
      answer[i] = n - lastPosition(freq, queryFreq[i]);
    return answer;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      String[] queries = new String[m];
      for (int i = 0; i < queries.length; i++) {
        queries[i] = sc.next();
      }
      int n = sc.nextInt();
      String[] words = new String[n];
      for (int i = 0; i < words.length; i++) {
        words[i] = sc.next();
      }
      System.out.println(Arrays.toString(numSmallerByFrequency(queries, words)));
    }
  }
  
}
