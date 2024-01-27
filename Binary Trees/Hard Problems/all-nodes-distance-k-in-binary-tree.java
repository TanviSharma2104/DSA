/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        //map <child, parent> 
        HashMap<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParents(root, parentTrack);

        //visted hashmap <node, visted or not>
        // HashMap<TreeNode, Boolean> visited=new HashMap<>();
        HashSet<TreeNode> visited=new HashSet<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        // visited.put(target, true);
        visited.add(target);

        int level=0;

        while(!q.isEmpty()){
            int size=q.size();
            if(level==k){
                break;
            }
            level++;

            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();

                if(curr.left!=null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                    // visited.put(curr.left, true);
                }

                if(curr.right!=null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                    // visited.put(curr.right, true);
                }
                //add parent alse 
                if(parentTrack.containsKey(curr)  &&  !visited.contains(parentTrack.get(curr))){
                    q.add(parentTrack.get(curr));
                    visited.add(parentTrack.get(curr));
                    // visited.put(parentTrack.get(curr), true);
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        // q.poll();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            res.add(node.val);
        }
        return res;

    }


    public void markParents(TreeNode root, HashMap<TreeNode, TreeNode>parentTrack){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                parentTrack.put(curr.left, curr);
                q.add(curr.left);
            }

            if(curr.right!=null){
                parentTrack.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
}
