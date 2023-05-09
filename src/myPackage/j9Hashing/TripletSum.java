// GFG Practice: Find a triplet that sum to a given value

package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TripletSum {

  static void printTripletGivenSum_Fast_II(int[] arr, int sum) {
    int n = arr.length;
    for (int i = 0; i < n - 2; i++) {
      HashSet<Integer> s = new HashSet<Integer>();
      int curr_sum = sum - arr[i];
      for (int j = i + 1; j < n; j++) {
        if (s.contains(curr_sum - arr[j])) {
          System.out.printf("Triplet is %d, %d, %d", arr[i], arr[j], curr_sum - arr[j]);
        }
        s.add(arr[j]);
      }
    }
  }

  static void printTripletGivenSum_Fast_I(int[] arr, int sum) {
    // One modification to this code: To take care of duplicates: 3Sum - Leetcode
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = 0; i < n - 2; i++) {
      int l = i + 1;
      int r = n - 1;
      while (l < r) {
        if (arr[i] + arr[l] + arr[r] == sum) {
          System.out.print("Triplet is " + arr[i] + ", " + arr[l] + ", " + arr[r]);
        } else if (arr[i] + arr[l] + arr[r] < sum)
          l++;
        else
          r--;
      }
    }
  }

  static void printTripletGivenSum_Slow(int[] arr, int sum) {
    int size = arr.length;
    for (int i = 0; i < size - 2; i++) {
      for (int j = i + 1; j < size - 1; j++) {
        for (int k = j + 1; k < size; k++) {
          if (arr[i] + arr[j] + arr[k] == sum) {
            System.out.print("Triplet is " + arr[i] + ", " + arr[j] + ", " + arr[k]);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int sum = sc.nextInt();
      printTripletGivenSum_Slow(arr, sum); // O(N^3)/O(1)
      printTripletGivenSum_Fast_I(arr, sum); // O(N^2)/O(1)
      printTripletGivenSum_Fast_II(arr, sum); // O(N^2)/O(N)
    }
  }
}
