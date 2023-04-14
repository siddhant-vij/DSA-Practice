package myPackage.j3bitwise;

import java.util.ArrayList;
import java.util.Scanner;

public class NextSparseNumber {
  static boolean isSparse(int n){
    if ((n&(n>>1)) == 0)
        return true;
    return false;
  }

  static int nextSparse(int n){
    while (true)
    {
      if(isSparse(n))
        return n;
      else
        n++;
    }
  }

  static int NextSparseEfficient (int n){
    ArrayList<Integer> bin = new ArrayList<>();
    while(n!=0)
    {
      bin.add(n&1);
      n>>=1;
    }
    bin.add(0);
    int last_final = 0;
    for (int i = 1; i < bin.size()-1; i++) {
      if(bin.get(i) == 1 && bin.get(i-1) == 1 && bin.get(i+1)!=1)
      {
        bin.set(i+1,1);
        for (int j = i; j >= last_final; j--) {
          bin.set(j, 0);
        }
        last_final = i+1;
      }      
    }
    int ans = 0;
    for (int i = 0; i < bin.size(); i++) {
      ans += bin.get(i)*(1<<i);
    }
    return ans;
  }
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(isSparse(n));
      System.out.println(nextSparse(n));
      System.out.println(NextSparseEfficient(n));
    }
  }  
}