public class ReservoirSampling {
    // how many numbers have been read so far
    private int count;
    // only need to maintain the current sample
    private Integer sample;

    public ReservoirSampling() {
        this.count = 0;
        this.sample = null;
    }

    public void read(int value) {
        count++;
        int prob = (int)(Math.random() * count);
        // the current read value has the probability of 1 / count
        // to be as the current sample
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}
