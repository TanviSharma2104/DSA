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
    public int maxPathSum(TreeNode root) {
        int[] maxV=new int[1];
        maxV[0]=Integer.MIN_VALUE;
        helper(root,maxV);
        return maxV[0];
        
    }
    private int helper(TreeNode node, int[] maxV){
        if(node==null)return 0;
        int l=Math.max( 0, helper( node.left, maxV ) );
        int r=Math.max( 0, helper( node.right, maxV ) );
        maxV[0]=Math.max( maxV[0], l + r + node.val );
        return Math.max( l, r ) + node.val;
    }
}
