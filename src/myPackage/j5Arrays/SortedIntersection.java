// Coding Ninjas: 155

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SortedIntersection {

  static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int p1 = 0, p2 = 0; p1 < arr1.size() && p2 < arr2.size();) {
      if (arr1.get(p1) < arr2.get(p2))
        p1++;
      else if (arr1.get(p1) > arr2.get(p2))
        p2++;
      else {
        result.add(arr1.get(p1));
        p1++;
        p2++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      ArrayList<Integer> arrL1 = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        arrL1.add(sc.nextInt());
      }
      ArrayList<Integer> arrL2 = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        arrL2.add(sc.nextInt());
      }
      System.out.println(findArrayIntersection(arrL1, n, arrL2, m));
    }
  }
}
