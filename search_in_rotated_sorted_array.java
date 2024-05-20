class Solution {
    public int search(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (high+low) / 2;
            if(nums[mid] == k) return mid;

            if(nums[low] <= nums[mid]) {
                if(nums[low] <= k && k <= nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if(k >= nums[mid] && k <= nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}