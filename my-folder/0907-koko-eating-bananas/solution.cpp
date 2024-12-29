class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int left=1;
        //int right=*max_element(piles.begin(),piles.end());
        int right=1e9;
        while(left<right){
            int mid=(left+right)/2;
            int totalhrs=0;
            for(auto pile:piles){
                totalhrs += (pile/mid)+(pile % mid != 0);
                if(totalhrs>h){
                    break;
                }
            }
            if(totalhrs<=h){
                right = mid;
            }
            else{
                left=mid+1;
            }

        }
        return left;
        
    }
};
