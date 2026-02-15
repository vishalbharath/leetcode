class Solution {
    public int maxSubArray(int[] nums) {
        int maxx = Integer.MIN_VALUE;
        int n = nums.length;
        int curr = 0 ;

        for(int i = 0;i<n;i++){
            curr+=nums[i];
            if(curr>maxx)maxx=curr;
            if(curr<0)curr=0;
        }
        return maxx;
    }
}