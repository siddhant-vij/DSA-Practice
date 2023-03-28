// Coding Ninjas: 286

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class DuplicatesInArray {

  static int findDuplicateXor(ArrayList<Integer> arr) {
    int xor = 0;
    for (int i = 0; i < arr.size(); i++) {
      xor ^= arr.get(i);
    }
    for (int i = 1; i < arr.size(); i++) {
      xor ^= i;
    }
    return xor;
  }

  static int findDuplicateSum(ArrayList<Integer> arr) {
    int sum = 0;
    for (int i = 0; i < arr.size(); i++) {
      sum += arr.get(i);
    }
    int n = arr.size();
    return (sum - (((n - 1) * n) / 2));
  }

  static int findDuplicateCount(ArrayList<Integer> arr) {
    int[] count = new int[100000];
    for (int i = 0; i < arr.size(); i++) {
      count[arr.get(i)]++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] > 1)
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ArrayList<Integer> arrL = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        arrL.add(sc.nextInt());
      }
      System.out.println(findDuplicateCount(arrL));
      System.out.println(findDuplicateSum(arrL));
      System.out.println(findDuplicateXor(arrL));
    }
  }
}
