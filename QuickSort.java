import java.util.Arrays;

public class QuickSort {
    // [2, 1, 6, 3, 0, 1, 7, 9]
    //           |
    // [1, 0, 1, 2, 6, 3, 7, 9]
    //        |  |     |
    // [0, 1, 1, 2, 3, 6, 7, 9]
    //  |     |  |  |  |  |
    // [0, 1, 1, 2, 3, 6, 7, 9]

    /*  In place quick sort algorithm:
    *   let pivot be the first element in the array
    *
    * int[] quickSort(int[] arr, int pivot, int end):
    *     if (end == pivot) return arr
    *     let start = pivot
    *     for every element after start till the end:
    *         if element <= the pivot element: swap it to the left and increment pivot by one
    *
    *     return quickSort(quickSort(arr, start, pivot), pivot+1, end)
    */

    public void inPlaceSort(int[] arr) {System.out.println(Arrays.toString(inPlaceSort(arr, 0, arr.length)));}
    private int[] inPlaceSort(int[] arr, int pivot, int end) {
        if (end == pivot) return arr;

        int start = pivot;
        for (int i = start + 1; i < end; i++) {
            if (arr[i] <= arr[pivot]) {
                int index = i;
                while (index > pivot) {
                    int temp = arr[index];
                    arr[index] = arr[index-1];
                    arr[index-1] = temp;
                    index--;
                }
                pivot++;
            }
        }
        
        return inPlaceSort(inPlaceSort(arr, start, pivot), pivot+1, end);
    }

    public void recursiveQuickSort(int[] arr) {System.out.println(Arrays.toString(quickSort(arr)));}
    private int[] quickSort(int[] arr) {
        if (arr.length == 0) return arr;

        int pivot = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[pivot]) {
                int index = i;
                while (index > pivot) {
                    int x = arr[index];
                    arr[index] = arr[index-1];
                    arr[index-1] = x;
                    index--;
                }
                pivot++;
            }
        }

        int[] left = new int[pivot];
        int[] right = new int[arr.length - (pivot + 1)];
        for (int i = 0; i < arr.length; i++) {
            if (i < pivot) left[i] = arr[i];
            else if (i > pivot) right[i - (pivot + 1)] = arr[i];
        }

        left = quickSort(left);
        right = quickSort(right);
        for (int i = 0; i < arr.length; i++) {
            if (i < left.length) arr[i] = left[i];
            else if (i > left.length) arr[i] = right[i - left.length - 1];
        }

        return arr;
    }
}
