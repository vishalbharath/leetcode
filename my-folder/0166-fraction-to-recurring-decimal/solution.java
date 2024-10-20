class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long lnum = numerator, lden = denominator;
        if (lnum == 0) {
            return "0";
        }
        if (lnum % lden == 0) {
            return Long.toString(lnum / lden);
        }
        StringBuilder number = new StringBuilder();
        if ((lden < 0) ^ (lnum < 0)) {
            number.append('-');
        }
        lnum = Math.abs(lnum);
        lden = Math.abs(lden);
        number.append(Long.toString(lnum / lden)).append('.');
        long GCD = gcd(lnum, lden);
        lnum /= GCD;
        lden /= GCD;
        lnum %= lden;
        lnum *= 10;
        int twos = 0, fives = 0;
        long temp = lden;
        for (; temp % 2 == 0; twos++) {
            temp /= 2;
        }
        for (; temp % 5 == 0; fives++) {
            temp /= 5;
        }
        if (temp == 1) {
            while (lnum != 0) {
                number.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            }
        } else {
            int nonRepLen = Math.max(twos, fives);
            for (int i = 0; i < nonRepLen; i++) {
                number.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            }
            long initRem = lnum;
            StringBuilder nonRep = new StringBuilder();
            do {
                nonRep.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            } while (lnum != initRem);
            number.append('(').append(nonRep.toString()).append(')');
        }
        return number.toString();
    }
    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
