// Leetcode: 106. Construct Binary Tree from Inorder and Postorder Traversal

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ConvertPostInToTree {

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

  static List<Integer> preOrderTraversal(Node root, List<Integer> result) {
    if (root == null) {
      return result;
    }
    result.add(root.val);
    preOrderTraversal(root.left, result);
    preOrderTraversal(root.right, result);
    return result;
  }

  static int postIndex;

  static Node convertI(int[] post, int[] in, int indexS, int indexE) {
    if (indexS > indexE) {
      return null;
    }
    Node root = new Node(post[postIndex--]);
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
    root.right = convertI(post, in, index + 1, indexE);
    root.left = convertI(post, in, indexS, index - 1);
    return root;
  }

  static int postIdx;
  static Map<Integer, Integer> map = new HashMap<>();

  static Node convertII(int[] post, int[] in, int indexS, int indexE) {
    if (indexS > indexE) {
      return null;
    }
    Node root = new Node(post[postIdx--]);
    if (indexS == indexE) {
      return root;
    }
    int index = map.get(root.val);
    root.right = convertII(post, in, index + 1, indexE);
    root.left = convertII(post, in, indexS, index - 1);
    return root;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      postIndex = n - 1;
      postIdx = n - 1;
      int[] post = new int[n];
      for (int i = 0; i < post.length; i++) {
        post[i] = sc.nextInt();
      }
      int[] in = new int[n];
      for (int i = 0; i < in.length; i++) {
        in[i] = sc.nextInt();
        map.put(in[i], i);
      }
      System.out.println(preOrderTraversal(convertI(post, in, 0, n - 1), new ArrayList<>()));
      System.out.println(preOrderTraversal(convertII(post, in, 0, n - 1), new ArrayList<>()));
    }
  }

}
