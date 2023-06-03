// Leetcode: 539. Minimum Time Difference

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class HoursMinutes implements Comparable<HoursMinutes> {
  int hh;
  int mm;
  String time;

  HoursMinutes(int hh, int mm, String time) {
    this.hh = hh;
    this.mm = mm;
    this.time = time;
  }

  @Override
  public int compareTo(HoursMinutes other) {
    if (this.hh > other.hh)
      return 1;
    else if (this.hh < other.hh)
      return -1;
    else {
      if (this.mm > other.mm)
        return 1;
      else if (this.mm < other.mm)
        return -1;
      else
        return 0;
    }
  }
}

public class MinTimeDifference {

  static int giveHHs(String str) {
    return (str.charAt(0) - '0') * 10 + str.charAt(1) - '0';
  }

  static int giveMMs(String str) {
    return (str.charAt(3) - '0') * 10 + str.charAt(4) - '0';
  }

  static int findMinDifference(List<String> timePoints) {
    int n = timePoints.size();
    List<Integer> hours = new ArrayList<>();
    List<Integer> mins = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      hours.add(giveHHs(timePoints.get(i)));
      mins.add(giveMMs(timePoints.get(i)));
    }
    List<HoursMinutes> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(new HoursMinutes(hours.get(i), mins.get(i), timePoints.get(i)));
    Collections.sort(list);
    int minDiff = Integer.MAX_VALUE;
    List<Integer> time = new ArrayList<>();
    for (int i = 0; i < n; i++)
      time.add(list.get(i).hh * 60 + list.get(i).mm);
    for (int i = 0; i < n - 1; i++)
      minDiff = Math.min(minDiff, time.get(i + 1) - time.get(i));
    return Math.min(minDiff, time.get(0) + (1440 - time.get(n - 1)));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      List<String> timePoints = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        timePoints.add(sc.next());
      }
      System.out.println(findMinDifference(timePoints));
    }
  }
}
