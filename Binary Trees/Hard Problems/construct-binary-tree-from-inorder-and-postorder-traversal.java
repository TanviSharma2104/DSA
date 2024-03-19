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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode build(int[] inorder, int inStart, int inEnd ,int[] postorder,int postStart, int postEnd){
        if(inStart>inEnd || postStart>postEnd)return null;

        int rootval=postorder[postEnd];
        TreeNode root=new TreeNode(rootval);

        //find in inorder
        int index=0;
        for(int i=inStart; i<=inEnd;i++){
            if(inorder[i]==rootval){
                index=i;
                break;
            }
        }
        int leftsize=index-inStart;
        int rightsize=inEnd-index;
        root.left=build(inorder, inStart, index-1, postorder, postStart, postStart + leftsize - 1);
        root.right=build(inorder, index+1, inEnd, postorder, postEnd-rightsize, postEnd-1);
        return root;
    }
}
