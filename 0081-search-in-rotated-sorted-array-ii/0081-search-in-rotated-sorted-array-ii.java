class Solution {
    public boolean search(int[] arr, int target) {
        int l = 0, h = arr.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] == target) {
                return true;
            }

            // Duplicate elements
            if (arr[l] == arr[mid] && arr[mid] == arr[h]) {
                l++;
                h--;
                continue;
            }

            // Left half is sorted
            if (arr[l] <= arr[mid]) {
                if (arr[l] <= target && target < arr[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            // Right half is sorted
            else {
                if (arr[mid] < target && target <= arr[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return false;
    }
}