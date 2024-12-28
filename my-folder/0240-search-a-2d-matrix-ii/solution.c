bool searchMatrix(int** matrix, int rows, int* cols, int target) {
    int r = 0, c = *cols - 1;
    while (r < rows && c >= 0) {
        int val = matrix[r][c];
        if (val == target) return true;
        else if (val < target) r++;
        else c--;
    }
    return false;
}
