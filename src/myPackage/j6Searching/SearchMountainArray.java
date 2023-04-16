// Leetcode: 1095 - Find in Mountain Array

package myPackage.j6Searching;

import java.util.Scanner;

interface MntArr {
  public int get(int index);

  public int length();
}

class MountainArray implements MntArr {
  private int[] mountainArr;

  public MountainArray(int[] mountainArr) {
    this.mountainArr = mountainArr;
  }

  @Override
  public int get(int index) {
    return this.mountainArr[index];
  }

  @Override
  public int length() {
    return this.mountainArr.length;
  }
}

public class SearchMountainArray {

  static int calls = 0;

  static int isPresentBinarySearchDec(MountainArray mountainArr, int x, int low, int high) {
    while (low <= high) {
      int mid = (low + high) / 2;
      int curMid = mountainArr.get(mid);
      calls++;
      if (curMid == x)
        return mid;
      else if (curMid < x)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }

  static int isPresentBinarySearchInc(MountainArray mountainArr, int x, int low, int high) {
    while (low <= high) {
      int mid = (low + high) / 2;
      int curMid = mountainArr.get(mid);
      calls++;
      if (curMid == x)
        return mid;
      else if (curMid > x)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }

  static int findPeakElement(MountainArray mountainArr) {
    int n = mountainArr.length();
    if (n == 1)
      return 0;
    int s = 0;
    int e = n - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      int curMid = mountainArr.get(m);
      calls++;
      if (m > 0 && m < n - 1) {
        int curMidLessOne = mountainArr.get(m - 1);
        int curMidPlusOne = mountainArr.get(m + 1);
        calls += 2;
        if (curMid > curMidLessOne && curMid > curMidPlusOne)
          return m;
        else if (curMid > curMidLessOne && curMid < curMidPlusOne)
          s = m + 1;
        else
          e = m - 1;
      } else if (m == 0) {
        int curMidPlusOne = mountainArr.get(m + 1);
        calls++;
        if (curMid > curMidPlusOne)
          return 0;
        else
          s = m + 1;
      } else {
        int curMidLessOne = mountainArr.get(m - 1);
        calls++;
        if (curMid > curMidLessOne)
          return n - 1;
        else
          e = m - 1;
      }
    }
    return -1;
  }

  static int findInMountainArray(int target, MountainArray mountainArr) {
    int peakIndex = 0;
    if (calls <= 100)
      peakIndex = findPeakElement(mountainArr);
    if (calls++ <= 100 && mountainArr.get(peakIndex) == target)
      return peakIndex;
    int valLeft = isPresentBinarySearchInc(mountainArr, target, 0, peakIndex - 1);
    if (calls <= 100 && valLeft != -1)
      return valLeft;
    else {
      int valRight = isPresentBinarySearchDec(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
      if (calls <= 100 && valRight != -1)
        return valRight;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      MountainArray mountainArray = new MountainArray(arr);
      System.out.println(findInMountainArray(target, mountainArray));
    }
  }
}
