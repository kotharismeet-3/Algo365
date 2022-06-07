int rob(vector<int>& nums) {
        if(!nums.size()) return 0;
        else if(nums.size() == 1) return nums[0];
        else if (nums.size() == 2) return max(nums[0],nums[1]);
        else if(nums.size() == 3) return max(nums[0],max(nums[1],nums[2]));
        // ans1 right side
        int curr=0,prev=max(nums[1],nums[2]),prev2=nums[1],ans1=0,ans2=0;
        for (int i=3;i<nums.size();i++) {
            curr = max(prev2+nums[i],prev);
            prev2 = prev;
            prev = curr;
        }
        ans1 = prev;
        // ans2 left side
        prev=max(nums[0],nums[1]),prev2=nums[0];
        for (int i=2;i<nums.size()-1;i++) {
            curr = max(prev2+nums[i],prev);
            prev2 = prev;
            prev = curr;
        }
        ans2 = prev;
        // cout<<ans1<<" "<<ans2<<endl;
        return max(ans1,ans2);
    }
