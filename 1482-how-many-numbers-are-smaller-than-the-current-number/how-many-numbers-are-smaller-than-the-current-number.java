class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            if (!d.containsKey(temp[i])) {
                d.put(temp[i], i);
            }
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = d.get(nums[i]);
        }
        
        return ret;
    }
}