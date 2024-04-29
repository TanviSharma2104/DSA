/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode n, int l){
        node=n;
        level=l;
    }
}
public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here. 
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int lev=curr.level;
            TreeNode temp=curr.node;
            
                map.put(lev, temp.val); 
            

            if(temp.left!=null){
                q.add(new Pair(temp.left, lev-1));
            }
            if(temp.right!=null){
                q.add(new Pair(temp.right, lev+1));
            }
        }

        
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;

              
    }
}

