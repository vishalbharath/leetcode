class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String operation: operations){
            if(operation.charAt(1)=='+'){
                x+=1;
            }else{
                x-=1;
            }
        }
        return x;
    }
}