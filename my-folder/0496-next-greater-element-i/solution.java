class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    while(j<nums2.length){
                        if(j==nums2.length-1)
                            arr[i]=-1;
                        if(nums1[i]<nums2[j])
                        {
                            arr[i]=nums2[j];
                            break;
                        } 
                        else
                            j++;
                    }
                }
            }
        }
        return arr;
    }
}
