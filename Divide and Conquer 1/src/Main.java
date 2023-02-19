import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter file name (ex. input.txt) :");
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        //file operations
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./" + in));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            return;
        }
        String row;
        try {
            row = reader.readLine();
        } catch (IOException e) {
            System.out.println("File format not correct.");
            return;
        }

        //extracting file elements in String array
        String[] elements = new String[0];
        while (row != null) {
            elements = row.split(",");
            try {
                row = reader.readLine();
            } catch (IOException e) {
                System.out.println("File format not correct.");
                return;
            }
        }

        //obtaining input array
        int length = elements.length;
        if (length < 1) {
            System.out.println("File empty. Please provide valid input.");
            return;
        }
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(elements[i]);
            if (a[i] < -10 || a[i] > 10) {
                System.out.println("Please input numbers in range [-10,10].");
                return;
            }
            System.out.println(a[i]);
        }

        int max = a[0];
        int product = 0;
        boolean flag = false;

        for (int i = 0; i < length - 1; i++) {
            product = a[i];
            for (int j = i + 1; j < length; j++) {
                if (product > max) {
                    max = product;
                    flag = true;
                }
                product = product * a[j];
            }
            if (product > max) {
                max = product;
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("Largest product: " + 0);
            return;
        }
        System.out.println("Largest product: " + max);
    }
}