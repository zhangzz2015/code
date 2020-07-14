class HIndex {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        // need one more bucket for the numbers that are larger than length
        int[] counts = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                counts[citations.length] += 1;
            } else {
                counts[citations[i]] += Math.min(1, citations[i]);
            }
        }
        int citationCount = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            citationCount += counts[i];
            if (i <= citationCount) {
                return i;
            }
        }
        return -1;
    }
}