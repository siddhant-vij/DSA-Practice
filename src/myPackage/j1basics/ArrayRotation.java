package myPackage.j1basics;

public class ArrayRotation {
    public static void reverseArray(int[] x, int start, int end){
        for (int i = start; i <= end-1 ; i++) {
            int temp = x[end];
            x[end--] = x[start];
            x[start++] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        //O(n)
        // int temp = 0;
        reverseArray(arr,0,arr.length-k-1);
        reverseArray(arr,arr.length-k,arr.length-1);
        reverseArray(arr,0,arr.length-1);

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
