import java.util.Arrays;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int xA = points[i][0];
                int yA = points[i][1];
                int xB = points[j][0];
                int yB = points[j][1];

                if (xA <= xB && yA >= yB) {
                    boolean isSad = false;
                    
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) {
                            continue;
                        }

                        int xK = points[k][0];
                        int yK = points[k][1];

                        if (xK >= xA && xK <= xB && yK >= yB && yK <= yA) {
                            isSad = true;
                            break;
                        }
                    }

                    if (!isSad) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
