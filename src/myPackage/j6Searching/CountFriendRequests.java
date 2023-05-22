// Leetcode: 825. Friends Of Appropriate Ages

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class CountFriendRequests {

  static int firstIdx(int[] ages, int target) {
    int beg = 0;
    int end = ages.length - 1;
    while (beg <= end) {
      int mid = beg + (end - beg) / 2;
      if (ages[mid] <= target)
        beg = mid + 1;
      else
        end = mid - 1;
    }
    return beg;
  }

  static int numFriendRequests(int[] ages) {
    int res = 0;
    Arrays.sort(ages);
    for (int i = 0; i < ages.length; i++) {
      int age = ages[i];
      int lower = firstIdx(ages, age / 2 + 7);
      int upper = firstIdx(ages, age);
      res += Math.max(upper - lower - 1, 0);
    }
    return res;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(numFriendRequests(arr));
    }
  }
}
