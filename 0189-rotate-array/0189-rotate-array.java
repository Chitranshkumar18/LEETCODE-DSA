class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        // 7,6,5,4,3,2,1
        // 5,6,7,4,3,2,1
        // 5,6,7,1,2,3,4

        reverse(arr, 0, n - 1);   //reverse full array 
        reverse(arr, 0, k - 1);   //reverse 0 to k-1 array
        reverse(arr, k, n - 1);   // reverse k to n-1 array
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
