class Solution {
    public int findMin(int[] arr) {
        int l =0, h =arr.length-1;
        while(l<h){
            int mid =l+(h-l)/2;
 
            if(arr[mid]>arr[h]){
                l = mid+1;
            }
            else{
                h=mid;
            }
        }
        return arr[l];
    }
   
}