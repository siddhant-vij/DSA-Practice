// Leetcode: 2274. Maximum Consecutive Floors Without Special Floors

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MaxConsecutiveSpecialFloors {

  static int maxConsecutive(int bottom, int top, int[] special) {
    Arrays.sort(special);
    int index = 0;
    int curr = bottom, ans = 0;
    while (curr <= top && index < special.length) {
      ans = Math.max(ans, special[index] - curr);
      curr = special[index] + 1;
      index += 1;
    }
    ans = Math.max(ans, top - curr + 1);
    return ans;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int bottom = sc.nextInt();
      int top = sc.nextInt();
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maxConsecutive(bottom, top, arr));
    }
  }  
}
