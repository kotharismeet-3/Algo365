class Solution {

    private Integer computeScore(String str) {
        Integer score = 0;
        for(int i=0; i<str.length(); i++) {
            // if it's - 'a' and not 96 it will fail in "ac" and "c"
            //
            score += ((str.charAt(i) - 96) * (str.charAt(i) - 96));
        }
        return score;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // nat tan. 14*14 + 1*1 + 20*20 = 596(sum without square will fail for bb, ac both will be 4)
        // logic fails for bd 4+16 and aacc = 1+1+9+9
        Map<Integer, List<Integer>> sum = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            Integer magicScore = computeScore(strs[i]);
            // sum.put(magicScore, sum.getOrDefault(magicScore, new ArrayList<Integer>()).add((Integer) i));
            // dosen't works becuase add returns boolean which gives error on put
            List<Integer> valueList = sum.getOrDefault(magicScore, new ArrayList<Integer>());
            valueList.add((Integer) i);
            sum.put(magicScore, valueList);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: sum.entrySet()) {
            List<String> temp = new ArrayList<>();
            for(Integer index: entry.getValue()) {
                temp.add(strs[index]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
