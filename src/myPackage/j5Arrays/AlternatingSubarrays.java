// You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
// You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
// A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's.
// For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.

// Problem Constraints
// 1<=N<=10^3
// A[i] quals to 0 or 1.
// 0<=B<=(N-1)/2

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlternatingSubarrays {

  static boolean isValid(int[] arr, int i, int B) {
    int left = i - 1;
    int right = i + 1;
    int count = 0;
    while (count != B) {
      if (count % 2 == 0 && (arr[i] == arr[left] || arr[i] == arr[right]))
        return false;
      if (count % 2 != 0 && (arr[i] != arr[left] || arr[i] != arr[right]))
        return false;
      left--;
      right++;
      count++;
    }
    return true;
  }

  static int[] altSubArrays(int[] A, int B) {
    ArrayList<Integer> arrL = new ArrayList<>();
    for (int i = B; i < A.length - B; i++) {
      if (isValid(A, i, B))
        arrL.add(i);
    }
    int[] result = new int[arrL.size()];
    for (int i = 0; i < arrL.size(); i++) {
      result[i] = arrL.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(Arrays.toString(altSubArrays(arr, k)));
    }
  }
}
