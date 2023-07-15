// Leetcode: 508. Most Frequent Subtree Sum

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class MaxFreqSubtreeSum {

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

  static Map<Integer, Integer> map = new HashMap<>();

  static int dfs(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    int leftSum = dfs(root.left, sum);
    int rightSum = dfs(root.right, sum);
    sum = root.val + leftSum + rightSum;
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
  }

  static int[] findFrequentTreeSum(TreeNode root) {
    dfs(root, 0);
    int maxFreq = -1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      maxFreq = Math.max(maxFreq, entry.getValue());
    }
    List<Integer> resL = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxFreq)
        resL.add(entry.getKey());
    }
    int[] res = new int[resL.size()];
    for (int i = 0; i < resL.size(); i++)
      res[i] = resL.get(i);
    return res;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(Arrays.toString(findFrequentTreeSum(root)));
    }
  }
}
