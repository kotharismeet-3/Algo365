class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(target, 0, candidates, new ArrayList<>(), ans);
        return ans;
    }

    private void backTrack(int target, int startIndex, int[] candidates, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) ans.add(new ArrayList(list));
        for(int i = startIndex; i < candidates.length ; i++) {
            if(target - candidates[i] < 0) return;
            if(i > startIndex && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            backTrack(target - candidates[i], i+1, candidates, list, ans);
            list.remove(list.size() - 1);
        }
    }
}