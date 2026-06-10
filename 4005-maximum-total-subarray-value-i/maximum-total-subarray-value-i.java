class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mn= nums[0];
        long mx = nums[0];
        long ans = 0;

        for(int i=0; i< nums.length; i++){
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);

            ans = Math.max(ans, mx-mn);
        }

        return ans*k;
    }
}