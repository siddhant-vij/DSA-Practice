package myPackage.j2Maths;

import java.util.Scanner;

public class isPrime {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      boolean flag = true;
      if (n == 1)
        flag = false;
      if (n!=2 && n%2==0 || n!=3 && n%3==0)
        flag = false;
      for (int i = 5; i*i <= n; i+=6) {
        if (n%i==0 || n%(i+2)==0)
          flag = false;
      }
      System.out.println(flag);
    }
  }
}

/* Can be further optimized - for large numbers n
public class isPrime {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean flag = n != 1;
    for (int i = 2; i*i <= n; i++) {
      if (n % i == 0) {
        flag = false;
        break;
      }
    }
    System.out.println(flag);
  }
}*/
