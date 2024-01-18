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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE);
    }
    private TreeNode bst(int[] arr, int bound){
        if(i==arr.length || arr[i]> bound)return null;
        TreeNode root=new TreeNode(arr[i++]);
        root.left=bst(arr,root.val);
        root.right=bst(arr, bound);
        return root;
    }
}
