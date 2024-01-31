/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
class Nodevalue{

    int size, max,min;

    Nodevalue(int size,int min,int max){
        this.size=size;
        this.min=min;
        this.max=max;
    }
}


public class Solution {

    public static int largestBST(TreeNode root) {
        // Write your code here.
        return largest(root).size;
    }

    private static  Nodevalue largest(TreeNode root){
        if(root==null){
            return new Nodevalue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Nodevalue left=largest(root.left);
        Nodevalue right=largest(root.right);

        if(left.max< root.data && right.min> root.data){
            //it is a bst
            return new Nodevalue((left.size +right.size +1), Math.min(root.data, left.min), Math.max(root.data, right.max));
        }

        //otherwise

        return new Nodevalue(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
