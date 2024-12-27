class Solution {
public:
    int maxArea(vector<int>& height) {
        int left=0;
        int right=height.size()-1;
        int maxx=0;
        while(left<right){
            int x=min(height[left],height[right])*(right-left);
            maxx=max(maxx,x);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxx;
        
    }
};
