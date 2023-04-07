// A wire connects N light bulbs.
// Each bulb has a switch associated with it; however, due to faulty wiring,
// a switch also changes the state of all the bulbs to the right of the current bulb.

// Given an initial state of all bulbs, 
// find the minimum number of switches you have to press to turn on all the bulbs.

// You can press the same switch multiple times.
// Note: 0 represents the bulb is off and 1 represents the bulb is on.

// Problem Constraints
// 0 <= N <= 5×10^5
// 0 <= A[i] <= 1

package myPackage.j5Arrays;

import java.util.Scanner;

public class MinBulbSwitches {

  static int bulbSwitches(int[] A) {
    int count;
    if (A.length == 0)
      return 0;

    if (A[0] == 0)
      count = 1;
    else
      count = 0;

    int cur = A.length - 1;
    while (cur >= 1) {
      if (A[cur] != A[cur - 1])
        count++;
      cur--;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(bulbSwitches(arr));
    }
  }
}
