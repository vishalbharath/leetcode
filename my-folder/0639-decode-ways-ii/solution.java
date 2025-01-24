class Solution {
    private static final int MOD = 1000000007;

    public int numDecodings(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string is null");
        }
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char preChar = s.charAt(0);
        long pre = 1;
        long cur = preChar == '*' ? 9 : 1;

        for (int i = 1; i < len; i++) {
            char curChar = s.charAt(i);
            if (preChar == '0' && curChar == '0') {
                return 0;
            }
            long ways = 0;
            if (curChar != '0') {
                ways += cur * (curChar == '*' ? 9 : 1);
            }
            if (preChar == '*') {
                if (curChar == '*') {
                    ways += 15 * pre;
                } else if (curChar <= '6') {
                    ways += 2 * pre;
                } else {
                    ways += pre;
                }
            } else if (preChar == '2') {
                if (curChar == '*') {
                    ways += 6 * pre;
                } else if (curChar <= '6') {
                    ways += pre;
                }
            } else if (preChar == '1') {
                ways += pre * (curChar == '*' ? 9 : 1);
            }
            pre = cur;
            cur = ways % MOD;
            preChar = curChar;
        }
        return (int) cur;
    }
}

