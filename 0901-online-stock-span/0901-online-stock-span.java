class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int val) {
        int span = 1;

        while (!st.isEmpty() && st.peek()[0] <= val) {
            span += st.pop()[1];
        }

        st.push(new int[]{val, span});

        return span;
    }
}
