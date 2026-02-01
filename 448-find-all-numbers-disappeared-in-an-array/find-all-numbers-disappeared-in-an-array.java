class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        Set<Integer> se = new HashSet<>();
        for(int i : nums) se.add(i);
        for(int i =1;i<=n;i++){
            if(!se.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}