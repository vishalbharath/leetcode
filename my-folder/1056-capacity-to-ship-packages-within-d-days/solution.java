class Solution {
    public int shipWithinDays(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            start = Math.max(start,nums[i]);
            end += nums[i];
        }
        while(start < end){
            int mid = start + (end-start)/2;
            int x = 1;
            int sum = 0;
            for(int i=0;i<n;i++){
                if(sum + nums[i] <= mid){
                    sum += nums[i];
                }
                else{
                    sum = nums[i];
                    x++;
                }
            }
            if(x>k){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return end;
        
    }
}
