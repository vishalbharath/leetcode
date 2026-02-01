class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> se = new HashSet<>();
        for(int i : nums){
            se.add(i);
        }
        if(n == se.size()) return false;
        return true;
        
    }
}