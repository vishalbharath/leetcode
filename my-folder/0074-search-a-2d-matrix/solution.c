bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target) {
    int m = matrixSize, n = (*matrixColSize);
    int r = 0, c = n - 1;
    while (r < m && c > -1) {
        if (matrix[r][c] < target)
            r++;
        else if (matrix[r][c] > target)
            c--;
        else
            return true;
    }

    return false;
}
