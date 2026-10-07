class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        helper(arr, 0, target, ans, res);

        return ans;
    }

    public void helper(int[] arr, int idx, int target,
                       List<List<Integer>> ans, List<Integer> res) {

        if (target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }

        if (target < 0 || idx == arr.length) {
            return;
        }

        // Take arr[idx]
        res.add(arr[idx]);

        helper(arr, idx, target - arr[idx], ans, res);

        res.remove(res.size() - 1);

        // Don't take arr[idx]
        helper(arr, idx + 1, target, ans, res);
    }
}