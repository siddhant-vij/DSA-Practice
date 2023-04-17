// Leetcode: 989 - Add to Array-Form of Integer

package myPackage.j2maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingToArrayForm {

  static List<Integer> addToArrayForm(int[] num, int k) {
    int p = num.length - 1;
    List<Integer> resL = new ArrayList<>();
    while (p >= 0 || k > 0) {
      if (p >= 0 && k > 0) {
        int dig = k % 10;
        if (num[p] + dig <= 9) {
          resL.add(0, num[p] + dig);
          p--;
          k /= 10;
        } else {
          int sum = num[p] + dig;
          resL.add(0, sum % 10);
          k = k / 10 + sum / 10;
          p--;
        }
      }
      if (p < 0 && k > 0) {
        resL.add(0, k % 10);
        k /= 10;
      }
      if (p >= 0 && k <= 0) {
        resL.add(0, num[p]);
        p--;
      }
    }
    return resL;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(addToArrayForm(arr1, k));
    }
  }
}