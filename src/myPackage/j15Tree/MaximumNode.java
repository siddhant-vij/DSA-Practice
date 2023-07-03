package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumNode {

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

  static int getMaxDFS(Node root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    return Math.max(root.val, Math.max(getMaxDFS(root.left), getMaxDFS(root.right)));
  }

  static int getMaxBFS(Node root) {
    if(root == null) {
      return Integer.MIN_VALUE;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    int maxValue = Integer.MIN_VALUE;
    while(!queue.isEmpty()) {
      Node curNode = queue.remove();
      maxValue = Math.max(curNode.val, maxValue);
      if(curNode.left != null)
        queue.add(curNode.left);
      if (curNode.right != null)
        queue.add(curNode.right);
    }
    return maxValue;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      Node root = buildTree(str);
      System.out.println(getMaxDFS(root));
      System.out.println(getMaxBFS(root));
    }
  }
}
