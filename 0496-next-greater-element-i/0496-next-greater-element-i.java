class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // arr2 ko right se left traverse karo
        for (int i = arr2.length - 1; i >= 0; i--) {
            // chhote ya barabar elements hata do
            while (!st.isEmpty() && st.peek() <= arr2[i]) {
                st.pop();
            }
            map.put(arr2[i], st.isEmpty() ? -1 : st.peek());
            st.push(arr2[i]);
        }

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = map.get(arr1[i]);
        }
        return res;
    }
}