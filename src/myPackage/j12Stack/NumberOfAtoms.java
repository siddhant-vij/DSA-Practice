// Leetcode: 726. Number of Atoms

package myPackage.j12Stack;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberOfAtoms {

  static int index = 0;

  static String getAtom(String formula) {
    StringBuilder sb = new StringBuilder();
    sb.append(formula.charAt(index++));
    while (index < formula.length() && Character.isLowerCase(formula.charAt(index))) {
      sb.append(formula.charAt(index++));
    }
    return sb.toString();
  }

  static int getNumber(String formula) {
    if (index >= formula.length() || !Character.isDigit(formula.charAt(index))) {
      return 1;
    } else {
      int num = 0;
      while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
        num = num * 10 + (formula.charAt(index) - '0');
        index++;
      }
      return num;
    }
  }

  static Map<String, Integer> count(String formula) {
    Map<String, Integer> map = new TreeMap<>();
    while (index < formula.length()) {
      if (formula.charAt(index) == ')') {
        index++;
        return map;
      } else if (formula.charAt(index) == '(') {
        index++;
        Map<String, Integer> subMap = count(formula);
        int cnt = getNumber(formula);
        for (String atom : subMap.keySet()) {
          map.put(atom, cnt * subMap.get(atom) + map.getOrDefault(atom, 0));
        }
      } else {
        String atom = getAtom(formula);
        int cnt = getNumber(formula);
        map.put(atom, cnt + map.getOrDefault(atom, 0));
      }
    }
    return map;
  }

  static String countOfAtoms(String formula) {
    if (formula == null || formula.length() == 0)
      return "";
    Map<String, Integer> map = count(formula);
    StringBuffer sb = new StringBuffer();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey());
      if (entry.getValue() != 1)
        sb.append(entry.getValue());
    }
    return sb.toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String formula = sc.next();
      System.out.println(countOfAtoms(formula));
    }
  }
}
