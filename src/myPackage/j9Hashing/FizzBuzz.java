// Leetcode: 412. Fizz Buzz

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FizzBuzz {

  static List<String> fizzBuzz(int n) {
    List<String> ans = new ArrayList<String>();
    HashMap<Integer, String> fizzBuzzDict = new HashMap<Integer, String>() {
      {
        put(3, "Fizz");
        put(5, "Buzz");
      }
    };
    List<Integer> divisors = new ArrayList<>(Arrays.asList(3, 5));
    for (int num = 1; num <= n; num++) {
      String numAnsStr = "";
      for (Integer key : divisors) {
        if (num % key == 0) {
          numAnsStr += fizzBuzzDict.get(key);
        }
      }
      if (numAnsStr.equals("")) {
        numAnsStr += Integer.toString(num);
      }
      ans.add(numAnsStr);
    }
    return ans;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(fizzBuzz(N));
    }
  }  
}
