// Leetcode: H Index
// LC 274. H-Index
// LC 275. H-Index II

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HIndex1And2 {

  static int hIndexII(int[] citations) {
    int n = citations.length;
    int s = 0;
    int e = n - 1;
    int result = 0;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (citations[m] - (n - m) >= 0) {
        result = n - m;
        e = m - 1;
      } else
        s = m + 1;
    }
    return result;
  }

  static int hIndexI(int[] citations) {
    int n = citations.length;
    countingSort(citations);
    int result = 0;
    for (int i = n - 1; i >= 0; i--) {
      if ((citations[i] - (n - i)) >= 0)
        result = Math.max(result, n - i);
    }
    return result;
  }

  static void countingSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    int range = max - min + 1;
    int count[] = new int[range];
    int output[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i] - min]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = output[i];
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(hIndexI(arr));
      System.out.println(hIndexII(arr));
    }
  }
}
