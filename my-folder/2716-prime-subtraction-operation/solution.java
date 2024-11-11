class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length; 
        if(n == 1) return true;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]) continue;
            else{
                int diff = nums[i] - nums[i+1];
                if(diff + 1 > nums[i] - 1) return false;
                int j = diff + 1, end = nums[i] - 1;
                for(; j <= end; j++){
                    if(isPrime(j)){
                        nums[i] = nums[i] - j;
                        break;
                    }
                }
                if(j > end) return false;
            }
        }
        return true;
    }
    private boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2) return true;
        int sqrt = (int)Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++){
            if(num % i == 0) return false; 
        }
        return true;
    }
}
