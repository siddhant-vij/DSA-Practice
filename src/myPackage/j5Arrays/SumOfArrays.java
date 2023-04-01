// Coding Ninjas 109: Sum Of Two Arrays

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumOfArrays {

  static int[] findArraySum(int[] arr1, int n, int[] arr2, int m) {
    int p1 = n - 1;
    int p2 = m - 1;
    List<Integer> resL = new ArrayList<>();
    while (p1 >= 0 || p2 >= 0) {
      if (p2 < 0) {
        resL.add(0, arr1[p1]);
        p1--;
        if (p1 < 0) {
          int[] result = new int[resL.size()];
          for (int i = 0; i < resL.size(); i++)
            result[i] = resL.get(i);
          return result;
        }
      } else if (p1 < 0) {
        resL.add(0, arr2[p2]);
        p2--;
        if (p2 < 0) {
          int[] result = new int[resL.size()];
          for (int i = 0; i < resL.size(); i++)
            result[i] = resL.get(i);
          return result;
        }
      } else {
        int sum = arr1[p1] + arr2[p2];
        if (sum <= 9) {
          resL.add(0, sum);
          p1--;
          p2--;
          if (p1 < 0 && p2 < 0) {
            int[] result = new int[resL.size()];
            for (int i = 0; i < resL.size(); i++)
              result[i] = resL.get(i);
            return result;
          }
        } else {
          resL.add(0, sum % 10);
          p1--;
          p2--;
          if (p1 >= 0 && n >= m)
            arr1[p1]++;
          else if (p2 >= 0 && m >= n)
            arr2[p2]++;
        }
      }
    }
    resL.add(0, 1);
    int[] result = new int[resL.size()];
    for (int i = 0; i < resL.size(); i++)
      result[i] = resL.get(i);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] arr2 = new int[m];
      for (int i = 0; i < m; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(findArraySum(arr1, n, arr2, m)));
    }
  }
}
