// Leetcode: 103. Binary Tree Zigzag Level Order Traversal

package myPackage.j15Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreeTraversalSpiral {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  static TreeNode buildTree(String str) {
    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }
    String ip[] = str.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int i = 1;
    while (queue.size() > 0 && i < ip.length) {
      TreeNode currNode = queue.peek();
      queue.remove();
      String currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.left = new TreeNode(Integer.parseInt(currVal));
        queue.add(currNode.left);
      }
      i++;
      if (i >= ip.length)
        break;
      currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.right = new TreeNode(Integer.parseInt(currVal));
        queue.add(currNode.right);
      }
      i++;
    }
    return root;
  }

  static List<List<Integer>> zigzagLevelOrderI(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    int count = 0;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    while (queue.size() > 1) {
      TreeNode cur = queue.remove();
      if (cur != null) {
        list.add(cur.val);
        if (cur.left != null)
          queue.add(cur.left);
        if (cur.right != null)
          queue.add(cur.right);
      } else {
        count++;
        if (count % 2 == 0) {
          Collections.reverse(list);
          result.add(list);
        } else {
          result.add(list);
        }
        queue.add(null);
        list = new ArrayList<>();
      }
    }
    count++;
    if (count % 2 == 0) {
      Collections.reverse(list);
      result.add(list);
    } else {
      result.add(list);
    }
    return result;
  }

  static List<List<Integer>> zigzagLevelOrderII(TreeNode root) {
    if (root == null)
      return new ArrayList<>();
    Deque<TreeNode> s1 = new ArrayDeque<TreeNode>();
    Deque<TreeNode> s2 = new ArrayDeque<TreeNode>();
    List<List<Integer>> result = new ArrayList<>();
    s1.push(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      boolean test = false;
      while (!s1.isEmpty()) {
        test = true;
        TreeNode temp = s1.pop();
        list.add(temp.val);
        if (temp.left != null)
          s2.push(temp.left);
        if (temp.right != null)
          s2.push(temp.right);
      }
      if (test)
        result.add(list);
      list = new ArrayList<>();
      test = false;
      while (!s2.isEmpty()) {
        test = true;
        TreeNode temp = s2.pop();
        list.add(temp.val);
        if (temp.right != null)
          s1.push(temp.right);
        if (temp.left != null)
          s1.push(temp.left);
      }
      if(test)
        result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(zigzagLevelOrderI(root));
      System.out.println(zigzagLevelOrderII(root));
    }
  }
}
