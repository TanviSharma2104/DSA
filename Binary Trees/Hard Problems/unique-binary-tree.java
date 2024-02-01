// Problem statement
// Given a pair of tree traversal, return 'true' if a unique binary tree can be constructed otherwise 'false'.



// Note:
// Each traversal is represented with an integer: preorder - 1, inorder - 2, postorder - 3.   


// Example:
// For 'a' = 2, ‘b’ = 3.

// Answer is True.

public class Solution {
    public static boolean uniqueBinaryTree(int a, int b){
        // Write your code here.
        if(a==b)return false;
        if(a*b==3)return false;
        return true;
    }
}
