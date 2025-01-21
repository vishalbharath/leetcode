class Solution {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int a=0,b=1,c=1,x=0;
        for(int i=3;i<=n;i++){
            x = (a+b+c);
            a = b;
            b = c;
            c = x;
        }
        return x;
    }
}
