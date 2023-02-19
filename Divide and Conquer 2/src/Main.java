import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] c = {4,1,5};
        int k = 7;
        bucketSort(c);

        //countingSort(c,k);

        //mergesort(c, 0, n-1);

    }

    private static void mergesort(int[] c, int lower, int upper) {
        int mid = (lower + upper) / 2;
        mergesort(c, lower, mid);
        mergesort(c, mid+1, upper);
        merge(c, lower, mid, upper);
    }

    private static void merge(int[] c, int lower, int mid, int upper) {

    }

    public static void countingSort(int[] c, int k) {
        int n = c.length;
        int[] b = new int[n];
        int[] count = new int[k + 1];

        for (int i = 0; i < n; i++)
            count[c[i]]++;

        for (int i = 1; i <= k; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            b[count[c[i]] - 1] = c[i];
            count[c[i]]--;
        }

        for (int i = 0; i < n; i++)
            c[i] = b[i];

        for (int i = 0; i < n; i++)
            System.out.println(c[i]);
    }

    private static void bucketSort(int[] c) {
        int n = c.length;
        List<Integer>[] buckets = new List[2*n + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            buckets[c[i]].add(c[i]);
        }

        int j = 0;
        for (int i = 0; i <= 2*n; i++) {
            for (int k = 0; k < buckets[i].size(); k++) {
                c[j++] = buckets[i].get(k);
            }
        }

        for (int i = 0; i < n; i++)
            System.out.println(c[i]);

    }

}