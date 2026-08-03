class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int leftsum =0;
        int totalsum =0;
        for(int i=0;i<n;i++){
             totalsum +=arr[i];
        }
        for(int i=0;i<n;i++){
          int rightsum = totalsum - leftsum -arr[i];
           if(leftsum==rightsum){
            return i;
           } 
           leftsum +=arr[i];
        }
        return -1;
    }
}