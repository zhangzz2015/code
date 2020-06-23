public class RotatedSearch {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < array[right]) {
                if (target > array[mid] && target <= array[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                if (target > array[mid] || target <= array[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0; // expexted output 4
        int target2 = 3; // expexted output -1
        RotatedSearch solution = new RotatedSearch();
        System.out.println(solution.search(input1, target1));
        System.out.println(solution.search(input1, target2));
    }
}