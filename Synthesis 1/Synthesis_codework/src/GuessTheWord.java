import java.util.Arrays;
import java.util.Scanner;

public class GuessTheWord {

    private static int count = 0;
    private static String secret_word = "cat";
    int guessTheWord(String arr[], int l, int r, String x) {
        count++;

        if (r >= l) {
            int mid = l + (r - l) / 2;
            //System.out.println(arr[mid]);

            if (x.compareTo(arr[mid]) == 0)
                return mid;

            if (x.compareTo(arr[mid]) < 0)
                return guessTheWord(arr, l, mid - 1, x);

            return guessTheWord(arr, mid + 1, r, x);
        }

        return -1;
    }


    public static String findSecretWord(String[] dictionary, int k) {
        String[] subset = dictionary;
        for (int i = 0; i < k; i++) {
            String guess = subset[0];
            if (guess.equals(secret_word)) {
                return guess;
            } else if (guess.compareTo(secret_word) < 0) {
                subset = Arrays.copyOfRange(subset, subset.length/2, subset.length);
            } else {
                subset = Arrays.copyOfRange(subset, 0, subset.length/2);
            }
        }
        return null;
    }

    public static void main(String args[]) {

        GuessTheWord ob = new GuessTheWord();
        String arr[] = { "acting", "arcade", "attention", "axis", "boat", "cat", "drum", "eagle", "fence", "goat", "hike", "yacht", "zebra" };
        int n = arr.length;
        String x = "eagle";

        //System.out.println(findSecretWord(arr,n));

//
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

        int result = ob.guessTheWord(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);

        System.out.println("Count: " + count);
    }
}

