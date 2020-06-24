public class SearchInsert {

    // solution 1: find the right most index where array[index] < target
    public int searchInsert(int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid - 1; // can also be right = mid
            } else  if (array[mid] < target){
                left = mid; // cannot be in [left, mid - 1]. cannot be left = mid + 1!!!
            } else {
                right = mid - 1; // can be merge into the first case 
            }
        }
        // postprocessing
        if (array[right] < target) return right + 1;
        if (array[left] < target) return left + 1;
        return 0; // left // it means all numbers in the original array >= target
    }

    // solution 2: find leftmost index where array[index] >= target
    public int searchInsert1(int[] array, int target) {
        if (array == null) {
            // coner case
            return 0;
        }
        if (array.length == 0) return 0; // base case. this assures that when postprocessing will not contain left 0 element
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid; // cannot be right = mid - 1!!!
            } else {
                left = mid + 1;
            }
        }
        // postprocessing: only left one element  left == right
        // can also be not exist
        // always assume the left element can be in any condition
        return array[left] >= target ? left : array.length; // left : left + 1
    }

    public static void main(String[] args) {
        int[] input1 = {1, 3, 5, 6};
        int target1 = 5; // expect return 2
        int[] input2 = {1, 3, 3, 3, 5, 6};
        int target2 = 3; // expect return 2
        int target3 = 7; // expect return 4
        SearchInsert solution = new SearchInsert();
        System.out.println(solution.searchInsert(input1, target1));
        System.out.println(solution.searchInsert(input2, target2));
        System.out.println(solution.searchInsert(input1, target3));
        System.out.println("**************");
        System.out.println(solution.searchInsert1(input1, target1));
        System.out.println(solution.searchInsert1(input2, target2));
        System.out.println(solution.searchInsert1(input1, target3));
    }
}