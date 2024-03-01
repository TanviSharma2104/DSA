class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();

        helper(ans, 0, nums, list);
        return ans;
    }

    public void helper( List<List<Integer>> ans, int i, int[] nums, List<Integer> list){
        if(i>=nums.length){
            ans.add(new ArrayList<>(list));
        }
        else{
            list.add(nums[i]);
            helper(ans, i+1, nums, list);

            list.remove(list.size()-1);
            helper(ans, i+1, nums, list);
        }
    }
}
