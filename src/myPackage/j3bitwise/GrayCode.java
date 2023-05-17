// Leetcode: 89. Gray Code

package myPackage.j3bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GrayCode {

  static List<Integer> grayCode(int n) {
    if (n == 0)
      return new ArrayList<Integer>(Arrays.asList(0));
    List<Integer> temp = grayCode(n - 1);
    List<Integer> result = new ArrayList<>(temp);
    for (int i = temp.size() - 1; i >= 0; i--)
      result.add(((1 << (n - 1)) | temp.get(i)));
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(grayCode(n));
    }
  }  
}
