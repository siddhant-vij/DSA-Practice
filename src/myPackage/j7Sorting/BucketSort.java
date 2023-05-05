// Bucket Sort Algorithm
// Bucket sort is mainly useful when input is uniformly distributed over a range.
// For example, consider the following problem. 
// Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range.
// How do we sort the numbers efficiently?

// A simple way is to apply a comparison based sorting algorithm.
// The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is O(n Log n)
// Can we sort the array in linear time?
// Counting sort can not be applied here as we use keys as index in counting sort. Similar issue if integer range is very large.
// Here keys are floating point numbers.
// The solution is to use bucket sort.

// TC (Best Case): O(n) - when elements are uniformly distributed and each bucket has 1 element each
// TC (Worst Case): O(n^2) - when insertion sort is used but elements are unevenly distributed
// TC (Worst Case): O(n log n) - when any NLogN algorithm is used for individual bucket

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

  static void bucketSortFloatPositive(float arr[]) {
    int n = arr.length;
    if (n <= 0)
      return;

    float max_val = arr[0];
    for (int i = 1; i < n; i++)
      max_val = Math.max(max_val, arr[i]);
    max_val++;

    ArrayList<ArrayList<Float>> buckets = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      buckets.add(new ArrayList<Float>());
    }

    for (int i = 0; i < n; i++) {
      int idx = (int) arr[i] * n / (int) max_val;
      buckets.get(idx).add(arr[i]);
    }

    for (int i = 0; i < n; i++) {
      Collections.sort(buckets.get(i));
    }

    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < buckets.get(i).size(); j++) {
        arr[index++] = buckets.get(i).get(j);
      }
    }
  }

  static void bucketSortFloatNegative(float[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++)
      arr[i] *= -1;

    bucketSortFloatPositive(arr);
    int s = 0;
    int e = n - 1;
    while (s <= e) {
      float temp = -1 * arr[s];
      arr[s] = -1 * arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }

  static void bucketSortFloatPosNeg(float[] arr) {
    ArrayList<Float> pos = new ArrayList<>();
    ArrayList<Float> neg = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0)
        neg.add(arr[i]);
      else
        pos.add(arr[i]);
    }
    float[] negative = new float[neg.size()];
    for (int i = 0; i < neg.size(); i++)
      negative[i] = neg.get(i);

    float[] positive = new float[pos.size()];
    for (int i = 0; i < pos.size(); i++)
      positive[i] = pos.get(i);

    bucketSortFloatNegative(negative);
    bucketSortFloatPositive(positive);

    for (int i = 0; i < arr.length; i++) {
      if (i < negative.length)
        arr[i] = negative[i];
      else
        arr[i] = positive[i - negative.length];
    }
  }

  public static void main(String[] args) {
    float x[] = { 0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f };
    bucketSortFloatPositive(x);
    for (float element : x) {
      System.out.print(element + " ");
    }
    System.out.println();

    float y[] = { -0.897f, -0.565f, -0.656f, -0.1234f, -0.665f, -0.3434f };
    bucketSortFloatNegative(y);
    for (float element : y) {
      System.out.print(element + " ");
    }
    System.out.println();

    float z[] = { -0.897f, 0.565f, -0.656f, 0.1234f, -0.665f, 0.3434f };
    bucketSortFloatPosNeg(z);
    for (float element : z) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}
