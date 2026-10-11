class Solution {
    public boolean canJump(int[] arr) {
        int max = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(i > max){
                return false;
            }
            max = Math.max(max, i + arr[i]); //0
        }
        return true;  
    }
}