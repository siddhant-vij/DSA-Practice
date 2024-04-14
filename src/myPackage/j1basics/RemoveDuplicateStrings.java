package myPackage.j1Basics;

import java.util.Scanner;

public class RemoveDuplicateStrings {
  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] strings = new String[n];
      for (int i = 0; i < n; i++) {
        strings[i] = sc.next();
      }

      for (int i = 0; i < n; i++) {
        int count = 0;
        if (strings[i] != null) {
          for (int j = 0; j < n; j++) {
            if (strings[j] != null) {
              if (i != j) {
                if (strings[i].equals(strings[j])) {
                  count++;
                  strings[j] = null;
                }
              }
            }
          }
          if (count != 0)
            strings[i] = null;
        }
      }
      for (int i = 0; i < strings.length; i++) {
        if (i == strings.length-1)
          System.out.println(strings[i]);
        else
          System.out.print(strings[i] + ", ");
      }
    }
  }
}
