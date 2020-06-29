import  java.util.Random;

public class RandomGenerator {
    private int[] ranges;
	private final String[] symbols;
	private Random random;

	public RandomGenerator(String[] symbols, int[] weights) {
	    // validation @ constructor
	    this.symbols = symbols;
	    this.random = new Random();
	    ranges = new int[weights.length];
	    ranges[0] = weights[0];
	    for (int i = 1; i < weights.length; i++) {
	       ranges[i] = ranges[i - 1] + weights[i];
        }
    }

    public String getRandom() {
	    int randomWeight = random.nextInt(ranges[ranges.length - 1]);
	    return symbols[smallestLarger(randomWeight)];
    }

    private int smallestLarger(int randomWeight) {
	    int left = 0;
	    int right = ranges.length - 1;
	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        if (ranges[mid] > randomWeight) {
	        right = mid;
            } else {
	        left = mid + 1;
            }
        }
        return left;
	}
	
	public static void main(String[] args) {
		String[] symbols = {"A", "B", "C", "D"};
		int[] weights = {40, 30, 20, 10};
		RandomGenerator solution = new RandomGenerator(symbols, weights);
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		int total = 1000;
		for (int i = 0; i < total; i++) {
			String tmp = solution.getRandom();
			if (tmp == "A") a++;
			else if (tmp == "B") b++;
			else if (tmp == "C") c++;
			else d++;
		}
		System.out.println("percentage of A:" + a / total);
		System.out.println("percentage of B:" + b / total);
		System.out.println("percentage of C:" + c / total);
		System.out.println("percentage of D:" + d / total);
	}
}