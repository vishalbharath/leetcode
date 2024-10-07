class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> ans = new LinkedList<>();
        // Sort by height in descending order, if same height then by the number of people in ascending order
        Arrays.sort(people, (a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);
        // Insert people in the result list at the correct position
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
