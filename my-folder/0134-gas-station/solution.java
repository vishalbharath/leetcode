class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            a+=gas[i];
            b+=cost[i];
        }
        if(a<b){
            return -1;
        }
        int x=0;
        int y=0;
        for(int i=0;i<n;i++){
            x+=gas[i]-cost[i];
            if(x<0){
                y=i+1;
                x=0;
            }
        }
        return y;
    }
}
