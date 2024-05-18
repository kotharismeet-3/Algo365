class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        int low = 0, high = height.length - 1, ans  = 0;

        while(low < high) {
            ans = Math.max(ans, (high - low) * Math.min(height[low], height[high]));
            if(height[low] <= height[high]) low++;
            else high--;
        }

        return ans;
    }
}