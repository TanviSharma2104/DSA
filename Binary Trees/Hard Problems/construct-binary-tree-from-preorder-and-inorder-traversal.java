/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=build(preorder, 0, preorder.length-1, inorder,0, inorder.length-1, map);
        return root;
    }

    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder,int iStart,int iEnd,Map<Integer, Integer>map){
        if(pStart> pEnd || iStart> iEnd)return null;

        TreeNode root=new TreeNode(preorder[pStart]);
        int inRoot=map.get(root.val);//curr root position
        int numsLeft=inRoot-iStart;
        root.left=build(preorder, pStart+1, pStart+numsLeft, inorder, iStart, inRoot-1, map);
        root.right=build(preorder, pStart+numsLeft+1, pEnd, inorder, inRoot+1, iEnd, map);
        return root;

    }
}
