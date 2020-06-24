public class FindMin {
    public int findMin(int[] array) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == array[right]) {
                right = right - 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] input1 = {1, 3, 5}; // expected 1
        int[] input2 = {2, 2, 2, 0, 1}; // expected 0
        FindMin solution = new FindMin();
        System.out.println(solution.findMin(input1));
        System.out.println(solution.findMin(input2));
    }
}