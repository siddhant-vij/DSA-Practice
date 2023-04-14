package myPackage.j4recursion;

import java.util.Scanner;

public class TailRecursion {

  static void tailRecursive(int n) {
    if (n == 0)
      return;
    System.out.print(n + " ");
    tailRecursive(n - 1);
    //Last thing in function is the recursive function call - Tail Recursive
  }

  static void nonTailRecursive(int n) {
    if (n == 0)
      return;
    nonTailRecursive(n - 1);
    System.out.print(n + " ");
    // Last thing in function is not the recursive function call - Non Tail Recursive
  }
  
  static void nonTailToTailRecursive(int n, int index) {
    if (n == 0)
      return;
    System.out.print(index + " ");
    nonTailToTailRecursive(n-1, index+1);
    // Not every non-tail recursive function can be converted to tail recursive
    //  - by adding some extra parameters.
  }

  static int isFactorialTail (int n){
    if (n == 0 || n == 1)
      return 1;
    return n*isFactorialTail(n-1);
    // It's not tail recursive as the parent function has to multiply n with (n-1) factorial everytime
    // after the child function transfers it's control to parent.
  }

  static int factorialTail (int n, int result){
    if (n == 0 || n == 1)
      return result;
    return factorialTail(n-1, result*n);
    //Factorial Tail Recursive
  }


  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      int startingIndex = 1;
      nonTailToTailRecursive(x, startingIndex);
      System.out.println();
      System.out.println(isFactorialTail(x));
      System.out.println(factorialTail(x, 1));
    }
  }
}