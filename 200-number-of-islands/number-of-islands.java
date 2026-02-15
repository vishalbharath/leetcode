class Solution {
    public int numIslands(char[][] grid) {
        int count = 0 ;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if( grid[i][j]=='1'){
                count++;
                func(grid,i,j,m,n);
            }}
        }
        return count;
    }
    public static void func(char[][] grid , int i , int j , int m , int n ){
        if(i < 0 || j < 0|| i>=m||j>=n||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';

    func(grid,i+1,j,m,n);
    func(grid,i-1,j,m,n);
    func(grid,i,j+1,m,n);
    func(grid,i,j-1,m,n);
    }
}