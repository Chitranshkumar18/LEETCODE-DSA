class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            if (num == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}




    public int majorityElement(int[] arr) {
        int n= arr.length;
        Arrays.sort(arr);
        return arr[n/2];
        
    }
