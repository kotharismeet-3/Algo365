class Solution {
    public int findMin(int[] nums) {
        // search in roated sorted array
        int low = 0, high = nums.length - 1, ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (high+low) / 2;
            // if(nums[mid] == k) return mid;

            if(nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid +1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}