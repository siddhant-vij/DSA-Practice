// Similar logic applies to the first and last occurences of an element in Infinite sized sorted array

package myPackage.j6Searching;

public class InfiniteSortedSearch {

  static int bSearch(int[] arr, int low, int high, int x) {
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == x)
        return mid;
      else if (arr[mid] > x)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }

  static int binaryInfiniteSearch(int[] arr, int x) {
    if (arr[0] == x)
      return 0;
    int i = 1;
    while (arr[i] < x)
      i = i * 2;
    if (arr[i] == x)
      return i;
    return bSearch(arr, i / 2 + 1, i - 1, x);
  }

  static int linearInfiniteSearch(int[] arr, int x) {
    int i = 0;
    while (true) {
      if (arr[i] == x)
        return i;
      if (arr[i] > x)
        return -1;
      i++;
    }
  }

  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 40, 50 };
    int x = 4;

    // Assume that an infinite array is passed to you.
    // How: By passing a multi-million (or bigger) size array
    // such that the element to be searched lies in the leftmost part
    // Array size is so big that even Log(n) is greater thatn 10^8
    // such that if we take end = size()-1 - it throws TLE

    System.out.println(linearInfiniteSearch(arr, x)); // TC: O(position)
    System.out.println(binaryInfiniteSearch(arr, x)); // TC: O(Log(Position))
  }
}
