class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    private void backTrack(int startIndex, int target, int[] candidates, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = startIndex; i < candidates.length ; i++)  {
            if(target - candidates[i] < 0) return;
            list.add(candidates[i]);
            backTrack(i, target - candidates[i], candidates, list, ans);
            list.remove(list.size() - 1);
        }
    }
}