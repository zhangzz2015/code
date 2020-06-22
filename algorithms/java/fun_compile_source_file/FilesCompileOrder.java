import java.util.*;

public class FilesCompileOrder {
    static class SourceFile {
        String name;
        List<SourceFile> dependencies;
        public SourceFile(String name, List<SourceFile> dependencies) {
            this.name = name;
            this.dependencies = dependencies;
        }
    }
  
    // DFS solution
    public List<SourceFile> getCompileOrderDFS(List<SourceFile> files) {
        if (files == null) {
            throw new IllegalArgumentException("Input is null");
        }
        Set<SourceFile> visitedFiles = new HashSet<>();
        List<SourceFile> filesOrder = new ArrayList<>();
        for (SourceFile file : files) {
            getCompileOrderDFS(file, visitedFiles, filesOrder);
        }
        return filesOrder;
    }
    private void getCompileOrderDFS(SourceFile file, Set<SourceFile> visitedFiles, List<SourceFile> filesOrder) {
        if (!visitedFiles.add(file)) {
            return;
        }
        for (SourceFile dependency : file.dependencies) {
            getCompileOrderDFS(dependency, visitedFiles, filesOrder);
        }
        filesOrder.add(file);
    }
  
    // BFS solution
    public List<SourceFile> getCompileOrderBFS(List<SourceFile> files) {
        if (files == null) {
            throw new IllegalArgumentException("Input is null");
        }
        List<SourceFile> filesOrder = new ArrayList<>();
        Map<SourceFile, List<SourceFile>> graph = buildGraph(files);
        Map<SourceFile, Integer> indegree = getIndegree(files);
        Deque<SourceFile> queue = new ArrayDeque<>();
        initializeQueue(queue, files);
        while (!queue.isEmpty()) {
            SourceFile file = queue.poll();
            for (SourceFile dependency : graph.get(file)) {
                int count = indegree.get(dependency);
                if (count == 1) {
                    queue.offer(dependency);
                } else {
                    indegree.put(dependency, count - 1);
                }
            }
            filesOrder.add(file);
        }
        return filesOrder;
    }
  
    private Map<SourceFile, Integer> getIndegree(List<SourceFile> files) {
        Map<SourceFile, Integer> indegree = new HashMap<>();
        for (SourceFile file : files) {
            indegree.put(file, file.dependencies.size());
        }
        return indegree;
    }
  
    private void initializeQueue(Deque<SourceFile> queue, List<SourceFile> files) {
        for (SourceFile file : files) {
            if (file.dependencies.size() == 0) {
                queue.offer(file);
            }
        }
    }
  
    private Map<SourceFile, List<SourceFile>> buildGraph(List<SourceFile> files) {
        Map<SourceFile, List<SourceFile>> graph = new HashMap<>();
        for (SourceFile file : files) {
            graph.putIfAbsent(file, new ArrayList<>());
            for (SourceFile dependency : file.dependencies) {
                List<SourceFile> dependencyList =  graph.getOrDefault(dependency, new ArrayList<>());
                dependencyList.add(file);
                graph.put(dependency, dependencyList);
            }
        }
        return graph;
    }
  
    public static void main(String[] args) {
        SourceFile sourceFile1 = new SourceFile("file1", new ArrayList<>());
        SourceFile sourceFile2 = new SourceFile("file2", List.of(sourceFile1));
        SourceFile sourceFile3 = new SourceFile("file3", List.of(sourceFile1, sourceFile2));
        // Order: file1, file2, file3
        FilesCompileOrder filesCompileOrder = new FilesCompileOrder();
        List<SourceFile> order1 = filesCompileOrder.getCompileOrderDFS(List.of(sourceFile1, sourceFile2, sourceFile3));
        System.out.println("DFS:");
        for (SourceFile f : order1) {
            System.out.println("f = " + f.name);
        }
        System.out.println("BFS:");
        List<SourceFile> order2 = filesCompileOrder.getCompileOrderBFS(List.of(sourceFile1, sourceFile2, sourceFile3));
        for (SourceFile f : order2) {
            System.out.println("f = " + f.name);
        }
    }
  }