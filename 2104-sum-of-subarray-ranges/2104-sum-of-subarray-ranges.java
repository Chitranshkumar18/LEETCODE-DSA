
class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        long minSum = 0;
        long maxSum = 0;

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long l = i - left[i];
            long r = right[i] - i;
            minSum += (long) arr[i] * l * r;
        }

        st.clear();

        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long l = i - left[i];
            long r = right[i] - i;
            maxSum += (long) arr[i] * l * r;
        }

        return maxSum - minSum;
    }
}
