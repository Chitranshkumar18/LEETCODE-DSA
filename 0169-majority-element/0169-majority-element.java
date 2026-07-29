class Solution {
    public int majorityElement(int[] arr) {
        int n= arr.length;
       int freq =0;
       int  ans = 0;
       for(int i=0;i<n;i++){
        if(freq==0){
            ans = arr[i];
        }
        if(ans==arr[i]){
            freq++;
        }
        else freq--;
       }
        return ans;
    }
}