package myPackage.j2maths;

public class Fibonacci {
    public static boolean isFibonacciSeries(int[] x){
        boolean isFibonacci = true;
        for (int i = 0; i < x.length-2; i++) {
            if (x[i + 2] != (x[i + 1] + x[i])) {
                isFibonacci = false;
                break;
            }
        }
        return isFibonacci;
    }
    public static int nFibonacci(int n)
    {
        if (n == 1 || n == 2){
            return n-1;
        } else {
            return nFibonacci(n-1) + nFibonacci(n-2);
        }
    }
    public static long nFibonacci2(int n)
    {
        if (n == 1 || n == 2){
            return n-1;
        } else {
            long a = 0L, b = 1L;
            long c = 0L;
            for (int i = 3; i <= n ; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
    
    public static long nFibonacci3 (int n){
        return (long)((Math.pow((1+Math.sqrt(5))/2,n-1) - Math.pow((1+-Math.sqrt(5))/2,n-1))/Math.sqrt(5));
    }
    
    public static void main(String[] args) {
        int[] arr = {0,1,1,2,3,5,8,13,21,34,55};
        System.out.println(isFibonacciSeries(arr));
        int x = 45;
//        System.out.println(nFibonacci(x)); // O(2^n)
        System.out.println(nFibonacci2(x)); // O(n)
//        System.out.println(nFibonacci3(x)); // O(1)
    }
}