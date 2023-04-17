package myPackage.j2maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DifferenceArrays {

  static int[] removeLeadingZeroes(List<Integer> resL) {
    int ind = -1;
    int n = resL.size();

    for (int i = 0; i < n; i++) {
      if (resL.get(i) != 0) {
        ind = i;
        break;
      }
    }

    if (ind == -1) {
      int[] result = new int[n];
      for (int i = 0; i < n; i++)
        result[i] = resL.get(i);
      return result;
    }

    int[] result = new int[n - ind];
    for (int i = 0; i < n - ind; i++)
      result[i] = resL.get(ind + i);
    return result;
  }

  static int[] arrayDifference(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;
    int p1 = n1 - 1;
    int p2 = n2 - 1;
    List<Integer> resL = new ArrayList<>();

    while (p1 >= 0 || p2 >= 0) {
      if (p2 >= 0 && p1 >= 0) {
        if (arr2[p2] - arr1[p1] >= 0) {
          resL.add(0, arr2[p2] - arr1[p1]);
          p1--;
          p2--;
        } else {
          resL.add(0, arr2[p2] + 10 - arr1[p1]);
          p1--;
          p2--;
          if (p1 >= 0)
            arr1[p1]++;
          else
            arr2[p2]--;
        }
      } else if (p2 >= 0 && p1 < 0) {
        resL.add(0, arr2[p2]);
        p2--;
      }
    }
    return removeLeadingZeroes(resL);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n1 = sc.nextInt();
      int[] arr1 = new int[n1];
      for (int i = 0; i < n1; i++) {
        arr1[i] = sc.nextInt();
      }
      int n2 = sc.nextInt();
      int[] arr2 = new int[n2];
      for (int i = 0; i < n2; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(arrayDifference(arr1, arr2)));
    }
  }
}
