class Solution {
    public int[][] merge(int[][] intervals) {


        if (intervals.length == 1) {
            return intervals;
        }
        int max = -1;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        if (max == -1) {
            return new int[][] { intervals[0] };
        }
        int[] timeTable = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
        }
        int resultSize = 0, currEnd = -1, currStart = -1;
        for (int i = 0; i < timeTable.length; i++) {
            if (timeTable[i] != 0) {
                if (currStart == -1) {
                    currStart = i;
                }
                currEnd = Math.max(timeTable[i] - 1, currEnd);
            }
            if (currEnd == i) {
                intervals[resultSize++] = new int[] { currStart, currEnd };
                currEnd = -1;
                currStart = -1;
            }
        }
        if (currStart != -1) {
            intervals[resultSize++] = new int[] { currStart, currEnd };
        }
        if (intervals.length == resultSize) {
            return intervals;
        }
        int[][] res = new int[resultSize][];
        for (int i = 0; i < resultSize; i++) {
            res[i] = intervals[i];
        }
        return res;
        
    }
}
