class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enQueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.deQueue();
                pq.enQueue(new Freq(key, map.get(key)));
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.deQueue().e);
        }
        return res;
    }

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq < o.freq) {
                return 1;
            } else if (this.freq > o.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public class PriorityQueue<E extends Comparable<E>> implements MyQueue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
public interface MyQueue<E> {

    void enQueue(E e);

    E deQueue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
public class MaxHeap<E extends Comparable<E>> {

    private MyArrayGeneric<E> data;

    public MaxHeap() {
        data = new MyArrayGeneric<>();
    }

    public MaxHeap(int capacity) {
        data = new MyArrayGeneric<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new MyArrayGeneric<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesnt hava parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆添加元素 (shift up)
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //取最大值 shift down
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }

    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if ((j + 1) < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
                //data[j]是leftchild 和 rightchild最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("data.size = 0! ");
        }
        return data.get(0);
    }

    //取出最大，放入新元素
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }
    //将任意数组整理成堆的形状

}
    public class MyArrayGeneric<E> {

    private E[] data;
    private int size;

    public MyArrayGeneric() {
        this(10);
    }

    public MyArrayGeneric(int capcity) {
        data = (E[]) new Object[capcity];
    }

    public MyArrayGeneric(E[] arr) {
        size = arr.length;
        data = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            data[i] = arr[i];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数越界");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        E ret = data[index];
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("参数越界");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        return "MyArrayGeneric{" +
                "size=" + size +
                ", capacity=" + data.length +
                ", data=" + Arrays.asList(data).stream().filter(Objects::nonNull).collect(Collectors.toList()) +
                '}';
    }

    public int getCapacity() {
        return data.length;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }
}
}
