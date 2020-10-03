import java.util.Map;
import java.util.HashMap;
class NumberOfPairs {
    
    public static int numberOfPairs(int[] p, int[] q, int target) {
        if (p == null || q == null || p.length == 0 || q.length == 0) return 0;
	    Map<Integer, Integer> window = new HashMap<>();
    	int left = 0;
    	int right = 0;
    	int res = 0;
    	int i = 0;
    	while (i < q.length) {
    		while (right < p.length && Math.abs(q[i] - p[right]) <= target) {
    	        window.put(p[right], window.getOrDefault(p[right], 0) + 1);
                right++;
            }
            while (left < right && Math.abs(q[i] - p[left]) > target) {
	            if (window.containsKey(p[left])) {
	                int count = window.get(p[left]);
            	    if (count == 1) window.remove(p[left]);
	                else window.put(p[left], count -1);
                }
            	left++;
            }
            res += window.size();
            while (i < q.length - 1 && q[i] == q[i + 1]) {
                i++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] p = new int[]{1, 1, 4, 6};
        int[] q = new int[]{2, 2, 8};
        System.out.println(Try.numberOfPair(p, q, 2)); // 3
        System.out.println(Try.numberOfPair(p, q, 4)); // 5
    }
}
