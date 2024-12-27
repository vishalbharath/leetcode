class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int x=nums.size();
        vector<int> ans(x,1);
        int left=1;
        for(int i=0;i<x;++i){
            ans[i]*=left;
            left*=nums[i];
        }
        int right=1;
        for(int i=x-1;i>=0;--i){
            ans[i]*=right;
            right*=nums[i];
        }
        return ans;
    }
};
