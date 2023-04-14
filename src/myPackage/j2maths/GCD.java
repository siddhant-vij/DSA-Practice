package myPackage.j2maths;

import java.math.BigInteger;

public class GCD {
    public static int gcdEuclidean(int A, int B) {
        if (A == 0 || B == 0)
            return Math.max(A,B);
        else if (A == B)
            return A;
        else if (A > B)
            return gcdEuclidean(A-B, B);
        else return gcdEuclidean(A, B-A);
    }
    public static int gcdModulo(int A, int B) {
        if (B == 0)
            return A;
        return gcdModulo(B, A%B);
    }
    public static int gcdBigInteger(int A, int B) {
        return ((BigInteger.valueOf(Math.abs(A)).gcd(BigInteger.valueOf(Math.abs(B)))).intValue());
    }

    public static void main(String[] args) {
        int x = 325895626;
        int y = 980123568;
        int z1 = gcdEuclidean(x,y);
        int z2 = gcdModulo(x,y);
        int z3 = gcdBigInteger(x,y);
        System.out.println(z1);
        System.out.println(z2);
        System.out.println(z3);
    }
}