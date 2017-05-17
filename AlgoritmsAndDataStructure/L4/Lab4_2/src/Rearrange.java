import java.util.Random;

public class Rearrange {

    private static Random random = new Random();

    public static void main(String[] args) {
        int sizeArray = 5;
        int maxRandom = 1000;
        int[] array = new int[sizeArray];

        for (int i = 0; i < sizeArray; i++) {
            array[i] = random.nextInt(maxRandom);
        }

        System.out.println("<-------ARRAY-------->");

        outArray(array);

        int[] equalArray = countEqualArray(array, sizeArray, maxRandom);
        int[] lessArray = countLessArray(equalArray, maxRandom);
        int[] sortedArray = sortRearrange(array, lessArray, sizeArray, maxRandom);

        System.out.println("<-------SORTED-------->");

        outArray(sortedArray);
    }

    private static int[] countEqualArray(int[] array, int n, int m) {
        int[] equal = new int[m];

        for (int i = 0; i < n; i++) {
            int key = array[i];
            equal[key]++;
        }

        return equal;
    }

    private static int[] countLessArray(int[] equal, int m) {
        int[] less = new int[m];
        less[0] = 0;

        for (int j = 1; j < m; j++) {
            less[j] = less[j - 1] + equal[j - 1];
        }

        return less;
    }

    private static int[] sortRearrange(int[] array, int[] less, int n, int m) {
        int[] b = new int[n];
        int[] next = new int[m];

        System.arraycopy(less, 0, next, 0, m);

        for (int i = 0; i < n; i++) {
            int key = array[i];
            int index = next[key];
            b[index] = array[i];
            next[key]++;
        }

        return b;
    }

    private static void outArray(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}