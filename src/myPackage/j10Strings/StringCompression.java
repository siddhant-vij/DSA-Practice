// Leetcode: 443 - String Compression

package myPackage.j10Strings;

import java.util.Scanner;

public class StringCompression {

  static int compress(String str) {
    char[] chars = str.toCharArray();
    int n = chars.length;
    int cur = 0;
    int ans = 0;
    while (cur < n) {
      int test = cur + 1;
      while (test < n && chars[cur] == chars[test])
        test++;
      int count = test - cur;
      if (count != 1) {
        chars[ans++] = chars[cur];
        if (count <= 9)
          chars[ans++] = (char) (count + '0');
        else {
          int len = 1 + (int) Math.floor(Math.log10(count));
          ans += len - 1;
          while (count != 0) {
            chars[ans--] = (char) (count % 10 + '0');
            count /= 10;
          }
          ans += len + 1;
        }
        cur = test;
      } else {
        chars[ans++] = chars[cur];
        cur++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(compress(str));
    }
  }
}
