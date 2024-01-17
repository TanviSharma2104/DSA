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
    int count=0;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return res;

    }

    private void inorderTraversal(TreeNode root, int k){
        if(root==null)return ;
        inorderTraversal(root.left, k);
        count++;
        if(count==k){
            res=root.val;
            return;
        }

        inorderTraversal(root.right,k);
    }
}
