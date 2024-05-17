class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;        
        LinkedList<int[]> ans = new LinkedList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        int currMin = intervals[0][0], currMax= intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][1] < currMin) {
                ans.add(intervals[i]);
            }
            else if(currMax >= intervals[i][0]) {
                currMin = Math.min(currMin, intervals[i][0]);
                currMax = Math.max(currMax, intervals[i][1]);
            } else {
                int[] temp = new int[2];
                temp[0] = currMin; 
                temp[1] = currMax;
                ans.add(temp);
                
                currMin = intervals[i][0];
                currMax = intervals[i][1];
            }            
        }

        int[] temp = new int[2];
        temp[0] = currMin; 
        temp[1] = currMax;
        ans.add(temp);

        return ans.toArray(new int[ans.size()][]);
    }
}