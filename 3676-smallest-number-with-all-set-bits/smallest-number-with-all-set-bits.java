class Solution {
    public int smallestNumber(int n) {
        int result = 0;
        int i = 0;
        while (result < n) {
            result += Math.pow(2, i);
            i++;
        }
        return result;
    }
}