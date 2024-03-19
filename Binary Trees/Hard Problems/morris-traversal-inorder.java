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
    public List<Integer> inorderTraversal(TreeNode root) {
        //morris inorder traversal
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
                //right most in left subtree
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }

                if(prev.right==null){
                    //found the rightmost thread to curr
                    prev.right=curr;
                    //made the thread connection to curr
                    curr=curr.left;
                }
                else{
                    //found the rightmost but already has a thread so remove thread
                    prev.right=null;
                    ans.add(curr.val);
                    curr=curr.right;

                }
            }
        }
        return ans;
    }
}
