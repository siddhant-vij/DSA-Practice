// Leetcode: 692. Top K Frequent Words

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class StringFreqSort implements Comparable<StringFreqSort> {
  String word;
  int freq;

  StringFreqSort(String word, int freq) {
    this.word = word;
    this.freq = freq;
  }

  @Override
  public int compareTo(StringFreqSort other) {
    if (this.freq < other.freq)
      return 1;
    else if (this.freq > other.freq)
      return -1;
    else {
      if (this.word.compareTo(other.word) > 0)
        return 1;
      else if (this.word.compareTo(other.word) < 0)
        return -1;
      else
        return 0;
    }
  }
}

public class TopKFrequentWords {

  static List<String> topKFrequent(String[] words, int k) {
    int n = words.length;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(words[i], map.getOrDefault(words[i], 0) + 1);
    n = map.size();
    StringFreqSort[] obj = new StringFreqSort[n];
    int idx = 0;
    for (Map.Entry<String, Integer> entry : map.entrySet())
      obj[idx++] = new StringFreqSort(entry.getKey(), entry.getValue());
    Arrays.sort(obj);
    List<String> result = new ArrayList<>();
    for (int i = 0; i < k; i++)
      result.add(obj[i].word);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      String[] arr = new String[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.next();
      }
      int k = sc.nextInt();
      System.out.println(topKFrequent(arr, k));
    }
  }
}
