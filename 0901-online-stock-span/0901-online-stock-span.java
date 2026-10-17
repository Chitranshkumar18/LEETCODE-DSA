class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int val) {
        int span = 1;

        while (!st.isEmpty() && st.peek()[0] <= val) {
            span += st.peek()[1];
            st.pop();
        }

        st.push(new int[]{val, span});

        return span;
    }
}
