int findPeakElement(int* nums, int numsSize) {
    int i;
    if(numsSize==1){
        return 0;
    }
    for(int i=0;i<numsSize-1;i++){
        if(nums[i]>nums[i+1]){
            return i;
        }
    }
    return i;
    
}
