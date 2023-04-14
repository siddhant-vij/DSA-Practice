// Input: 354
// Output: Three Five Four

package myPackage.j4recursion;

import java.util.Scanner;

public class SayDigits {

  static String sayDigits(int n, String str, String[] arr) {
    if (n == 0)
      return str;
    str = sayDigits(n / 10, str, arr);
    for (int i = 0; i < arr.length; i++) {
      if ((n % 10) == i)
        str += arr[i] + " ";
    }
    return str;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String[] arr = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
      int T = sc.nextInt();
      while (T-- > 0) {
        int n = sc.nextInt();
        System.out.println(sayDigits(n, "", arr));
      }
    }
  }

}
