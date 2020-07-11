public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (smaller(mid, m, n , k)) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private boolean smaller(int mid, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count < k;
    }
}