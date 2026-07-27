class Solution {
    public int lengthOfLIS(int[] arr) {
        int n =arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxlen = 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] += max;
            maxlen = Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
}