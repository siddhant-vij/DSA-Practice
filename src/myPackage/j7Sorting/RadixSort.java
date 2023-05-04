// Radix Sort Algorithm
// The lower bound for the Comparison based sorting algorithm (Merge Sort, Quick-Sort) is O(nLogn).
// Counting sort is a linear time sorting algorithm that sort in O(n+k) time when elements are in the range from 1 to k.

// What if the elements are in the range from 1 to n2?
// We can’t use counting sort because counting sort will take O(n2)which is worse than comparison-based sorting algorithms.

// Can we sort such an array in linear time?
// Radix Sort is the answer.The idea of Radix Sort is to do digit by digit sort
// starting from least significant digit to most significant digit.
// Radix sort uses counting sort as a subroutine to sort.

// TC: O(d*(n+b)), d = digits in max number of the array, b = base of number system
// SC: O(n+b)

// Is Radix Sort preferable to Comparison based sorting algorithms like Quick-Sort?
// Running time of Radix appears to be better than Quick Sort for a wide range of input numbers.
// The constant factors hidden in asymptotic notation are higher for Radix Sort and Quick-Sort uses hardware caches more effectively.
// Also, Radix sort uses counting sort as a subroutine and counting sort takes extra space to sort numbers.

// Start sorting from the rightmost position and use a stable algorithm at each position.
// Radix sort is not an in-place algorithm as it uses a temporary count array.

// Radix Sort on Strings: Radix sort is mostly used to sort the numerical values or the real values,
// but it can be modified to sort the string values in lexicographical order.
// It follows the same procedure as used for numerical values.

package myPackage.j7Sorting;

import java.util.ArrayList;

public class RadixSort {

  public static int getDigit(int position, String value, int radix) {
    int nos = value.length() - 1;
    char c = value.toLowerCase().charAt(nos - position);
    return (int) c - 'a';
  }

  static void countSortString(String[] input, int position, int radix) {
    int[] countArray = new int[radix];
    int nos = input.length;

    for (String value : input) {
      countArray[getDigit(position, value, radix)]++;
    }

    for (int i = 1; i < radix; i++) {
      countArray[i] = countArray[i] + countArray[i - 1];
    }

    String[] tempArray = new String[nos];

    for (int i = nos - 1; i >= 0; i--) {
      tempArray[--countArray[getDigit(position, input[i], radix)]] = input[i];
    }
    for (int i = 0; i < nos; i++) {
      input[i] = tempArray[i];
    }
  }

  static void radixSortStrings(String[] input) {
    for (int i = 0; i < input[0].length(); i++) {
      countSortString(input, i, 26);
    }
  }

  static int getMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++)
      if (arr[i] > max)
        max = arr[i];
    return max;
  }

  static void countSortNumbers(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];

    for (int i = 0; i < n; i++)
      count[(arr[i] / exp) % 10]++;

    for (int i = 1; i < 10; i++)
      count[i] += count[i - 1];

    for (int i = n - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }

    for (int i = 0; i < n; i++)
      arr[i] = output[i];
  }

  static void radixSortPositive(int[] arr) {
    int max = getMax(arr);
    for (int exp = 1; max / exp > 0; exp *= 10)
      countSortNumbers(arr, exp);
  }

  static void radixSortNegative(int[] arr) {
    for (int i = 0; i < arr.length; i++)
      arr[i] *= -1;
    int max = getMax(arr);
    for (int exp = 1; max / exp > 0; exp *= 10)
      countSortNumbers(arr, exp);

    int n = arr.length;
    int s = 0;
    int e = n - 1;
    while (s <= e) {
      int temp = -1 * arr[s];
      arr[s] = -1 * arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }

  static void radixSortCombination(int[] arr) {
    ArrayList<Integer> positive = new ArrayList<>();
    ArrayList<Integer> negative = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0)
        negative.add(arr[i]);
      else
        positive.add(arr[i]);
    }
    int[] pos = new int[positive.size()];
    int[] neg = new int[negative.size()];
    for (int i = 0; i < pos.length; i++)
      pos[i] = positive.get(i);
    for (int i = 0; i < neg.length; i++)
      neg[i] = negative.get(i);
    radixSortPositive(pos);
    radixSortNegative(neg);
    for (int i = 0; i < arr.length; i++) {
      if (i < neg.length)
        arr[i] = neg[i];
      else
        arr[i] = pos[i - neg.length];
    }
  }

  public static void main(String[] args) {
    int[] x = { 5, 8, 1, 3, 0, 9 };
    radixSortPositive(x);
    for (int element : x) {
      System.out.print(element + " ");
    }
    System.out.println();

    int[] y = { -5, -8, -1, -3, -6, -9 };
    radixSortNegative(y);
    for (int element : y) {
      System.out.print(element + " ");
    }
    System.out.println();

    int[] z = { -5, -8, 1, -3, 0, 9 };
    radixSortCombination(z);
    for (int element : z) {
      System.out.print(element + " ");
    }
    System.out.println();

    String arr[] = { "BCDEF", "dbaqc", "abcde", "bbbbb" };
    radixSortStrings(arr);
    for (String element : arr) {
      System.out.print(element + " ");
    }
  }
}
