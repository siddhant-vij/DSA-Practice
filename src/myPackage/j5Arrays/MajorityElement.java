// Leetcode: 169 - Majority Element

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {

  static int MajorityElementBoyerMooreVoting(int[] arr) {
    int count = 1;
    int result = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[result])
        count++;
      else
        count--;

      if (count == 0) {
        count = 1;
        result = i;
      }
    }
    int checkCount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == arr[result])
        checkCount++;
    }
    if (checkCount > arr.length / 2)
      return arr[result];
    else
      return -1;
  }

  static int MajorityElementFast(int[] arr) {
    Arrays.sort(arr);
    int count = 1;
    int index = -1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        count++;
        if (count > arr.length / 2) {
          index = i;
        }
      } else
        count = 1;
    }
    if (index == -1)
      return -1;
    else
      return arr[index];
  }

  static int MajorityElementLimited(int[] arr) {
    int[] count = new int[2001];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i] + 1000]++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > arr.length / 2)
        return i - 1000;
    }
    return -1;
  }

  static int MajorityElementSlow(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int count = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == arr[i])
          count++;
      }
      if (count > arr.length / 2)
        return arr[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(MajorityElementSlow(arr)); // O(N^2)
      System.out.println(MajorityElementLimited(arr)); // O(N) but limited to only [-1000, 1000]
      System.out.println(MajorityElementFast(arr)); // O(NLogN)
      System.out.println(MajorityElementBoyerMooreVoting(arr)); // O(N)
    }
  }
}
