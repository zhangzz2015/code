class MinHeap {
	private int[] array;
	private int size;

	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array cannot be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify();
	}

	private void heapify() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}

	public MinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity cannot be less than 0");
		}
		array = new int[cap];
		size = 0;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private boolean isFull() {
		return size == array.length;
	}

	private void percolateUp(int index) {
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (array[parentIndex] > array[index]) {
				swap(array, parentIndex, index);
			} else {
				break;
			}
			index = parentIndex;
		}
	}

	private void percolateDown(int index) {
		while (index <= size / 2 - 1) {
			int leftChildIndex = index * 2 + 1;
			int rightChildIndex = index * 2 + 2;
			int swapCandidate = leftChildIndex;
			if (rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
				swapCandidate = rightChildIndex;
			}
			if (array[index] > array[swapCandidate]) {
				swap(array, index, swapCandidate);
			} else {
				break;
			}
			index = swapCandidate;
		}
	}

	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalArgumentException("heap is empty");
		}
		return array[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalArgumentException("heap is empty");
		}
		int res = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return res;
	}

	public void offer(int element) {
		if (size == array.length) {
			int[] newArray = new int[(int)(array.length * 1.5)];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[size] = element;
		size++;
		percolateUp(size - 1);
	}

	public int update(int index, int element) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("invalid index range");
		}
		int res = array[index];
		array[index] = element;
		if (res > element) {
			percolateUp(index);
		} else {
			percolateDown(index);
		}
		return res;
	}
}
