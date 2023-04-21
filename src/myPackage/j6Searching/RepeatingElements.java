// GFG Practice - Find the only element which repeats
// Given an unsorted array of size n>=2, where only 1 element repeats (any number of times).
// All elements from 0 to max(arr) are present.
// Think of a solution with TC: O(N), SC: O(1) - without modifying the original array

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatingElements {

  static int repeatingElementFast(int[] arr) {
    // Following code works when given numbers are starting from 1
    // int slow = arr[0];
    // int fast = arr[0];

    // do {
    // slow = arr[slow];
    // fast = arr[arr[fast]];
    // } while (slow != fast);

    // slow = arr[0];

    // while (slow != fast) {
    // slow = arr[slow];
    // fast = arr[fast];
    // }
    // return slow;

    // Modification: Following code works when given numbers are starting from 0
    int slow = arr[0];
    int fast = arr[0];

    do {
      slow = arr[slow] + 1;
      fast = arr[arr[fast] + 1] + 1;
    } while (slow != fast);

    slow = arr[0] + 1;

    while (slow != fast) {
      slow = arr[slow] + 1;
      fast = arr[fast] + 1;
    }
    return slow - 1;
  }

  static int repeatingElementSolution(int[] arr) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
    }
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, arr[i]);
    }
    int diff = n - 1 - max; // Given numbers are starting from 0
    // int diff = n - max; // If given numbers are starting from 1
    int sumExp = max * (max + 1) / 2;
    return (int) (sum - sumExp) / diff;
  }

  static int repeatingElementIII(int[] arr) {
    int[] count = new int[arr.length];
    for (int i = 0; i < count.length; i++) {
      count[arr[i]]++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 1)
        return i;
    }
    return -1;

    // boolean visit[] = new boolean[arr.length];
    // for (int i = 0; i < arr.length; i++) {
    // if (visit[arr[i]])
    // return arr[i];
    // visit[arr[i]] = true;
    // }
    // return -1;
  }

  static int repeatingElementII(int[] arr) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == arr[i + 1])
        return arr[i];
    }
    return -1;
  }

  static int repeatingElementI(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j])
          return arr[i];
      }
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
      System.out.println(repeatingElementI(arr)); // O(N^2)/O(1)
      System.out.println(repeatingElementII(arr)); // O(NLogN)/O(1)
      System.out.println(repeatingElementIII(arr)); // O(N)/O(N)
      System.out.println(repeatingElementSolution(arr)); // O(N)/O(1)/Without Modification
      System.out.println(repeatingElementFast(arr)); // O(N)/O(1)/Without Modification/Slow & Fast Pointers
    }
  }
}
