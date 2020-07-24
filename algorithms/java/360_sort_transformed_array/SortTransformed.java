class SortTransformed {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        return sort(nums, a, b, c);
    }
    
    private int[] sort(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = a >= 0 ? nums.length - 1 : 0;
        while (left <= right) {
            int leftRes = calculate(nums[left], a, b, c);
            int rightRes = calculate(nums[right], a, b, c);
            if (a >= 0) {
                if (leftRes >= rightRes) {
                    res[i--] = leftRes;
                    left++;
                } else {
                    res[i--] = rightRes;
                    right--;
                }
            } else {
                if (leftRes >= rightRes) {
                    res[i++] = rightRes;
                    right--;
                } else {
                    res[i++] = leftRes;
                    left++;
                }
            }
        }
        return res;
    }
    
    private int calculate(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}
