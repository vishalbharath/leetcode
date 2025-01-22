class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int R = isWater.length;
        int C = isWater[0].length;
        int[][] height = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                height[i][j] = R + C;
            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                } else {
                    if (i > 0) 
                        height[i][j] = Math.min(height[i][j], height[i - 1][j] + 1);
                    if (j > 0) 
                        height[i][j] = Math.min(height[i][j], height[i][j - 1] + 1);
                }
            }
        }
        
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (i < R - 1) 
                    height[i][j] = Math.min(height[i][j], height[i + 1][j] + 1);
                if (j < C - 1) 
                    height[i][j] = Math.min(height[i][j], height[i][j + 1] + 1);
            }
        }
        
        return height;
    }
}
