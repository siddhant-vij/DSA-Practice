// Every male member(M) gives birth to a male child first and then a female child, 
// whereas every female(F) member gives birth to a female child first and then to a male child.
// Analyze this pattern and find out what will be the Kth child in his Nth generation.
// Assume inputs (n & k) will be valid.

// Input: n=2, k=2
// Output: Female

// Input: n=3, k=4
// Output: Male

// Input: n=5, k=3
// Output: Female


package myPackage.j4recursion;

import java.util.Scanner;

public class FamilyStructure {

  static String kthChildNthGeneration(int n, long k){
    if (n==1)
      return "Male";
    long prevK = (long)(Math.ceil(k*1.0/2));
    String child = kthChildNthGeneration(n-1, prevK);
    String firstChild="";
    String secondChild="";
    if (child.equals("Male"))
    {
      firstChild = "Male";
      secondChild = "Female";
    }
    else
    {
      firstChild = "Female";
      secondChild = "Male";
    }

    if (k < 2*prevK)
      return firstChild;
    else
      return secondChild;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0)
      {
        int N = sc.nextInt();
        long K = sc.nextLong();
        System.out.println(kthChildNthGeneration(N,K));
      }
    }
  }
  
}
