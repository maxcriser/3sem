class QuickSort {

    static <T extends Comparable<T>> void quickSort(T[] array, int start, int end) {
        int i = start, j = end;
        T pivot = array[(start + end) / 2];

        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }

            while (array[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                T tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

                i++;
                j--;
            }
        }

        if (start < j) {
            quickSort(array, start, j);
        }

        if (i < end) {
            quickSort(array, i, end);
        }
    }
}