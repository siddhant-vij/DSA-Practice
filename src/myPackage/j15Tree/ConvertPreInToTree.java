// Leetcode: 105. Construct Binary Tree from Preorder and Inorder Traversal

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ConvertPreInToTree {

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

  static List<Integer> inOrderTraversal(Node root, List<Integer> result) {
    if (root == null) {
      return result;
    }
    inOrderTraversal(root.left, result);
    result.add(root.val);
    inOrderTraversal(root.right, result);
    return result;
  }

  static int preIndex = 0;

  static Node convertI(int[] pre, int[] in, int indexS, int indexE) {
    if (indexS > indexE) {
      return null;
    }
    Node root = new Node(pre[preIndex++]);
    if (indexS == indexE) {
      return root;
    }
    int index = -1;
    for (int i = indexS; i <= indexE; i++) {
      if (in[i] == root.val) {
        index = i;
        break;
      }
    }
    root.left = convertI(pre, in, indexS, index - 1);
    root.right = convertI(pre, in, index + 1, indexE);
    return root;
  }

  static int preIdx = 0;
  static Map<Integer, Integer> map = new HashMap<>();

  static Node convertII(int[] pre, int[] in, int indexS, int indexE) {
    if (indexS > indexE) {
      return null;
    }
    Node root = new Node(pre[preIdx++]);
    if (indexS == indexE) {
      return root;
    }
    int index = map.get(root.val);
    root.left = convertII(pre, in, indexS, index - 1);
    root.right = convertII(pre, in, index + 1, indexE);
    return root;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] pre = new int[n];
      for (int i = 0; i < pre.length; i++) {
        pre[i] = sc.nextInt();
      }
      int[] in = new int[n];
      for (int i = 0; i < in.length; i++) {
        in[i] = sc.nextInt();
        map.put(in[i], i);
      }
      System.out.println(inOrderTraversal(convertI(pre, in, 0, n - 1), new ArrayList<>()));
      System.out.println(inOrderTraversal(convertII(pre, in, 0, n - 1), new ArrayList<>()));
    }
  }

}
