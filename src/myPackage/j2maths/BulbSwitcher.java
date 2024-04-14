package myPackage.j2Maths;

import java.util.Scanner;

public class BulbSwitcher {

  static int bulbSwitch(int n){
    int count = 0;
    for (int i = 1; i*i <= n; i++) {
      if (i*i <= n)
        count++;
    }
    return count;
  }
  
  static int nRoundBulbsOn(int n) {
    boolean[] arr = new boolean[n + 1];
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = true;
    }
    for (int i = 2; i < arr.length; i+=2) {
      arr[i] = false;
    }
    for (int i = 3; i < arr.length; i++) {
      for (int j = i; j < arr.length; j+=i) {
        if (arr[j] == true)
          arr[j] = false;
        else if (arr[j] == false)
          arr[j] = true;
      }
    }
    for (int i = 1; i < arr.length; i++) {
      if(arr[i] == true)
      {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(nRoundBulbsOn(n));
      System.out.println(bulbSwitch(n));
    }
  }

}
