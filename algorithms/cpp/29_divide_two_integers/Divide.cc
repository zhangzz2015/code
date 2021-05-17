class Divide {
public:
	int divide(int dividend, int divisor) {
		bool sign = dividend < 0 == divisor < 0;
		long a = abs((long)dividend);
		long b = abs((long)divisor);
		if (b == 0) {
			return INT_MAX;
		}
		if (a < b) {
			return 0;
		}
		long res = longPositiveDivide(a, b);
		if (res > INT_MAX) {
			return sign ? INT_MAX : INT_MIN;
		} else {
			res = sign ? res : -res;
		}
		return (int)res;
	}
private:
	long longPositiveDivide(long a, long b) {
		long c;
		long sum = 0;
		while (a >= b) {
			c = b;
			long count = 1;
			while ((c << 1) <= a) {
				c <<= 1;
				count <<= 1;
			}
			sum += count;
			a -= c;
		}
		return sum;
	}
};
