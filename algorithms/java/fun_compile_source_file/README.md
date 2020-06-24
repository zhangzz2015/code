### You are going to compile several source code files, but there are dependencies between them. What is the order to compile them?</br>e.g.</br>A import B, C</br>B import C</br>We can follow the order of C, B, A.</br>

First, we need to model this kind of dependencies into a graph. I think we can use the adjacency list to represent this graph. Because if we are finding the dependency in the source code files the dependency should be a sparse graph. Thus, using an adjacency matrix would be a waste of space.

Assume we don’t have a cycle dependency because that means we couldn't give an order.

To represent the source file we can use a class, and our input can be a List<SourceFile>, and we need to output a List<String>.

I think we are going to use topological sort to solve this problem.
