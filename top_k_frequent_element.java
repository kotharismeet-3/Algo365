class Solution {

    private List<Integer> topKFrequentUsingPQ(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
           
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> listAns = topKFrequentUsingPQ(nums, k);
        int[] ans = new int[k];
        for(int i=0;i<k; i++) {
            ans[i] = listAns.get(i);
        }
        return ans;
    }
}