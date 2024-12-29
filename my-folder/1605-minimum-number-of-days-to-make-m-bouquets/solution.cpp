class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int n=bloomDay.size();
        if(k==0 || m>n/k) return -1;
        int maxi=bloomDay[0];
        int mini=bloomDay[0];
        for(int i=0;i<n;i++){
            maxi=max(maxi,bloomDay[i]);
            mini=min(mini,bloomDay[i]); 
        }
        int l=mini,r=maxi;
        while(l<=r){
            int i=(l+r)/2;
            int cnt=0;
            int bouq=0;
            for(int j=0;j<n;j++){
                if(bloomDay[j]<=i) cnt++;
                else{
                    bouq+=cnt/k;
                    cnt=0;
                }
            }
            bouq+=cnt/k;
            if(l==r) return i;
            else if(bouq>=m) r=i;
            else{
                l=i+1;
            }
        }
        return -1;
    }
};
