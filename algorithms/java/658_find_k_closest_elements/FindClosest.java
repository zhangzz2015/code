class FindClosest {
    // 1. find closest and go two side
    public List<Integer> findClosestElements1(int[] array, int k, int x) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int right = findSmallestLargerOrEquals(array, x);
        int left = right - 1;
        for (int i = 0; i < k; i++) {
            if (right >= array.length || left >= 0 && x - array[left] <= array[right] - x) {
                deque.offerFirst(array[left--]);
            } else {
                deque.offerLast(array[right++]);
            }
        }
        return new ArrayList<>(deque);
    }

    private int findSmallestLargerOrEquals(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] >= x ? left : array.length;
    }

    // 2. sliding window
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                queue.offer(array[i]);
                continue;
            }
            if (Math.abs(x - array[i - k]) > Math.abs(x - array[i])) {
                queue.poll();
                queue.offer(array[i]);
            }
        }
        return new ArrayList<>(queue);
    }

    // 3. two pointer
    public List<Integer> findClosestElements3(int[] array, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) {
            return res;
        }
        int left = 0;
        int right = array.length - 1;
        while (right - left >= k) {
            if (Math.abs(array[left] - x) > Math.abs(array[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = left; i <= right; i++) {
            res.add(array[i]);
        }
        return res;
    }
}

