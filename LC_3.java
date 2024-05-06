class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashmap = new HashMap<>();
        int ans = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (hashmap.containsKey(currentChar)) {            
                start = Math.max(start, hashmap.get(currentChar) + 1);
            }
            ans = Math.max(ans, i - start + 1);            
            hashmap.put(currentChar, i);
        }
        return ans;
    }
}