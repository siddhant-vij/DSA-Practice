// Leetcode: 997. Find the Town Judge

package myPackage.j5Arrays;

import java.util.Scanner;

public class FindTownJudge {

  static int findJudge(int n, int[][] trust) {
    if (n == 1 && trust.length == 0)
      return 1;
    int count[] = new int[n + 1];
    for (int i = 0; i < trust.length; i++) {
      count[trust[i][0]]--;
      count[trust[i][1]]++;
    }
    for (int i = 1; i < count.length; i++) {
      if (count[i] == n - 1)
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[][] arr = new int[n][2];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 2; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      System.out.println(findJudge(n, arr));
    }
  }
}
