class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int no_of_elements = nums.length;
        Set<List<Integer>> unique = new HashSet<>();
        for(int i=0; i < (1 << no_of_elements) ; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums.length ; j++) {
                // 1 << j checks if ith bit is set or not
                // i && 1 << j push all digits which bits are set with binary representation of ith number
                if((i & (1 << j)) > 0) list.add(nums[j]);
            }
            unique.add(list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(unique);
        return ans;
    }
}