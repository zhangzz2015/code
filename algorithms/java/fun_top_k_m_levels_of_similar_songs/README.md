## Each song has <ID, rating, similar IDs><br>Given an ID, find the top k rated similar songs with at most m levels of similarity.

    e.g.
    <A, 25, <B, C>>
    <B, 50, <A, D>>
    <C, 80, <A>>
    <D, 90, <B>>
To better define this graph we need to make some assumptions.
1. This graph is an undirected graph. This means that if A is similar to B then B is also similar to A.
2. If there are multiple path to one node we consider the shortest path
The example can be represented as

                A
             /     \ 
            B       C 
           / 
          D
So we can use bfs to traverse the graph and only go to one node once in m levels. And we can keep track of the top k with a min heap. <br>
Cannot use dfs because it would hard to check visited, and we will count the same song a lot of times.<br>
time: O((# of m levels of songs) logk)<br>
space: O(k + (# of m levels of songs))