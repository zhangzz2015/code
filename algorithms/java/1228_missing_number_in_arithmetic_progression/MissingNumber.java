public class MissingNumber {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == arr[0] + mid * diff) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (arr[right] == arr[0] + right * diff) return arr[right] + diff;
        return arr[left] + diff;
    }
}