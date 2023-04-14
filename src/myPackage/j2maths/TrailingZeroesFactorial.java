package myPackage.j2maths;

import java.util.Scanner;

public class TrailingZeroesFactorial {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int count = 0;
      for (int i = 5; i <= N ; i=i*5) {
        count = count + (N/i);
      }
      System.out.println(count);
    }
  }
}



/* Brute Force Approach
public class BeginnerJava {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int count = 0;
    int fact = 1;
    for (int i = 2; i <= N ; i++) {
      fact = fact * i;
    }
    while (fact%10 == 0)
    {
      count++;
      fact /= 10;
    }
    System.out.println(count);
  }
}*/