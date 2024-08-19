
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] dp=new Integer[n][n];
        return findMin(triangle,0,0,n,dp);
    }
    public static int findMin(List<List<Integer>> tri,int i,int j,int n,Integer[][] dp){
        if(i==n-1) return tri.get(i).get(j);
        if(dp[i][j]!=null) return dp[i][j];
        return dp[i][j]=tri.get(i).get(j)+Math.min(findMin(tri,i+1,j,n,dp),findMin(tri,i+1,j+1,n,dp));
    }
}
