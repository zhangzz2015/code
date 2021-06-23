## compress + max rectangle in histogram
Using each row as the lower bound of the rectangle, and we can build the histogram. Thus we can use the approach in [84](./../84_largest_rectangle_histogram) to find the max rectangle in histogram.

time: O(m * n * n)<br>
space: O(n)
