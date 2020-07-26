import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] slidingWindowMaximum(int[] array, int k) {
        if (array == null || array.length < k || k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[array.length - k + 1];
        for (int fast = 0; fast < array.length; ++fast) {
            while (!deque.isEmpty() && array[fast] > array[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(fast);
            if (fast >= k) {
                if (!deque.isEmpty() && deque.peekFirst() == fast - k) {
                    deque.pollFirst();
                }
            }
            if (fast >= k - 1) {
                res[fast - k + 1] = array[deque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, -1, 3, 5, 3, 6, 7}; // k = 3;
        // [3, 3, 5, 5, 6, 7]
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(solution.slidingWindowMaximum(input, 3)));
    }
}