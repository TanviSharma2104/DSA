/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        // if(root==null)return;
        List<Integer> ans=new ArrayList<>();
        if(!leafCheck(root))ans.add(root.data);
        leftNodes(root, ans);
        leafNodes(root, ans);
        rightNodes(root, ans);
        return ans;
        

    }

    private static boolean leafCheck(TreeNode node){
        if(node.left==null && node.right==null)return true;
        return false;
    }

    private static List<Integer> leftNodes(TreeNode root, List<Integer> ans){
        TreeNode curr=root.left;
        
        while(curr!=null){
            if(!leafCheck(curr)){
                ans.add(curr.data);
        
            }
            if(curr.left!=null){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }

        }
        return ans;
    }

    private static void leafNodes(TreeNode root, List<Integer> ans){
        if(leafCheck(root)){
            ans.add(root.data);
            return ;
        }
        if(root.left!=null) leafNodes(root.left, ans);
        if(root.right!=null) leafNodes(root.right, ans);

        
    }

    private static List<Integer> rightNodes(TreeNode root, List<Integer> ans){
        TreeNode curr=root.right;
        List<Integer> temp=new ArrayList<>();
        
        while(curr!=null){
            if(!leafCheck(curr)){
                temp.add(curr.data);
        
            }
            if(curr.right!=null){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }

        }

        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
        return ans;
    }
}
