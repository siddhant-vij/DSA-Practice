// Leetcode: 1207

package myPackage.j5Arrays;

import java.util.Scanner;

public class UniqueNumberOccurences {

  static boolean uniqueOccurrences(int[] arr) {
    int[] count = new int[2001];
    // Constraint: -1000 <= arr[i] <= 1000

    for (int i = 0; i < arr.length; i++) {
      count[arr[i] + 1000]++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 0) {
        for (int j = 0; j < count.length; j++) {
          if (j != i && count[j] == count[i])
            return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(uniqueOccurrences(arr));
    }
  }
}
