class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int key : mp.keySet()){
            if(mp.get(key) > 1){
                ans.add(key);
            }
        }
        return new int[]{ans.get(0),ans.get(1)};
    }
}