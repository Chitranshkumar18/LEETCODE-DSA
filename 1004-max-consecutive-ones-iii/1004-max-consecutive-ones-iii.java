class Solution {
    public int longestOnes(int[] arr, int k) {

        int left =0;
        int zerocount =0;
        int maxlen =0;
        for(int right =0;right<arr.length;right++){
            if(arr[right]==0){
                zerocount++;
            }
            while(zerocount>k){
                if(arr[left]==0){
                    zerocount--;
                }
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
        }
        return maxlen;
    }
}