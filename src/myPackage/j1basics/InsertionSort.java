package myPackage.j1basics;

public class InsertionSort {
    public static void insertionSort(int[] x){
        for (int i = 1; i < x.length; i++) {
            for (int j = i; j >= 1; j--){
                if (x[j-1] > x[j]){
                    int value = x[j];
                    x[j] = x[j-1];
                    x[j-1] = value;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] x = {5,5,8,1,3,0,9};
        for (int element: x) {
            System.out.print(element + " ");
        }
        System.out.println();
        insertionSort(x);
        for (int element: x) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
