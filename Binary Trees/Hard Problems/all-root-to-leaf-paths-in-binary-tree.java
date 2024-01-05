/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> path=new ArrayList<>();
        solve(root,"",path);
        return path;
    }

    private static void solve(BinaryTreeNode root, String currpath, List<String> path){
        if(root==null)return;
        if(currpath.isEmpty()){
            currpath+=root.data;
        }
        else{
            currpath+=" "+root.data;
        }
        if(root.left==null && root.right==null){
            path.add(currpath);
            return;
        }

        solve(root.left, currpath, path);
        solve(root.right, currpath, path);

    }

}
