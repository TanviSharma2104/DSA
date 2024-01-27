//SOLUTION 1
public class Solution {
    
    public static int countNodes(BinaryTreeNode<Integer> root) {
        // Write your code here.\
    
        return countNode(root);
    }

    private static int countNode(BinaryTreeNode<Integer> node){
        if(node==null)return 0;
        int left=countNode(node.left);
        int right=countNode(node.right);
        return left+right+1;
    }
}

//SOLUTION 2

class Solution {
    int count=0;
    public int countNodes(TreeNode root) {
        countNode(root);
        return count;
    }

    private void countNode(TreeNode root){
        if(root==null)return;
        count++;
        countNode(root.left);
        countNode(root.right);
    }
}
