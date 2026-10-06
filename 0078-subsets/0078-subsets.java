class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        helper(arr, 0, res, ans);

        return ans;
    }

    public void helper(int[] arr, int idx, List<Integer> res, List<List<Integer>> ans) {

        if (idx == arr.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

        // Include arr[idx]
        res.add(arr[idx]);
        helper(arr, idx + 1, res, ans);

        // Exclude arr[idx]
        res.remove(res.size() - 1);
        helper(arr, idx + 1, res, ans);
    }
}

