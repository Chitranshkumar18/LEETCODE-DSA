class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int maxarea = 0;
        while(i<j){
          int h = Math.min(arr[i], arr[j]);
          int w = j-i;
          int area = h * w;
          maxarea = Math.max(maxarea, area);
          if(arr[i]<arr[j]) i++;
          else j--;
        }

        return maxarea;
    }
}