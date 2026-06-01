class Solution {
    public int minimumCost(int[] cost) {
        int n= cost.length;
        int total = 0;
        int itemCount = 0;
        Arrays.sort(cost);
        //for every third number in the desecending order array
        for(int i = n-1; i >= 0; i--){
            if(itemCount % 3 != 2){
                total += cost[i];
            }

            itemCount++;
        }

        return total;
    }
}