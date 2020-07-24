/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

public class MountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peakIndex = findPeak(mountainArr);
        int index = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(mountainArr, target, peakIndex + 1, len - 1, false);
    }
    
    private int findPeak(MountainArray mountainArr) {
        int len = mountainArr.length();
        int left= 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean asc) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (mountainArr.get(mid) < target) {
                if (asc) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (asc) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}