// Practice: Clone a Stack - Recursion

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class CloneStackWithoutSpace {

  static Stack<Integer> clonestack(Stack<Integer> st, Stack<Integer> cloned) {
    if (st.isEmpty())
      return cloned;
    int val = st.pop();
    clonestack(st, cloned);
    cloned.push(val);
    return cloned;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Stack<Integer> st = new Stack<>();
      for (int j = 0; j < n; j++) {
        st.push(sc.nextInt());
      }
      Stack<Integer> cloned = new Stack<>();
      cloned = clonestack(st, cloned);
      for (int j : cloned) {
        System.out.print(j + " ");
      }
    }
  }  
}
