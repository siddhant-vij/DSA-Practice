// Practice: Number To Words

package myPackage.j2maths;

import java.util.Scanner;

public class NumberToWords {

  public static int reverse(int n) {
    int rev = 0;
    while (n != 0) {
      rev = rev * 10 + n % 10;
      n /= 10;
    }
    return rev;
  }

  public static int getDigitCount(int n) {
    if (n < 0)
      return -1;
    if (n == 0)
      return 1;
    int size = 0;
    while (n != 0) {
      size++;
      n /= 10;
    }
    return size;
  }

  public static void numberToWords(int n) {
    if (n < 0) {
      System.out.println("Invalid Value");
      return;
    }
    int rev = reverse(n);
    int size = getDigitCount(n);
    int count = 0;
    while (rev != 0) {
      count++;
      int dig = rev % 10;
      switch (dig) {
        case 0:
          System.out.println("Zero");
          break;
        case 1:
          System.out.println("One");
          break;
        case 2:
          System.out.println("Two");
          break;
        case 3:
          System.out.println("Three");
          break;
        case 4:
          System.out.println("Four");
          break;
        case 5:
          System.out.println("Five");
          break;
        case 6:
          System.out.println("Six");
          break;
        case 7:
          System.out.println("Seven");
          break;
        case 8:
          System.out.println("Eight");
          break;
        case 9:
          System.out.println("Nine");
          break;
      }
      rev /= 10;
    }
    for (int i = count; i < size; i++) {
      System.out.println("Zero");
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      numberToWords(N);
    }
  }
}
