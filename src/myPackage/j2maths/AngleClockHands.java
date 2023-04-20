// Leetcode: 1344 - Angle Between Hands of a Clock

package myPackage.j2maths;

import java.util.Scanner;

public class AngleClockHands {

  static double angleClock(int hour, int minutes) {
    double hrsA = (hour * 1.0 * 360 / 12) + ((minutes * 1.0 * 360) / (60 * 12));
    double minsA = minutes * 1.0 * 360 / 60;
    double diff = Math.abs(hrsA - minsA);
    if (diff <= 180)
      return diff;
    else
      return 360 - diff;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int hrs = sc.nextInt();
      int mins = sc.nextInt();
      System.out.println(angleClock(hrs, mins));
    }
  }
}
