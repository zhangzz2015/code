public class FindLocalMin {
    
    // solution1
    public int findLocalMin1(int[] array) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid - 1] > array[mid] && array[mid + 1] > array[mid]) {
                return mid;
            } else if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // postprocessing 1 or 2 element
        return array[left] < array[right] ? left : right;
    }

    // solution2
    public int findLocalMin2(int[] array) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 4, 5}; // expected output 1 or 2
        FindLocalMin solution = new FindLocalMin();
        System.out.println(solution.findLocalMin1(input));
        System.out.println(solution.findLocalMin2(input));
    }
}