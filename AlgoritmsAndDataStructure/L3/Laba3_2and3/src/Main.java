import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'arraySize':");
        int arraySize = scanner.nextInt();

        Integer[] integerArray = getIntegerArray(arraySize);
        Double[] doubleArray = getDoubleArray(arraySize);
        String[] stringArray = getStringArray(arraySize);

        System.out.println("integerArray:");
        output(integerArray);
        System.out.println("doubleArray");
        output(doubleArray);
        System.out.println("stringArray");
        output(stringArray);

        int end = arraySize - 1;
        QuickSort.quickSort(integerArray, 0, end);
        QuickSort.quickSort(doubleArray, 0, end);
        QuickSort.quickSort(stringArray, 0, end);

        System.out.println("sortedIntegerArray");
        output(integerArray);
        System.out.println("\nsortedDoubleArray");
        output(doubleArray);
        System.out.println("\nsortedStringArray");
        output(stringArray);

        int integerSearch = integerArray[arraySize / 2];
        double doubleSearch = doubleArray[arraySize / 2];
        String stringSearch = stringArray[arraySize / 2];

        int integerIndexBinarySearch = BinarySearch.getSearchIndexBinary(integerArray, integerSearch);
        int doubleIndexBinarySearch = BinarySearch.getSearchIndexBinary(doubleArray, doubleSearch);
        int stringIndexBinarySearch = BinarySearch.getSearchIndexBinary(stringArray, stringSearch);

        int integerIndexRecursiveBinarySearch = BinarySearch.getSearchIndexRecursiveBinary(integerArray, integerSearch, 0, end);
        int doubleIndexRecursiveBinarySearch = BinarySearch.getSearchIndexRecursiveBinary(doubleArray, doubleSearch, 0, end);
        int stringIndexRecursiveBinarySearch = BinarySearch.getSearchIndexRecursiveBinary(stringArray, stringSearch, 0, end);

        System.out.println("value: " + integerSearch + " binary id: " + integerIndexBinarySearch + " recursive binary id: " + integerIndexRecursiveBinarySearch);
        System.out.println("value: " + doubleSearch + " binary id: " + doubleIndexBinarySearch + " recursive binary id: " + doubleIndexRecursiveBinarySearch);
        System.out.println("value: " + stringSearch + " binary id: " + stringIndexBinarySearch + " recursive binary id: " + stringIndexRecursiveBinarySearch);
    }

    private static <T> void output(T[] array) {
        for (T anArray : array) {
            System.out.println(anArray + " ");
        }
    }

    private static Integer[] getIntegerArray(int n) {
        Random random = new Random();
        Integer result[] = new Integer[n];
        for (int z = 0; z < n; z++) {
            result[z] = random.nextInt(99);
        }
        return result;
    }

    private static Double[] getDoubleArray(int n) {
        Random random = new Random();
        Double result[] = new Double[n];
        for (int z = 0; z < n; z++) {
            result[z] = random.nextInt(99) + random.nextDouble();
        }
        return result;
    }

    private static String[] getStringArray(int n) {
        String[] result = new String[n];
        SecureRandom random = new SecureRandom();
        for (int z = 0; z < n; z++) {
            int size = random.nextInt(16);
            String str = "";
            for (int q = 0; q < size; q++) {
                str += (char) (random.nextInt(25) + 97);
            }
            result[z] = str;
        }

        return result;
    }
}
