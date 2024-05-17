class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backTrack(int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == nums.length) ans.add(new ArrayList(list));
        for(int i=0; i < nums.length; i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backTrack(nums, list, ans);
            list.remove(list.size() - 1);
        }
    }
}