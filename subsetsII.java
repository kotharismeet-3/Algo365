class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backTrack(int startIndex, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList(list));
        for(int i = startIndex; i < nums.length ; i++) {
            if(i > startIndex && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backTrack(i+1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }
}