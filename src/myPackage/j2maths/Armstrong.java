package myPackage.j2Maths;

public class Armstrong {
  public static boolean isArmstrong(int n){
    int sum = 0;
    int m = n;
    while (m > 0)
    {
      int dig = m % 10;
      sum += (dig*dig*dig);
      m /= 10;
    }
    return sum==n;
  }
  
  public static void main(String[] args) {
    int n = 153;
    System.out.println(isArmstrong(n));
  }
}
