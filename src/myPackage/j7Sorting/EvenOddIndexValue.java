// Leetcode: 2164. Sort Even and Odd Indices Independently

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class EvenOddIndexValue {

  static int[] sortEvenOdd(int[] nums) {
    int n = nums.length;
    int[] odd = new int[n / 2];
    int[] even = new int[(int) Math.ceil(n / 2.0)];
    int ide = 0, ido = 0;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0)
        even[ide++] = nums[i];
      else
        odd[ido++] = nums[i];
    }
    Arrays.sort(even);
    Arrays.sort(odd);
    ide = 0;
    ido = odd.length - 1;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0)
        nums[i] = even[ide++];
      else
        nums[i] = odd[ido--];
    }
    return nums;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(sortEvenOdd(arr)));
    }
  }
}
