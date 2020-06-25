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
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, 0, n - 1);
        int leftRes = binarySearch(mountainArr, 0, peak, target, true);
        if (leftRes != -1) return leftRes;
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
     }
 
     private int findPeak(MountainArray mountainArr, int left, int right) {
         while (left < right) {
             int mid = left + (right - left) / 2;
             if (mountainArr.get(mid) < mountainArr.get(mid + 1)){
                 left = mid + 1;
             } else {
                 right = mid;
             }
         }
         return left;
     }
 
     private int binarySearch(MountainArray mountainArr, int left, int right, int target, boolean isAscending) {
         while (left <= right) {
             int mid = left + (right - left) / 2;
             if (mountainArr.get(mid) == target) {
                 return mid;
             } else if (mountainArr.get(mid) < target) {
                 if (isAscending) left = mid + 1;
                 else right = mid - 1;
             } else {
                 if (isAscending) right = mid - 1;
                 else left = mid + 1;
             }
         }
         return -1;
     } 
}