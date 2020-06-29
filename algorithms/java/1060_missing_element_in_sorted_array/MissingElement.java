class MissingElement {
    public int missingElement(int[] array, int k) {
        if (array == null || array.length == 0) return k;
        int offset = array[0];
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] - mid - offset >= k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (array[right] - right - offset < k) return k + right + offset;
        return k + left + offset;
    }

    public static void main(String[] args) {
        int[] input1 = {4, 7, 9, 10};
        int k1 = 1; // output 5
        int k2 = 3; // output 8
        int[] input2 = {1, 2, 4};
        int k3 = 3;
        MissingElement solution = new MissingElement();
        System.out.println(solution.missingElement(input1, k1));
        System.out.println(solution.missingElement(input1, k2));
        System.out.println(solution.missingElement(input2, k3));
    }
}