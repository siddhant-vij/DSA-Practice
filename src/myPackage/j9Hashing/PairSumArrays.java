// GFG Practice: Pairs (in two arrays), given sum

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class PairSumArrays {

  static void printPairSum_Efficient(int[] arr1, int[] arr2, int sum) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int n = arr1.length;
    for (int i = 0; i < n; i++)
      map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);

    int m = arr2.length;
    for (int j = 0; j < m; j++)
      if (map.containsKey(sum - arr2[j]))
        for (int i = 0; i < map.get(sum - arr2[j]); i++)
          System.out.println(sum - arr2[j] + " " + arr2[j]);
  }

  static void printPairSum_Slow(int[] arr1, int[] arr2, int sum) {
    int n = arr1.length;
    int m = arr2.length;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (arr1[i] + arr2[j] == sum)
          System.out.println(arr1[i] + " " + arr2[j]);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr1 = new int[N];
      for (int i = 0; i < N; i++) {
        arr1[i] = sc.nextInt();
      }
      int M = sc.nextInt();
      int[] arr2 = new int[M];
      for (int i = 0; i < M; i++) {
        arr2[i] = sc.nextInt();
      }
      int sum = sc.nextInt();
      printPairSum_Slow(arr1, arr2, sum); // O(N^2)/O(1)
      System.out.println();
      printPairSum_Efficient(arr1, arr2, sum); // O(N)/O(N)
    }
  }
}
