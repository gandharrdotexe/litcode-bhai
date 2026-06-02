class Solution {
    
    private int countFinTime(int[] ls, int[] ld, int[] ws, int[] wd){
        int mini = Integer.MAX_VALUE;

        for(int i=0; i< ls.length; i++){
            mini = Math.min(mini, ls[i]+ld[i]);
        }

        int value = Integer.MAX_VALUE;

        for(int j=0; j< ws.length; j++){
            value = Math.min(value, Math.max(mini, ws[j])+wd[j]);
        }

        return value;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        return Math.min(
            countFinTime(landStartTime, landDuration, waterStartTime, waterDuration),
            countFinTime(waterStartTime, waterDuration, landStartTime, landDuration)
        );

        
        
    }
}