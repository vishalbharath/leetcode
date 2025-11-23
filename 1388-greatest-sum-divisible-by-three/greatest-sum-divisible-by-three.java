class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int min1 = Integer.MAX_VALUE, min1b = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE, min2b = Integer.MAX_VALUE;

        for (int x : nums) {
            sum += x;
            int r = x % 3;
            if (r == 1) {
                if (x < min1) {
                    min1b = min1;
                    min1 = x;
                } else if (x < min1b) {
                    min1b = x;
                }
            } else if (r == 2) {
                if (x < min2) {
                    min2b = min2;
                    min2 = x;
                } else if (x < min2b) {
                    min2b = x;
                }
            }
        }

        int rem = sum % 3;
        if (rem == 0) return sum;

        int option1 = Integer.MIN_VALUE;
        int option2 = Integer.MIN_VALUE;

        if (rem == 1) {
            if (min1 != Integer.MAX_VALUE) option1 = sum - min1;
            if (min2 != Integer.MAX_VALUE && min2b != Integer.MAX_VALUE) option2 = sum - (min2 + min2b);
        } else {
            if (min2 != Integer.MAX_VALUE) option1 = sum - min2;
            if (min1 != Integer.MAX_VALUE && min1b != Integer.MAX_VALUE) option2 = sum - (min1 + min1b);
        }

        int ans = Math.max(option1, option2);
        return Math.max(ans, 0);
    }
}
