package myPackage.j2maths;

public class Josephus {
    public static int josephus(int n, int k){
        if (n == 1){
            return 1;
        }
        else{
            return (josephus(n-1,k) + k - 1) % n + 1;
        }
    }
    public static void main(String[] args) {
        int n1 = 200;
        int k1 = 2;
        System.out.println(josephus(n1,k1));
    }
}
