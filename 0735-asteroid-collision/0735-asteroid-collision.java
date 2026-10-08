class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // Current asteroid is moving left
            if (arr[i] < 0) {

                // Collision with right-moving asteroid
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -arr[i]) {
                    st.pop();
                }

                // Both have same size -> both explode
                if (!st.isEmpty() && st.peek() == -arr[i]) {
                    st.pop();
                }
                // Current asteroid survives
                else if (st.isEmpty() || st.peek() < 0) {
                    st.push(arr[i]);
                }

            } else {
                // Positive asteroid
                st.push(arr[i]);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}