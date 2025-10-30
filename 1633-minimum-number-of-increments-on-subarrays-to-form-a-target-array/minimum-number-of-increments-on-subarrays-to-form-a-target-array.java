class Solution {
    public int minNumberOperations(int[] target) {
    int ans = 0;
    int last = 0;
    for (int val : target) {
        if (last >= val) {
            last = val;
            continue;
        }
        ans += (val - last);
        last = val;
    }
    return ans;
}
}