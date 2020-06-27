class SortTransformed {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (b > 0) {
                    res[i] = get(nums[i], a, b, c);
                } else {
                    res[nums.length - 1 - i] = get(nums[i], a, b, c);
                }
            }
            return res;
        }
        double mid = -b * 1.0 / a / 2;
        int left = largestSmallerEqual(nums, mid);
        int right = left + 1;
        if (a > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (right >= nums.length || left >= 0 && Math.abs(mid - nums[left]) < Math.abs(mid - nums[right])) {
                    res[i] = get(nums[left--], a, b, c);
                } else {
                    res[i] = get(nums[right++], a, b, c);
                }
            }
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (right >= nums.length || left >= 0 && Math.abs(mid - nums[left]) < Math.abs(mid - nums[right])) {
                   res[i] = get(nums[left--], a, b, c);
                } else {
                    res[i] = get(nums[right++], a, b, c);
                }
            }
        }
        return res;
    }

    private int get(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    private int largestSmallerEqual(int[] nums, double target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] <= target) return right;
        if (nums[left] <= target) return left;
        return -1;
    }
}