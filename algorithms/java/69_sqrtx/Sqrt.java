public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0;
        int right = x / 2;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square <= x) {
                left = (int)mid;
            } else {
                right = (int)(mid - 1);
            }
        }
        return (long)(right * right) <= x ? right : left;
    }
}