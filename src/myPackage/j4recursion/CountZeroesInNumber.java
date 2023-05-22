// Practice: Count Zeroes in an Integer

package myPackage.j4recursion;

import java.util.Scanner;

public class CountZeroesInNumber {

  static int countZeroes(int n, int count) {
    if(n == 0)
      return count;
    if(n%10 == 0)
      count++;
    return countZeroes(n/10, count);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(countZeroes(n, 0));
    }
  }
}
