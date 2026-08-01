class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k<=1) return 0;
        int count =0;
        int left =0;
        int prod =1;
        for(int i=0;i<arr.length;i++){
             prod *=arr[i];
             while(prod>=k){
                prod /=arr[left];
                left++;
             }
             count += i-left+1;
        }
        return count;
    }
}