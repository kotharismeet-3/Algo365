class Solution {
    public int[] productExceptSelf(int[] nums) {
        int finalMultiplied = 1, finalMultipliedWithoutZero = 1, countZero = 0;
        // finalMultipliedWithoutZero edge case [0, 0], [0, 4, 0]
        for(int num: nums) {
            if(num != 0) finalMultipliedWithoutZero *= num;
            else countZero++;
            finalMultiplied *= num;
        }
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i < n; i++) {
            if(nums[i] == 0) {
                if(countZero > 1) ans[i] = 0;
                else ans[i] = finalMultipliedWithoutZero;
            }
            else ans[i] = finalMultiplied / nums[i];
        }
        return ans;
    }
}