class Solution {
    public int majorityElement(int[] arr) {
        int n= arr.length;
        Arrays.sort(arr);
        return arr[n/2];
        
    }
}