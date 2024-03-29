/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {
    public static boolean isParentSum(Node root) {
        // Write your code here.
        if(root==null || (root.left==null  && root.right==null))return true;
        int sum=0;
        
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null)sum+=root.right.data;
        // if(root.left==null  && root.right==null)return true;

        // if(sum!=root.data)return false;
        return root.data==sum && isParentSum(root.left)&& isParentSum(root.right);
    }
}
