import java.util.Arrays;

public class MergeSort {
    void merge(int[] arr, int l, int m, int r) {
        int lengthOfFirst = m - l + 1;
        int lengthOfSecond = r - m;

        //temporary arrays
        int[] L = new int[lengthOfFirst];
        int[] R = new int[lengthOfSecond];

        System.arraycopy(arr, l + 0, L, 0, lengthOfFirst);
        for (int j = 0; j < lengthOfSecond; ++j)
            R[j] = arr[m + 1 + j];

        //index of begging of arrays
        int i = 0, j = 0;

        int k = l;
        while (i < lengthOfFirst && j < lengthOfSecond) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < lengthOfFirst) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < lengthOfSecond) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //merge sort for Sort() -method
    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }


    //тестовый метод
    void testAlgorithm(int[] currentArray){
        int[] notChangedArray = currentArray.clone();
        int[] expectedArray = currentArray.clone();
        Arrays.sort(expectedArray); //нативный метод сортировки класса Array - dual pivot quicksort

        this.sort(currentArray, 0, currentArray.length - 1);

        System.out.printf("\n unsorted array\t%s \n sorted array\t%s%n",
                Arrays.toString(notChangedArray), Arrays.toString(currentArray));

        if(! Arrays.equals(expectedArray, currentArray)){
            System.out.printf
                    ("failed:\n \t actual = %s\n \t excepted: %s%n",
                            Arrays.toString(currentArray), Arrays.toString(expectedArray));
        }
    }

    // Тестирование
    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        test.testAlgorithm(new int[]{});
        test.testAlgorithm(new int[]{1});
        test.testAlgorithm(new int[]{1, 10});
        test.testAlgorithm(new int[]{10, 1});
        test.testAlgorithm(new int[]{ -10, -1 });
        test.testAlgorithm(new int[]{ -10, 1, 10, -1 });
        test.testAlgorithm(new int[]{ 3, 2, -3, 1, -2, 0, -1});
    }
}