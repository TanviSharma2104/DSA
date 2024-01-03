import java.util.List;
import java.util.ArrayList;

/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        List<Integer> ans=new ArrayList<>();
        leftView(root, ans,0);
        // for(int i=0;i<ans.size();i++){
        //     System.out.print(ans.get(i)+" ");
        // }
        
    }
    private static void leftView(TreeNode<Integer> node, List<Integer> ans,int dept){
        if(node==null)return ;
        if(dept==ans.size()){
            ans.add(node.data);
            System.out.print(ans.get(ans.size()-1)+" ");
        }
        
        leftView(node.left, ans, dept+1);
        leftView(node.right, ans, dept+1);

    }
    
}
