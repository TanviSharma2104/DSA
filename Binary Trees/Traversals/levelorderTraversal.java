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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<TreeNode> li=new ArrayList<>();
        li.add(root);
        while(!li.isEmpty()){
            int levelSize=li.size();
            // TreeNode curr=li.get(0);
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode curr=li.get(0);
                if(curr.left!=null){
                    li.add(curr.left);
                }
                if(curr.right!=null){
                    li.add(curr.right);
                }
                li.remove(0);
                list.add(curr.val);
            }
            ans.add(list);

        }
        return ans;
    }
}
