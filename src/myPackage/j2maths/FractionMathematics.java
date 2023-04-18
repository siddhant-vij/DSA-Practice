// Leetcode: 592 - Fraction Addition and Subtraction

package myPackage.j2maths;

import java.util.ArrayList;
import java.util.Scanner;

public class FractionMathematics {

  static int gcd(int a, int b) {
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  static String fractionMaths(String expression) {
    int n = expression.length();
    int denominator = 1;
    int count = 0;
    int i = 0;
    while (i < n) {
      if (expression.charAt(i) == '/') {
        int s = i + 1;
        int e = s;
        while (e < n && (expression.charAt(e) != '+' && expression.charAt(e) != '-'))
          e++;
        StringBuilder strB = new StringBuilder();
        for (int j = s; j < e; j++) {
          strB.append(expression.charAt(j));
        }
        count++;
        String str = strB.toString();
        int element = Integer.parseInt(str);
        if (count == 1)
          denominator = element;
        else
          denominator = denominator * element / gcd(denominator, element);
      }
      i++;
    }
    int start = 0;
    int end = 0;
    ArrayList<Integer> factor = new ArrayList<>();
    ArrayList<Integer> numerator = new ArrayList<>();
    while (end < n) {
      if (expression.charAt(end) != '/')
        end++;
      else {
        int s = end + 1;
        int e = s;
        while (e < n && (expression.charAt(e) != '+' && expression.charAt(e) != '-'))
          e++;
        StringBuilder strB = new StringBuilder();
        for (int j = s; j < e; j++) {
          strB.append(expression.charAt(j));
        }
        String str = strB.toString();
        int element = Integer.parseInt(str);
        factor.add(denominator / element);

        StringBuilder strBT = new StringBuilder();
        for (int j = start; j < end; j++) {
          strBT.append(expression.charAt(j));
        }
        String strT = strBT.toString();
        element = Integer.parseInt(strT);
        numerator.add(element);

        while (start < n && (expression.charAt(start) != '+' && expression.charAt(start) != '-'))
          start++;
        end = start;
      }
    }
    int numeratorF = 0;
    for (int j = 0; j < factor.size(); j++) {
      numeratorF += numerator.get(j) * factor.get(j);
    }
    int gcdF = gcd(numeratorF, denominator);
    if (gcdF < 0)
      gcdF *= -1;
    if (gcdF == 1) {
      String result = numeratorF + "/" + denominator;
      return result;
    } else {
      int numF = numeratorF / gcdF;
      int denF = denominator / gcdF;
      String result = numF + "/" + denF;
      return result;
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String expression = sc.next();
      System.out.println(fractionMaths(expression));
    }
  }
}
