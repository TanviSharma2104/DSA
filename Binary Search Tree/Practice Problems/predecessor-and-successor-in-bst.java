/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        List<Integer> li=new ArrayList<>();
        int pre=-1;
        TreeNode temp=root;
        while(temp!=null){
            if(key<=temp.data){
                temp=temp.left;
            }
            else{
                pre=temp.data;
                temp=temp.right;
            }
        }
        li.add(pre);


        temp=root;
        int succ=-1;
        while(temp!=null){
            if(key>=temp.data){
                temp=temp.right;
            }
            else{
                succ=temp.data;
                temp=temp.left;
            }
        }
        li.add(succ);
        return li;

    }
}
