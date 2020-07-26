import java.util.Arrays;

public class ProductKSlidingWindow {
    public int[] productKSlidingWindow(int[] array, int k) {
        int[] res = new int[array.length - k + 1];
        int product = 1;
        int numZeros = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == 0) numZeros++;
            else product *= array[fast];
            if (fast > k) {
                if (array[fast - k] == 0) numZeros--;
                else product /= array[fast - k];
            }
            if (fast >= k - 1) {
                if (numZeros == 0) res[fast - k + 1] = product;
                else res[fast - k + 1] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 0, 5, 0, 6, 7, 8}; // k = 3
        // [6, 0, 0, 0, 0, 0, 336]
        ProductKSlidingWindow solution = new ProductKSlidingWindow();
        System.out.println(Arrays.toString(solution.productKSlidingWindow(input, 3)));
    }
}