// Leetcode 451 - Sort Characters By Frequency

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class SortString implements Comparable<SortString> {
  char element;
  int count;

  SortString(char element, int count) {
    this.element = element;
    this.count = count;
  }

  @Override
  public int compareTo(SortString other) {
    if (this.count > other.count)
      return -1;
    else if (this.count < other.count)
      return 1;
    else {
      if (this.element < other.element)
        return 1;
      else if (this.element > other.element)
        return -1;
      else
        return 0;
    }
  }
}

public class SortStringFrequency {

  static String frequencySort(String s) {
    char[] elements = s.toCharArray();
    int[] count = new int[128];
    int n = s.length();
    for (int i = 0; i < n; i++)
      count[elements[i] - '0']++;

    SortString[] sortstring = new SortString[n];
    for (int i = 0; i < n; i++)
      sortstring[i] = new SortString(elements[i], count[elements[i] - '0']);

    Arrays.sort(sortstring);

    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < n; i++)
      strB.append(sortstring[i].element);

    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(frequencySort(str));
    }
  }

}
