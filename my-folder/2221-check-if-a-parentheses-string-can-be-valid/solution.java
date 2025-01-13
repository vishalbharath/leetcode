class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2==1){
            return false;
        }
        int open=0,close=0;
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0'||s.charAt(i)=='('){
                open++;
            }
            else{
                close++;
            }
            if(open<close){
                return false;
            }
        }
        open=close=0;
        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i)=='0'||s.charAt(i)==')'){
                close++;
            }
            else{
                open++;
            }
            if(close<open){
                return false;
            }
        }
        return true;
    }
}
