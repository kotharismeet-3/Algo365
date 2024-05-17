class Solution {
    public int maxProduct(int[] nums) {
       int prefix = 1, suffix = 1, ans = Integer.MIN_VALUE;
        for(int num: nums) {
            if(num < 0) neg++;
            prefix *= num;
            ans = Math.max(ans, prefix);
            // dont do it before ans becuase it will fail in [0,0]
            if(prefix == 0) prefix = 1;
        }
        // if(neg % 2 == 0) return prefix[nums.length - 1] 
        // it is wrong becuase 0 can come in between amy two negative numbers
        // if(neg % 2 == 0) return ans;
        // this also failed for test case like [-1, 0, -2, 2]
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < 0) neg++;
            suffix *= nums[i];
            ans = Math.max(ans, suffix);
            // dont do it before ans becuase it will fail in [0,0]
            if(suffix == 0) suffix = 1;
        }
        return ans;
    }
}