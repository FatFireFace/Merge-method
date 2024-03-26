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
}