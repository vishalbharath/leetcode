class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = 0; j < n; j++) {
                if (nums[(i + j) % n] > nums[i]) {
                    ans[i] = nums[(i + j) % n];
                    break;
                }
            }
        }
        return ans;
    }
}
