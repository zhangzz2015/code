# General Reservoir Sampling
We have unlimited flow or stream data elements. We need to sample k elements from this flow, such that at any point during the processing of the flow, we can return a random list of k elements from the n elements read so far.<br>
Assumption: k >= 1<br>
time: O(1) - amortized<br>
space: O(k)
