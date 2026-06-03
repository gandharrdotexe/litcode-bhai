class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int MAX = Integer.MAX_VALUE;

        int l = MAX, w = MAX, minL = MAX, minW = MAX;
        int n = landStartTime.length, m = waterStartTime.length;

        for (int i = 0; i < n; ++i)
            l = Math.min(l, landStartTime[i] + landDuration[i]);

        for (int i = 0; i < m; ++i) {
            w = Math.min(w, waterStartTime[i] + waterDuration[i]);
            minL = Math.min(minL, Math.max(waterStartTime[i], l) + waterDuration[i]);
        }

        for (int i = 0; i < n; ++i)
            minW = Math.min(minW, Math.max(landStartTime[i], w) + landDuration[i]);

        return Math.min(minW, minL);
        
    }
}
