package myPackage.j6Searching;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int a, int start, int end){
        if (start > end)
        {
            return -1;
        }
        else
        {
            int mid = start + (end-start)/2;
            if (arr[mid] == a)
            {
                return mid;
            }
            else if (arr[mid] < a)
            {
                return binarySearch(arr, a, mid+1, end);
            }
            else
            {
                return binarySearch(arr, a, start, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] x = {5,6,8,1,3,0,9,1};
        Arrays.sort(x);
        for (int element: x) {
            System.out.print(element + " ");
        }
        System.out.println();
        int y = 2;
        int s = 0;
        int e = x.length-1;
        System.out.println("Index: " + binarySearch(x,y,s,e));
    }
}