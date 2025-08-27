class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxLength = 0;

        if (n == 0 || m == 0) {
            return 0;
        }

        // Possible diagonal directions: down-right, down-left, up-left, up-right
        int[][] directions = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    maxLength = Math.max(maxLength, 1);
                    for (int i = 0; i < 4; i++) {
                        int dr1 = directions[i][0];
                        int dc1 = directions[i][1];
                        
                        int currentR = r;
                        int currentC = c;
                        int currentLength = 1;
                        int step = 0;

                        while (true) {
                            int nextR = currentR + dr1;
                            int nextC = currentC + dc1;
                            int expectedValue = (step % 2 == 0) ? 2 : 0;
                            
                            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && grid[nextR][nextC] == expectedValue) {
                                currentR = nextR;
                                currentC = nextC;
                                currentLength++;
                                step++;
                                maxLength = Math.max(maxLength, currentLength);
                                
                                // Check for a turn at this point
                                int dr2, dc2;
                                if (dr1 == 1 && dc1 == 1) {
                                    dr2 = 1; dc2 = -1; 
                                } else if (dr1 == 1 && dc1 == -1) {
                                    dr2 = -1; dc2 = -1; 
                                } else if (dr1 == -1 && dc1 == -1) {
                                    dr2 = -1; dc2 = 1; 
                                } else { // (dr1 == -1 && dc1 == 1)
                                    dr2 = 1; dc2 = 1; 
                                }

                                int turnR = currentR;
                                int turnC = currentC;
                                int turnLength = currentLength;
                                int turnStep = step;

                                while (true) {
                                    int nextTurnR = turnR + dr2;
                                    int nextTurnC = turnC + dc2;
                                    int expectedValueTurn = (turnStep % 2 == 0) ? 2 : 0;

                                    if (nextTurnR >= 0 && nextTurnR < n && nextTurnC >= 0 && nextTurnC < m && grid[nextTurnR][nextTurnC] == expectedValueTurn) {
                                        turnR = nextTurnR;
                                        turnC = nextTurnC;
                                        turnLength++;
                                        turnStep++;
                                        maxLength = Math.max(maxLength, turnLength);
                                    } else {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return maxLength;
    }
}