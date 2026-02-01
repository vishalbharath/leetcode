class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        int as = n *(n+1)/2 ; 
        for(int i : nums){
            res += i;
        }
        return as-res;
    }
}