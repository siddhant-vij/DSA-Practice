package myPackage.j1basics;

public class ArrayRotation {
    static void reverseArray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        //O(n)
        // int temp = 0;
        if (k > arr.length && k % arr.length != 0)
            k = k % arr.length;
        else if (k % arr.length == 0)
            k = arr.length;
        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, arr.length - 1);

        //O(n^2)
        /*for (int i = 1; i <= k; i++) {
            temp = arr[arr.length-1];
            for (int j = arr.length-2; j >= 0 ; j--) {
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }*/

        //Display Final Array
        for (int element: arr) {
            System.out.print(element + " ");
        }
    }
}
