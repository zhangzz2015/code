class Queue<T> {
private T[] array;
    private int capacity;
    private int size;
    private int start;
    private int end;

    public Queue(int capacity) {
        this.capacity = capacity;
        size = 0;
        start = 0;
        end = 0;
        array = (T[]) new Object[capacity];
    }

    public void offer(T ele) {
        if (size == capacity) {
            resize();
        }
        array[end++] = ele;
        end = end % capacity;
        size++;
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T tmp = array[start];
        start = (start + 1) % capacity;
        size--;
        return tmp;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return array[start];
    }

    private void resize() {
        capacity *= 1.5;
        T[] tmp = (T[]) new Object[capacity];
        for (int i = 0; i <= size; i++) {
            tmp[i] = array[start];
            start = (start + 1) % size;
        }
        start = 0;
        end = size;
        array = tmp;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
		System.out.println(queue.size());
		System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
