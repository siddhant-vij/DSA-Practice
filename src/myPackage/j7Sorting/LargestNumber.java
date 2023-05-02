// Leetcode 179 - Largest Number

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class StringComp implements Comparable<StringComp> {
  String a;

  StringComp(int a) {
    this.a = Integer.toString(a);
  }

  @Override
  public int compareTo(StringComp other) {
    String aO = this.a + other.a;
    String Oa = other.a + this.a;
    return aO.compareTo(Oa) > 0 ? 1 : -1;
  }
}

public class LargestNumber {

  static String largestNumber(int[] A) {
    int n = A.length;
    StringComp[] str = new StringComp[n];
    for (int i = 0; i < n; i++)
      str[i] = new StringComp(A[i]);

    Arrays.sort(str);
    if (str[n - 1].a.equals("0"))
      return "0";
    String result = "";
    for (int i = n - 1; i >= 0; i--) {
      result += str[i].a;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(largestNumber(arr));
    }
  }
}
