public class GeneralReservoirSampling {
    private final int k;
    private int count;
    private List<Integer> sample;

    public GeneralReservoirSampling(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k must be > 0");
        }
        this.k = k;
        this.count = 0;
        sample = new ArrayList<>();
    }

    public void read(int value) {
        count++;
        if (count <= k) {
            sample.add(value);
        } else {
            int random = (int)(Math.random() * count);
            if (random < k) {
                sample.set(random, value);
            }
        }
    }

    public List<Integer> sample() {
        return sample;
    }
}
