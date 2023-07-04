package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PrintLeftView {

  static int maxLevel = 0;

  static class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
      this.val = val;
    }
  }

  static Node buildTree(String str) {
    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }
    String ip[] = str.split(" ");
    Node root = new Node(Integer.parseInt(ip[0]));
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    int i = 1;
    while (queue.size() > 0 && i < ip.length) {
      Node currNode = queue.peek();
      queue.remove();
      String currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.left = new Node(Integer.parseInt(currVal));
        queue.add(currNode.left);
      }
      i++;
      if (i >= ip.length)
        break;
      currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.right = new Node(Integer.parseInt(currVal));
        queue.add(currNode.right);
      }
      i++;
    }
    return root;
  }

  static List<Integer> leftViewDFS(Node root, List<Integer> result, int level) {
    if (root == null) {
      return result;
    }
    if(level > maxLevel) {
      result.add(root.val);
      maxLevel = level;
    }
    leftViewDFS(root.left, result, level+1);
    leftViewDFS(root.right, result, level + 1);
    return result;
  }

  static List<Integer> leftViewBFS(Node root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    result.add(root.val);
    while(queue.size() > 1) {
      Node curNode = queue.remove();
      if(curNode == null) {
        result.add(queue.peek().val);
        queue.add(null);
        continue;
      }
      if (curNode.left != null)
        queue.add(curNode.left);
      if (curNode.right != null)
        queue.add(curNode.right);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      Node root = buildTree(str);
      System.out.println(leftViewDFS(root, new ArrayList<>(), 1));
      System.out.println(leftViewBFS(root));
    }
  }
}
