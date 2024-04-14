package myPackage.j2Maths;

import java.util.Scanner;

public class BaseConversions {
    public static int baseConversion(long n, int b1, int b2){
        int base2 = 0;
        long base1 = 0;
        int pow = 0;
        while (n != 0)
        {
            long rem = n%10;
            base1 += rem*Math.pow(b1,pow++);
            n /= 10;
        }
        pow = 0;
        while (base1 != 0)
        {
            long rem = base1%b2;
            base2 += rem*Math.pow(10,pow++);
            base1 /= b2;
        }
        return base2;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner (System.in)) {
            //        Base 1 to Base 2 Conversion
                    long base1 = sc.nextLong();
                    System.out.println(baseConversion(base1, 2, 8));
        }
    }
}
