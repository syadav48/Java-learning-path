package JavaCollectionTutorial.qns.List;

public class Q15_ArrayImplementation<E> {


        private E[] arr;       // internal array
        private int size = 0;  // current number of elements
        private static final int INITIAL_CAPACITY = 10;

        @SuppressWarnings("unchecked")
        public Q15_ArrayImplementation() {
            arr = (E[]) new Object[INITIAL_CAPACITY];
        }

        // --- Add element at the end ---
        public void add(E element) {
            ensureCapacity();
            arr[size++] = element;
        }

        // --- Get element at index ---
        public E get(int index) {
            checkIndex(index);
            return arr[index];
        }

        // --- Remove element at index ---
        public E remove(int index) {
            checkIndex(index);
            E removed = arr[index];

            // shift elements left
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }

            arr[size - 1] = null; // clear last element
            size--;
            return removed;
        }

        public int size() {
            return size;
        }

        // --- Internal helper: resize if needed ---
        @SuppressWarnings("unchecked")
        private void ensureCapacity() {
            if (size == arr.length) {
                E[] newArr = (E[]) new Object[arr.length * 2];
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                arr = newArr;
            }
        }

        private void checkIndex(int index) {
            if (index < 0 || index >= size)
                throw new IndexOutOfBoundsException("Index: " + index);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(arr[i]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }


}
