public class RadixSort {
    public int[] radixSort(int[] arr) {
        int max = Integer.toString(findMax(arr)).length();
        
        for (int i = 0; i < max; i++) {
            arr = countSort(arr, i);
        }
        return arr;
    }

    public int[] countSort(int[] arr, int idx) {
        int[] indecies = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int x = ((int) (arr[i] / Math.pow(10, idx))) % 10;
            indecies[x]++;
        }

        int counter = 0;
        for (int i = 0; i < indecies.length; i++) {
            counter += indecies[i];
            indecies[i] = counter;
        }

        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = ((int) (arr[i] / Math.pow(10, idx))) % 10;
            sorted[indecies[x] - 1] = arr[i];
            indecies[x]--;
        }
        return sorted;
    }

    public int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {if (arr[i] > max) max = arr[i];}
        return max;
    }
}
