// Counting Sort Algorithm
// Counting sort is a sorting technique based on keys between a specific range.
// It works by counting the number of objects having distinct key values (kind of hashing).
// Then do some arithmetic to calculate the position of each object in the output sequence.

// Like other algorithms this sorting algorithm is not a comparison-based algorithm,
// it hashes the value in a temporary count array and uses them for sorting.
// It uses a temporary array making it a non In Place algorithm.

// Time Complexity: O(n+k) where n is the number of elements in the input array and k is the range of input. 
// Auxiliary Space: O(n+k)

// The problem with the positive counting sort was that we could not sort the elements if we have negative numbers in it.
// Because there are no negative array indices. So what we do is, we find the minimum element
// and we will store the count of that minimum element at zero index.

// Time complexity: O(n), where n is total number of elements
// Auxiliary Space: O(n)

// Counting sort can be extended to work for negative inputs also.
// Similar approach can be extended to sorting String as k is always fixed
// 1. For only lower case or upper case characters: 26
// 2. For both lower case & uppercase characters: 26*2 = 52
// 3. For general purpose strings: use k = 256

package myPackage.j7Sorting;

import java.util.Arrays;

public class CountingSort {

  static void countingSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int min = Arrays.stream(arr).min().getAsInt();
    int range = max - min + 1;
    int count[] = new int[range];
    int output[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i] - min]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = output[i];
    }
  }

  public static void main(String[] args) {
    int[] x = { 5, 8, 1, 3, 0, 9 };
    countingSort(x);
    for (int element : x) {
      System.out.print(element + " ");
    }
  }
}
