class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        int maxKept = 0;
        
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (canAppend(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxKept = Math.max(maxKept, dp[i]);
        }
        
        return m - maxKept;
    }
    
    private boolean canAppend(String[] strs, int prev, int curr) {
        for (String s : strs) {
            if (s.charAt(prev) > s.charAt(curr)) {
                return false;
            }
        }
        return true;
    }
}