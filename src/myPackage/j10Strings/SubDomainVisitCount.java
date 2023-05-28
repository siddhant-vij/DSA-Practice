// Leetcode: 811. Subdomain Visit Count

package myPackage.j10Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SubDomainVisitCount {

  static List<String> subdomainVisits(String[] cpdomains) {
    int n = cpdomains.length;
    int[] visits = new int[n];
    String[] domains = new String[n];
    for (int i = 0; i < n; i++) {
      visits[i] = Integer.parseInt(cpdomains[i].split(" ")[0]);
      domains[i] = cpdomains[i].split(" ")[1];
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (domains[i].indexOf(".") != domains[i].lastIndexOf(".")) {
        String[] temp = domains[i].trim().split("\\.");
        String domain1 = temp[1] + "." + temp[2];
        String domain2 = temp[2];
        map.put(domains[i], map.getOrDefault(domains[i], 0) + visits[i]);
        map.put(domain1, map.getOrDefault(domain1, 0) + visits[i]);
        map.put(domain2, map.getOrDefault(domain2, 0) + visits[i]);
      } else {
        String[] temp = domains[i].trim().split("\\.");
        String domain2 = temp[1];
        map.put(domains[i], map.getOrDefault(domains[i], 0) + visits[i]);
        map.put(domain2, map.getOrDefault(domain2, 0) + visits[i]);
      }
    }
    List<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      result.add(entry.getValue() + " " + entry.getKey());
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] cpdomains = new String[n];
      for (int i = 0; i < n; i++) {
        cpdomains[i] = sc.next();
      }
      System.out.println(subdomainVisits(cpdomains));
    }
  }
}
