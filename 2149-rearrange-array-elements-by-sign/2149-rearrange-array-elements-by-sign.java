class Solution {
    public int[] rearrangeArray(int[] arr) {
        int n = arr.length;

        int[] neg = new int[n / 2];
        int[] pos = new int[n / 2];

        int negIndex = 0;
        int posIndex = 0;

        // Separate positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                neg[negIndex++] = arr[i];
            } else {
                pos[posIndex++] = arr[i];
            }
        }

        int low = 0;
        int high = 0;
        int k = 0;

        // Merge alternately
        while (low < neg.length && high < pos.length) {
            arr[k++] = pos[high++];
            arr[k++] = neg[low++];
        }

        return arr;
    }
}