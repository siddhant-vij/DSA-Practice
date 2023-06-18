// Leetcode: 2456. Most Popular Video Creator

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MostPopularVideoCreator {

  static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
    int n = creators.length;
    Map<String, Long> creator = new HashMap<>();
    TreeMap<String, TreeMap<String, Long>> creatorId = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      if (creator.containsKey(creators[i]))
        creator.put(creators[i], 1L * creator.get(creators[i]) + 1L * views[i]);
      else
        creator.put(creators[i], 1L * views[i]);
      if (creatorId.containsKey(creators[i])) {
        TreeMap<String, Long> inner = creatorId.get(creators[i]);
        inner.put(ids[i], 1L * views[i]);
        creatorId.put(creators[i], inner);
      } else {
        TreeMap<String, Long> inner = new TreeMap<>();
        inner.put(ids[i], 1L * views[i]);
        creatorId.put(creators[i], inner);
      }
    }
    long maxViews = Long.MIN_VALUE;
    for (Map.Entry<String, Long> entry : creator.entrySet()) {
      if (entry.getValue() > maxViews) {
        maxViews = entry.getValue();
      }
    }
    Set<String> maxCreators = new HashSet<>();
    for (Map.Entry<String, Long> entry : creator.entrySet()) {
      if (entry.getValue() == maxViews) {
        maxCreators.add(entry.getKey());
      }
    }
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, TreeMap<String, Long>> entry : creatorId.entrySet()) {
      String creatorName = entry.getKey();
      TreeMap<String, Long> inner = entry.getValue();
      long max = Long.MIN_VALUE;
      for (Map.Entry<String, Long> e : inner.entrySet()) {
        if (e.getValue() > max) {
          max = e.getValue();
        }
      }
      for (Map.Entry<String, Long> e : inner.entrySet()) {
        if (e.getValue() == max && maxCreators.contains(creatorName)) {
          List<String> list = new ArrayList<>();
          list.add(creatorName);
          list.add(e.getKey());
          result.add(list);
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      String[] creators = new String[N];
      for (int i = 0; i < creators.length; i++) {
        creators[i] = sc.next();
      }
      String[] ids = new String[N];
      for (int i = 0; i < ids.length; i++) {
        ids[i] = sc.next();
      }
      int[] views = new int[N];
      for (int i = 0; i < views.length; i++) {
        views[i] = sc.nextInt();
      }
      System.out.println(mostPopularCreator(creators, ids, views));
    }
  }  
}
