// Leetcode: 881. Boats to Save People

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BoatsToSavePeople {

  static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int n = people.length;
    int count = 0;
    int p1 = 0;
    int p2 = n - 1;
    while (p1 <= p2) {
      if (people[p1] + people[p2] <= limit) {
        p1++;
        p2--;
      } else {
        p2--;
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(numRescueBoats(arr, k));
    }
  }  
}
