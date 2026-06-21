class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int arr[]= new int[100001];
        int n=costs.length;
        for(int i=0;i<n;i++)
        {
            arr[costs[i]]++;
        }
        int count=0;
        
        for(int i=0;i<100001;i++)
        {
            if(arr[i]>0)
            {
                int x=coins/i;
                if(x<=arr[i])
                {
                    count+=x;
                    return count;
                }
                else
                {
                    count+=arr[i];
                    coins-=(arr[i]*i);
                }

            }
        }
        return count;
    }
}