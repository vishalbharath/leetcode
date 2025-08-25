class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, k = 0;
        boolean up = true;

        while (k < m * n) {
            result[k++] = mat[row][col];

            if (up) {
                if (row == 0 && col < n - 1) {
                    col++;
                    up = false;
                } else if (col == n - 1) {
                    row++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (col == 0 && row < m - 1) {
                    row++;
                    up = true;
                } else if (row == m - 1) {
                    col++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}