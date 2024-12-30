class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        int i=0;
        int j=0;
        int x=0;
        int y=0;
        for(int count=0;count<=(n+m)/2;count++){
            y=x;
            if(i != n && j != m){
                if(nums1[i] > nums2[j]){
                    x=nums2[j++];
                }
                else{
                    x=nums1[i++];
                }
            }
            else if(i<n){
                x=nums1[i++];
            }
            else{
                x=nums2[j++];
            }
        }
        if((n+m) % 2 == 1){
            return static_cast<double>(x);
        }
        else{
            double ans = static_cast<double>(x) + static_cast<double>(y);
            return ans/2.0;
        }
    }
};
