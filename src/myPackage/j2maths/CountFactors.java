package myPackage.j2Maths;

import java.util.Scanner;

public class CountFactors {

  static int solve (int A){
    int count = 0;
    for (int i = 1; i*i <= A; i++) {
      if (A%i == 0)
      {
        if (i == A/i)
          count++;
        else
          count+=2;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      System.out.println(solve(x));
    }
  }
  
}
