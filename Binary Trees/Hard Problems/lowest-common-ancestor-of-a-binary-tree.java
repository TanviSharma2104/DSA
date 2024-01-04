/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode leftside=lowestCommonAncestor(root.left,p,q);
        TreeNode rightside=lowestCommonAncestor(root.right,p,q);
        if(leftside==null)return rightside;
        else if(rightside==null)return leftside;
        else return root;

    }
}
