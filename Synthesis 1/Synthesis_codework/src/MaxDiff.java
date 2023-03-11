public class MaxDiff {

    static int calcMaxDiff(int[] arr) {
        int min = arr[0];
        int max_diff = arr[0];
        int n = arr.length;
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if ((arr[i] - min) > max_diff) {
                max_diff = arr[i] - min;
                flag = true;
            }
        }

        if (!flag) {
            max_diff = 0;
        }
        return max_diff;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,2};

        System.out.println(calcMaxDiff(arr));

    }

}
