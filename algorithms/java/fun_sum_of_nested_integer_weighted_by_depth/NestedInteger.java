public class NestedInteger {
    
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
    
    // 1. global sum
    public int sum1(List<NestedInteger> input) {
        return sum1(input, 1, 0);
    }
    private int sum1(List<NestedInteger> input, int level, int sum) {
        // assume it cannot be null
        for (NestedInteger ni : input) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * level;
            } else {
                sum = sum(ni.getList(), level + 1, sum);
            }
        }
        return sum;
    }

    // 2. local sum
    public int sum2(List<NestedInteger> input) {
        return sum2(input, 1);
    }
    private int sum2(List<NestedInteger> input, int level) {
        // assume it cannot be null
        int sum = 0;
        for (NestedInteger ni : input) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * level;
            } else {
                sum += sum(ni.getList(), level + 1);
            }
        }
        return sum;
    }
}
