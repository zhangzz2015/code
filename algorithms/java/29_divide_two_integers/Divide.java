public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("divisor cannot be 0");
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        long lDividend = Math.abs((long)dividend);
        long lDivisor = Math.abs((long)divisor);
        
        int res = 0;
        long ceiling = getCeiling(lDividend, lDivisor);
        while (lDividend >= lDivisor) {
            if (ceiling * lDivisor <= lDividend) {
                res |= ceiling;
                lDividend -= ceiling * lDivisor;
            }
            ceiling >>= 1;
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return res;
        } else {
            return -res;
        }
    }

    private long getCeiling(long dividend, long divisor) {
        long ceiling = 1;
        while (ceiling * divisor <= dividend) {
            ceiling <<= 1;
        }
        return ceiling >> 1;
    }

    public static void main(String[] args) {
        int dividend1 = 10;
        int divisor1 = 3; // expect output 3
        int dividend2 = -2147483648; // Integer.MIN_VALUE
        int divisor2  = -1; // expect output 2147483647
        Divide solution = new Divide();
        System.out.println(solution.divide(dividend1, divisor1));
        System.out.println(solution.divide(dividend2, divisor2));
        System.out.println(Integer.MAX_VALUE);
    }
}