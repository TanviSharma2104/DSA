// Link:- https://leetcode.com/problems/balanced-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        // if(root==null)return true;
        // if(!isBalanced(root.left))return false;
        // if(!isBalanced(root.right))return false;
        if(height(root)==-1)return false;
        return true;

    }
    public int height(TreeNode root){
        if(root==null)return 0;
        int hl=height(root.left);
        int hr=height(root.right);
        if(hl==-1 ||hr==-1)return -1;
        if(Math.abs(hl-hr)>1)return -1;
        return Math.max(hl,hr)+1;
    }
}
