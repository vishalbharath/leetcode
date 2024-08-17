import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        
        if (n == s.size()) {
            return false; 
        } else {
            return true; 
        }
    }
}

