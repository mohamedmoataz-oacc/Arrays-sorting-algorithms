public class CountingSort {
    public int[] countSort(int[] arr) {
        int[] indecies = new int[findMax(arr) + 1];

        for (int i = 0; i < arr.length; i++) {indecies[arr[i]]++;}

        int counter = 0;
        for (int i = 0; i < indecies.length; i++) {
            counter += indecies[i];
            indecies[i] = counter;
        }

        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[indecies[arr[i]] - 1] = arr[i];
            indecies[arr[i]]--;
        }
        return sorted;
    }

    public int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {if (arr[i] > max) max = arr[i];}
        return max;
    }
}
