class BinarySearch {

    static <T extends Comparable<T>> int getSearchIndexBinary(T[] array, T searchValue){
        int max = array.length - 1;
        int min = 0;
        while(min < max){
            int middle = (min + max) / 2;
            if(array[middle].compareTo(searchValue) == 0) return middle;
            else if(array[middle].compareTo(searchValue) > 0) max = middle - 1;
            else min = middle + 1;
        }
        return -1;
    }

    static <T extends Comparable<T>> int getSearchIndexRecursiveBinary(T[] array, T x, int min, int max){
        if(min > max) {
            return -1;
        }
        int middle = (min + max) / 2;
        if(array[middle].compareTo(x) == 0) return middle;
        else if(array[middle].compareTo(x) > 0) return getSearchIndexRecursiveBinary(array, x, min, middle - 1);
        else return getSearchIndexRecursiveBinary(array, x, middle + 1, max);
    }
}