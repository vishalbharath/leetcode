import java.util.*;
class Solution {
    public int numWays(String[] words, String target) {
        final int MOD = 1_000_000_007;
        int n = words[0].length(); 
        int m = target.length();
        int[][] charFrequency = new int[n][26];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }
        int[] dp = new int[m + 1];
        dp[0] = 1; 
        for (int col = 0; col < n; col++) {
            for (int targetIndex = m - 1; targetIndex >= 0; targetIndex--) {
                char targetChar = target.charAt(targetIndex);
                int count = charFrequency[col][targetChar - 'a'];

                if (count > 0) {
                    dp[targetIndex + 1] = (int) ((dp[targetIndex + 1] + (long) dp[targetIndex] * count % MOD) % MOD);
                }
            }
        }
        return dp[m];
    }
}
