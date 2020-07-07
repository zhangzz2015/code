class LengthOfLIS {
    public int lengthOfLIS1(int[] array) {
        if (array.length == 0) return 0;
        int[] dp = new int[array.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] array) {
        if (array.length == 0) return 0;
        int[] sequence = new int[array.length + 1];
        int res = 1;
        sequence[1] = array[0];
        for (int i = 1; i < array.length; i++) {
            int index = find(sequence, 1, res, array[i]);
            if (index == res) {
                sequence[++res] = array[i];
            } else {
                sequence[index + 1] = array[i];
            }
        }
        return res;
    }

    // find the largest smaller than the target
    private int find(int[] sequence, int left, int right, int target) {
        while (lefr + 1 < right) {
            int mid = left + (right - left) / 2;
            if (sequence[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        for (int j = right; j >= left; j--) {
            if (sequence[j] < target) {
                return j;
            }
        }
        return 0;
    }
}