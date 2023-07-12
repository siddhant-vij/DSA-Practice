// Leetcode: 297. Serialize and Deserialize Binary Tree

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SerializeDeserializeTree {

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

  static String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    Stack<TreeNode> s = new Stack<>();
    s.push(root);

    List<String> l = new ArrayList<>();
    while (!s.isEmpty()) {
      TreeNode t = s.pop();
      if (t == null) {
        l.add("#");
      } else {
        l.add("" + t.val);
        s.push(t.right);
        s.push(t.left);
      }
    }
    return String.join(",", l);
  }

  static int t;

  static public TreeNode deserialize(String data) {
    if (data == null)
      return null;
    t = 0;
    String[] arr = data.split(",");
    return helper(arr);
  }

  static TreeNode helper(String[] arr) {
    if (arr[t].equals("#"))
      return null;
    TreeNode root = new TreeNode(Integer.parseInt(arr[t]));
    t++;
    root.left = helper(arr);
    t++;
    root.right = helper(arr);
    return root;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(deserialize(serialize(root)));
    }
  }
}
