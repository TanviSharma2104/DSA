/*********************************************

 Following is the TreeNode class structure

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

 *********************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode n, int l){
        node=n;
        level=l;
    }
}
public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
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
            if (!map.containsKey(lev)) {
                map.put(lev, temp.data); 
            }

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
