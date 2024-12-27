class Solution {
public:
    int trap(vector<int>& height) {
        int a=height.size();
        if(a<2){
            return 0;
        }
        vector<int> lmax(a), rmax(a);
        lmax[0]=height[0];
        rmax[a-1]=height[a-1];
        for(int i=1;i<a;++i){
            lmax[i]=max(lmax[i-1],height[i]);
        }
        for(int i=a-2;i>=0;--i){
            rmax[i]=max(rmax[i+1],height[i]);
        }
        int sum=0;
        for(int i=0;i<a;++i){
            sum+=min(lmax[i],rmax[i])-height[i];
        }
        return sum;
    }
};
