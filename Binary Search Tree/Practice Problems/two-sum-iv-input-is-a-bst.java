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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> li=new ArrayList<>();
        inorder(root,li);
        int i=0, j=li.size()-1;
        while(i<j){
            int curr=li.get(i)+li.get(j);
            if(curr==k)return true;
            if(curr<k){
                i++;
            }
            else j--;
        }
        return false;

    }
    private void inorder(TreeNode root, List<Integer> li){
        if(root==null)return;
        inorder(root.left,li);
        li.add(root.val);
        inorder(root.right, li);
    }
}

//or


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
    public boolean findTarget(TreeNode root, int k){
        return helper(root,root,k);
    }
    public boolean helper(TreeNode root,TreeNode current,int k){
        if(current==null){
            return false;
        }
        if(findInTree(root,current,k-current.val)){
            return true;
        }
        
        return helper(root,current.left,k)||helper(root,current.right,k);
    }
    public boolean findInTree(TreeNode root,TreeNode current,int k){
        if(root==null){
            return false;
        }
        
        if(root.val>k){
            return findInTree(root.left,current,k);
        }
        else if(root.val<k){
            return findInTree(root.right,current,k);
        }
        else{
            return k!=current.val;
        }
        
    }
        
}
