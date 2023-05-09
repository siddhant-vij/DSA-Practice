// Scaler Practice: Pair Sum & Difference
// Check if a pair exists with sum/diff given
// Count the no. of pairs with sum/diff given

package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PairSumDiff {

  static int countPairsGivenDiff(int[] arr, int diff) {
    int mod = 1000_000_007;
    Map<Integer, Integer> map = new HashMap<>();
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < n; i++)
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

    for (int i = 0; i < n; i++) {
      if (map.containsKey(diff + arr[i]))
        count = (count + map.get(diff + arr[i])) % mod;
    }
    return count % mod;
  }

  static boolean checkIfPairExistsGivenDiff(int[] arr, int diff) {
    int n = arr.length;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (set.contains(arr[i] - diff))
        return true;
      if (set.contains(arr[i] + diff))
        return true;
      set.add(arr[i]);
    }
    return false;
  }

  static int countPairsGivenSum(int[] arr, int sum) {
    int mod = 1000_000_007;
    Map<Integer, Integer> map = new HashMap<>();
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (map.containsKey(sum - arr[i]))
        count = (count + map.get(sum - arr[i])) % mod;
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    return count % mod;
  }

  static boolean checkIfPairExistsGivenSum_Efficient(int[] arr, int sum) {
    HashSet<Integer> s = new HashSet<Integer>();
    for (int i = 0; i < arr.length; ++i) {
      int temp = sum - arr[i];
      if (s.contains(temp))
        return true;
      s.add(arr[i]);
    }
    return false;
  }

  static boolean checkIfPairExistsGivenSum_Fast(int[] arr, int sum) {
    Arrays.sort(arr);
    int l = 0;
    int r = arr.length - 1;
    while (l < r) {
      if (arr[l] + arr[r] == sum)
        return true;
      else if (arr[l] + arr[r] < sum)
        l++;
      else
        r--;
    }
    return false;
  }

  static boolean checkIfPairExistsGivenSum_Slow(int[] arr, int sum) {
    int size = arr.length;
    for (int i = 0; i < (size - 1); i++) {
      for (int j = (i + 1); j < size; j++) {
        if (arr[i] + arr[j] == sum) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int sum = sc.nextInt();
      int diff = sc.nextInt();
      System.out.println(checkIfPairExistsGivenSum_Slow(arr, sum)); // O(N^2)/O(1)
      System.out.println(checkIfPairExistsGivenSum_Fast(arr, sum)); // O(NLogN)/O(1)
      System.out.println(checkIfPairExistsGivenSum_Efficient(arr, sum)); // O(N)/O(N)
      System.out.println(countPairsGivenSum(arr, sum)); // O(N)/O(N)
      System.out.println(checkIfPairExistsGivenDiff(arr, diff)); // O(N)/O(N)
      System.out.println(countPairsGivenDiff(arr, diff)); // O(N)/O(N)
    }
  }
}
