class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        int mid = (n + 1) / 2;
        int smallIdx = mid - 1;   // pointer into smaller half, from the back
        int largeIdx = n - 1;     // pointer into larger half, from the back
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[smallIdx--];
            } else {
                nums[i] = sorted[largeIdx--];
            }
        }
    }
}
