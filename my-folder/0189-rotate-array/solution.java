class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            int a=i+k;
            while(a>=n){
                a=a-n;
            }
            arr[a]= nums[i];
        }
for (int i=0;i<n;i++) {
    nums[i]=arr[i];
}
        
    }
}
