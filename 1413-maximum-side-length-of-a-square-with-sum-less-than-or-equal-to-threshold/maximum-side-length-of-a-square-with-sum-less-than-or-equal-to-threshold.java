class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        // Build 2D prefix sum array (1-indexed for easier calculation)
        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] 
                                + prefixSum[i][j - 1] 
                                - prefixSum[i - 1][j - 1]
                                + mat[i - 1][j - 1];
            }
        }

        // Binary search on square size
        int left = 1;
        int right = Math.min(n, m);
        int maxSide = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (existsSquareWithSize(n, m, mid, prefixSum, threshold)) {
                maxSide = mid; // Found valid square, try larger
                left = mid + 1;
            } else {
                right = mid - 1; // Too large, try smaller
            }
        }

        return maxSide;
    }

    // Check if any square of given size has sum <= threshold
    private boolean existsSquareWithSize(int rows, int cols, int size, 
                                         int[][] prefixSum, int threshold) {
        // Try all possible top-left positions
        for (int i = 1; i <= rows - size + 1; i++) {
            for (int j = 1; j <= cols - size + 1; j++) {
                // Calculate sum of square from (i,j) to (i+size-1, j+size-1)
                int sum = getSquareSum(prefixSum, i, j, i + size - 1, j + size - 1);
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    // Get sum of rectangle from (x1,y1) to (x2,y2) using prefix sum
    private int getSquareSum(int[][] prefixSum, int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] 
             - prefixSum[x1 - 1][y2] 
             - prefixSum[x2][y1 - 1] 
             + prefixSum[x1 - 1][y1 - 1];
    }
}