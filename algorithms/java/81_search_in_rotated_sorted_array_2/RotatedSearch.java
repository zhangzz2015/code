public class RotatedSearch {
    public boolean search(int[] array, int target) {
        if (array == null || array.length == 0) return false;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return true;
            if (array[mid] == array[right]) {
                right = right - 1;
            } else if (array[mid] < array[right]) {
                if (target > array[mid] && target < array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > array[mid] || target < array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0; // expected true
        int target2 = 3; // expected false
        RotatedSearch solution = new RotatedSearch();
        System.out.println(solution.search(input, target1));
        System.out.println(solution.search(input, target2));
    }
}