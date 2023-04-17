// GFG Practice: Find zeroes to be flipped so that number of consecutive 1’s is maximized

// Given a binary array and an integer m,
// find the position of zeroes flipping which creates maximum number of consecutive 1’s in array.

// Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
//          m = 2
// Output:  5 7

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroesFlippedMaxOnes {

  private static int[] zeroFlipMaxOnes(int[] arr, int k) {
    int n = arr.length;
    int s = 0;
    int e = 0;
    int start = 0;
    int end = 0;
    int count = 0;
    int maxCount = Integer.MIN_VALUE;
    while (e < n) {
      if (arr[e] == 0)
        count++;
      if (arr[e] == 0 && count <= k || arr[e] == 1) {
        if ((e - s + 1) > maxCount) {
          start = s;
          end = e;
          maxCount = end - start + 1;
        }
        e++;
      } else if (arr[e] == 0 && count > k) {
        s++;
        count = k - 1;
        while (s < n && arr[s - 1] != 0)
          s++;
      }
    }
    int[] result;
    if (k > end - start)
      result = new int[end - start];
    else
      result = new int[k];
    int counter = 0;
    for (int i = start; i <= end; i++) {
      if (arr[i] == 0)
        result[counter++] = i;
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
      System.out.println(Arrays.toString(zeroFlipMaxOnes(arr, k)));
    }
  }
}
