class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        boolean flag = false;
        List<TreeNode> li = new ArrayList<>();
        li.add(root);

        while (!li.isEmpty()) {
            int levelSize = li.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = li.get(i);

                if (flag) {
                    list.add(0, curr.val); // Add at the beginning for reverse order
                } else {
                    list.add(curr.val);
                }

                if (curr.left != null) {
                    li.add(curr.left);
                }

                if (curr.right != null) {
                    li.add(curr.right);
                }
            }

            ans.add(list);
            li.subList(0, levelSize).clear(); // Remove processed nodes
            flag = !flag;
        }

        return ans;
    }
}
