class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        getPermutation(arr, 0, ans);
        return ans;
    }

    public void getPermutation(int[] arr, int idx,
                               List<List<Integer>> ans) {
        // Base case
        if (idx == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                temp.add(arr[i]);
            }
            ans.add(temp);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            getPermutation(arr, idx + 1, ans);
            // Backtracking
            swap(arr, idx, i);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}