/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.data = val;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;
public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack1.isEmpty() || !stack2.isEmpty() || root1 != null || root2 != null) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().data <= stack2.peek().data)) {
                root1 = stack1.pop();
                ans.add(root1.data);
                root1 = root1.right;
            } else {
                root2 = stack2.pop();
                ans.add(root2.data);
                root2 = root2.right;
            }
        }
        return ans;

    }
}
