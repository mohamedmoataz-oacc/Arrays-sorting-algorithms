import java.util.Arrays;
import java.util.LinkedList;

public class BucketSort {
    public int[] bucketSort(int[] arr, int nbuckets) {
        int limit = findMax(arr) / nbuckets;
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] buckets = new LinkedList[nbuckets];
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] / limit != buckets.length)? arr[i] / limit: (arr[i] / limit) - 1;
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(arr[i]);
        }

        LinkedList<Integer> x = new LinkedList<>();
        for (LinkedList<Integer> bucket: buckets) {
            int[] sorted = listToArray(bucket);
            Arrays.sort(sorted);
            for (int i: sorted) {
                x.add(i);
            }
        }

        return listToArray(x);
    }

    public int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {if (arr[i] > max) max = arr[i];}
        return max;
    }

    public int[] listToArray(LinkedList<Integer> lst) {
        int[] to_return = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {to_return[i] = lst.get(i);}
        return to_return;
    }
}
