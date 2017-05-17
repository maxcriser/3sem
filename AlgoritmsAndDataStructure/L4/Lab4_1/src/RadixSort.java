import java.util.Random;
import java.util.Scanner;

public class RadixSort {

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        System.out.print("Input 'n':  ");
        int n = Integer.parseInt(scanner.next());
        System.out.print("Input 'm':  ");
        int m = Integer.parseInt(scanner.next());

        System.out.println("<----------------------------->");

        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                builder.append((char) (random.nextInt(74) + 48));
            }
            array[i] = builder.toString();
            builder.delete(0, array[i].length());
        }

        for (String symbol : array) {
            System.out.println(symbol);
        }

        System.out.println("<----------------------------->");

        String[] sortedArray = radixSort(array, n);
        for (String symbol : sortedArray) {
            System.out.println(symbol);
        }
    }

    private static String[] radixSort(String[] array, int dimension) {
        for (int i = dimension - 1; i >= 0; i--) {
            array = countingSortForRadix(array, i);
        }
        return array;
    }

    private static String[] countingSortForRadix(String[] array, int position) {
        String[] result = new String[array.length];
        char min = array[0].charAt(position);
        char max = array[0].charAt(position);

        for (int i = 1; i < array.length; i++) {
            if (array[i].charAt(position) < min) {
                min = array[i].charAt(position);
            } else if (array[i].charAt(position) > max) {
                max = array[i].charAt(position);
            }
        }

        int[] counts = new int[max - min + 1];

        for (String symbol : array) {
            counts[symbol.charAt(position) - min]++;
        }

        counts[0]--;

        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            result[counts[array[i].charAt(position) - min]--] = array[i];
        }

        return result;
    }
}