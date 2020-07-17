import java.util.Collection;
import java.util.Collections;

public class MaxWeightSum {
    static class Element {
        int id;
        int weight;
        Element(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    // first original question
    public it maxWeightSumWithAnyPairOfIdLargerThanK(List<Element> elements, int k) {
        // Assumes input is valid and contains at least one element.
        int size = elements.size();
        int[] maxWeight = new int[size];
        int maxResult = Integer.MIN_VALUE;
        Collections.sort(elements, (a, b) -> Integer.compare(a.id, b.id));
        maxWeight[0] = elements.get(0).weight;
        for (int i = 1; i < size; i++) {
            Element curEle = elements.get(i);
            maxWeight[i] = curEle.weight;
            for (int j = i - 1; j >= 0; j--) {
                Element prevEle = elements.get(j);
                if (curEle.id - prevEle.id > k) {
                    maxWeight[i] = Math.max(maxWeight[i], curEle.weight + maxWeight[j]);
                }
            }
            maxResult = Math.max(maxResult, maxWeight[i]);
        }
        return maxResult;
    }

    // second follow up question
    public int maxWeightSumWithAnyPairOfIdSmallOrEqualsToK(List<Element> elements, int k) {
        // Assumes input is valid and contains at least one element.
        int size = elements.size();
        int leftPointer = 0;
        int curWeightSum = 0;
        int maxResult = Integer.MIN_VALUE;
        Collections.sort(elements, (a, b) -> Integer.compare(a.id, b.id));
        for (int rightPointer = 0; rightPointer < size; rightPointer++) {
            Element curEle = elements.get(rightPointer);
            curWeightSum += curEle.weight;
            while (curEle.id - elementd.get(leftPointer).id > k) {
                curWeightSum -= elements.get(leftPointer).weight;
            }
            maxResult = Math.max(maxResult, curWeightSum);
        }
        return maxResult;
    }
}