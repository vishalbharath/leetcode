class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        int low=1;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        while(low<max){
            int m=(low+max)/2;
            int k=0;
            for(int val:piles){
                k+=Math.ceil((double)val/m);
            }
            if(k<=h){
                max=m;
            }
            else{
                low=m+1;
            }
        }
        return max;
    }   
}
