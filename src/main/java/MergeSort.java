public class MergeSort {
    void merge(int[] arr, int l, int m, int r) {
        int lengthOfFirst = m - l + 1;
        int lengthOfSecond = r - m;

        //temporary arrays
        int[] L = new int[lengthOfFirst];
        int[] R = new int[lengthOfSecond];

        for (int i = 0; i < lengthOfFirst; ++i)
            L[i] = arr[l + i];
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

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Тестирование
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Исходный массив:");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nОтсортированный массив:");
        printArray(arr);
    }
}