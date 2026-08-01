class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int sum = 0;
        int j = 0;
        int maxlen = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            while(sum>=target){
                maxlen=Math.min(maxlen, i-j+1);
                sum -= arr[j];
                j++;
            }
        }
        if(maxlen==Integer.MAX_VALUE) return 0;
        return maxlen;
    }
}