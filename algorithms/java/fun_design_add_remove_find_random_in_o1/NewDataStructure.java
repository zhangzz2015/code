public class NewDataStructure {
    ArrayList<Integer> array; // resizable array
    HashMap<Integer, Integer> map;
    
    public NewDataStructure() {
        array = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void add(int x) {
        if (map.get(x) != null) return;
        int size = array.size();
        array.add(x);
        map.put(x, size);
    }

    public void remove(int x) {
        Integer index = map.get(x);
        if (index == null) return;
        map.remove(x);
        int size = array.size();
        Integer last = array.get(size - 1);
        Collections.swap(array, index, size - 1);
        array.remove(size - 1);
        map.put(last, index);
    }

    public getRandom() {
        return array.get(Math.random(array.size()));
    }

    public Integer find(int x) {
        return map.get(x);
    }
}
